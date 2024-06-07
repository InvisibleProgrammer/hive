/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hive.metastore.tools;

import edu.emory.mathcs.backport.java.util.Arrays;
import jline.internal.Log;
import org.apache.hadoop.hive.metastore.api.AbortTxnRequest;
import org.apache.hadoop.hive.metastore.api.DataOperationType;
import org.apache.hadoop.hive.metastore.api.LockComponent;
import org.apache.hadoop.hive.metastore.api.LockLevel;
import org.apache.hadoop.hive.metastore.api.LockRequest;
import org.apache.hadoop.hive.metastore.api.LockResponse;
import org.apache.hadoop.hive.metastore.api.LockState;
import org.apache.hadoop.hive.metastore.api.LockType;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.hadoop.hive.metastore.api.NoSuchTxnException;
import org.apache.hadoop.hive.metastore.api.TxnAbortedException;
import org.apache.hadoop.hive.metastore.txn.CompactionTxnHandler;
import org.apache.hadoop.hive.metastore.txn.TxnStore;
import org.apache.hadoop.hive.metastore.txn.TxnUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.thrift.TException;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.apache.hadoop.hive.metastore.tools.BenchmarkUtils.createASingleTable;
import static org.apache.hadoop.hive.metastore.tools.BenchmarkUtils.createManyTables;
import static org.apache.hadoop.hive.metastore.tools.BenchmarkUtils.dropManyTables;
import static org.apache.hadoop.hive.metastore.tools.Util.throwingSupplierWrapper;

public class ACIDBenchmarks {

  private static final Logger LOG = LoggerFactory.getLogger(CoreContext.class);

  @State(Scope.Benchmark)
  public static class CoreContext {
    @Param("1")
    protected int howMany;

    @State(Scope.Thread)
    public static class ThreadState {
      HMSClient client;

      @Setup
      public void doSetup() throws Exception {
        LOG.debug("Creating client");
        client = HMSConfig.getInstance().newClient();
      }

      @TearDown
      public void doTearDown() throws Exception {
        client.close();
        LOG.debug("Closed a connection to metastore.");
      }
    }

    @Setup
    public void setup() {
      LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
      Configuration ctxConfig = ctx.getConfiguration();
      ctxConfig.getLoggerConfig(CoreContext.class.getName()).setLevel(Level.INFO);
      ctx.updateLoggers(ctxConfig);
    }
  }

  @State(Scope.Benchmark)
  public static class TestOpenTxn extends CoreContext {

    @State(Scope.Thread)
    public static class ThreadState extends CoreContext.ThreadState {
      List<Long> openTxns = new ArrayList<>();

      @TearDown
      public void doTearDown() throws Exception {
        client.abortTxns(openTxns);
        LOG.debug("aborted all opened txns");
      }

      void addTxn(List<Long> openTxn) {
        openTxns.addAll(openTxn);
      }
    }

    @Benchmark
    public void openTxn(TestOpenTxn.ThreadState state) throws TException {
      state.addTxn(state.client.openTxn(howMany));
      LOG.debug("opened txns, count=", howMany);
    }
  }

  @State(Scope.Benchmark)
  public static class TestLocking extends CoreContext {
    private int nTables;

    @Param("0")
    private int nPartitions;

    private List<LockComponent> lockComponents;

    @Setup
    public void setup() {
      this.nTables = (nPartitions != 0) ? howMany / nPartitions : howMany;
      createLockComponents();
    }

    @State(Scope.Thread)
    public static class ThreadState extends CoreContext.ThreadState {
      List<Long> openTxns = new ArrayList<>();
      long txnId;

      @Setup(org.openjdk.jmh.annotations.Level.Invocation)
      public void iterSetup() {
        txnId = executeOpenTxnAndGetTxnId(client);
        LOG.debug("opened txn, id={}", txnId);
        openTxns.add(txnId);
      }

      @TearDown
      public void doTearDown() throws Exception {
        client.abortTxns(openTxns);
        if (BenchmarkUtils.checkTxnsCleaned(client, openTxns) == false) {
          LOG.error("Something went wrong with the cleanup of txns");
        }
        LOG.debug("aborted all opened txns");
      }
    }

    @Benchmark
    public void lock(TestLocking.ThreadState state) {
      LOG.debug("sending lock request");
      executeLock(state.client, state.txnId, lockComponents);
    }

    private void createLockComponents() {
      lockComponents = new ArrayList<>();

      for (int i = 0; i < nTables; i++) {
        for (int j = 0; j < nPartitions - (nPartitions > 1 ? 1 : 0); j++) {
          lockComponents.add(
            new Util.LockComponentBuilder()
              .setDbName("default")
              .setTableName(String.format("tmp_table_%d", i))
              .setPartitionName("p_" + j)
              .setShared()
              .setOperationType(DataOperationType.SELECT)
              .build());
        }
        if (nPartitions != 1) {
          lockComponents.add(
            new Util.LockComponentBuilder()
              .setDbName("default")
              .setTableName(String.format("tmp_table_%d", i))
              .setShared()
              .setOperationType(DataOperationType.SELECT)
              .build());
        }
      }
    }

    private static long executeOpenTxnAndGetTxnId(HMSClient client) {
      return throwingSupplierWrapper(() -> client.openTxn(1).get(0));
    }

    private void executeLock(HMSClient client, long txnId, List<LockComponent> lockComponents) {
      LockRequest req = new LockRequest(lockComponents, "hclient", "localhost");
      req.setTxnid(txnId);
      throwingSupplierWrapper(() -> client.lock(req));
    }
  }

  @State(Scope.Benchmark)
  public static class TestAllocateTableWriteIds extends CoreContext {
    String dbName = "test_db";
    String tblName = "tmp_table";

    @State(Scope.Thread)
    public static class ThreadState extends CoreContext.ThreadState {
      List<Long> openTxns = new ArrayList<>();
      long txnId;

      @Setup
      public void iterSetup() {
        txnId = executeOpenTxnAndGetTxnId(client);
        LOG.info("opened txn, id={}", txnId);
        openTxns.add(txnId);
      }

      @TearDown
      public void doTearDown() throws Exception {
        client.abortTxns(openTxns);
        if (BenchmarkUtils.checkTxnsCleaned(client, openTxns) == false) {
          LOG.error("Something went wrong with the cleanup of txns");
        }
        LOG.info("aborted all opened txns");
      }
    }

    @Benchmark
    public void allocateTableWriteIds(TestAllocateTableWriteIds.ThreadState state) throws TException {
      state.client.allocateTableWriteIds(dbName, tblName, state.openTxns);
    }

    private static long executeOpenTxnAndGetTxnId(HMSClient client) {
      return throwingSupplierWrapper(() -> client.openTxn(1).get(0));
    }
  }

  @State(Scope.Benchmark)
  public static class TestGetValidWriteIds extends CoreContext {

    String dbName = "test_db";
    String tblName = "table_%d";
    List<String> fullTableNames = new ArrayList<>();
    HMSClient client;

    @Setup
    public void doSetup() {
      try {
        client = HMSConfig.getInstance().newClient();
      } catch (Exception e) {
        LOG.error(e.getMessage());
      }

      try {
        client = HMSConfig.getInstance().newClient();
      } catch (Exception e) {
        LOG.error(e.getMessage());
      }

      try {
        if (!client.dbExists(dbName)) {
          client.createDatabase(dbName);
        }
      } catch (TException e) {
        LOG.error(e.getMessage());
      }

      LOG.info("creating {} tables", this.howMany);
      createManyTables(client, this.howMany, dbName, tblName);
      for (int i = 0; i < this.howMany; i++) {
        fullTableNames.add(dbName + ".table_" + i);
      }
    }

    @TearDown
    public void doTearDown() throws Exception {
      LOG.debug("dropping {} tables", howMany);
      dropManyTables(client, howMany, dbName, tblName);
    }

    @Benchmark
    public void getValidWriteIds(TestGetValidWriteIds.ThreadState state) throws TException {
      LOG.debug("executing getValidWriteIds");
      state.client.getValidWriteIds(this.fullTableNames);
    }
  }

  @State(Scope.Benchmark)
  public static class TestReadyToCleanAborts extends CoreContext {
    /*
      Steps to test:

        +
        +
        create a lock component on a partition (SHARED_WRITE
        create a lock state should be acquired
        abort the txn
        n times:
          create a lock component on a partition (SHARED_WRITE
          create a lock state should be acquired
        create a compaction request
        txnHandler.findNextToCompact
        updateCompactorState to a larger one
        findReadyToCleanAborts

     */
    String dbName = "test_db";
    String tblName = "table_ready_to_clean_aborts";
    HMSClient client;
    LockComponent lockComponent;
    List<Long> txnIds;

    @Setup
    public void doSetup() {
      client = throwingSupplierWrapper(() -> HMSConfig.getInstance().newClient());
      client.getHadoopConf().set("metastore.compactor.fetch.size", "1");

      // create a database
      if (!throwingSupplierWrapper(() -> client.dbExists(dbName))) {
        throwingSupplierWrapper(() -> client.createDatabase(dbName));
      }
//
//      txnIds = throwingSupplierWrapper(() -> client.openTxn(1));
//
//
//
////       create a table with a partition
//      LOG.info("creating table {}", tblName);
//      createASingleTable(client, dbName, tblName);
//
//      List<LockComponent> components = new ArrayList<>();
//      components.add(createLockComponent(LockType.SHARED_WRITE, LockLevel.DB, "mydb", "mytable", "mypartition=myvalue", DataOperationType.UPDATE));
//      components.add(createLockComponent(LockType.SHARED_WRITE, LockLevel.DB, "mydb", "yourtable", "mypartition=myvalue", DataOperationType.UPDATE));
//
//      LockRequest req = new LockRequest(components, "me", "localhost");
//      req.setTxnid(txnIds.get(0));
//      LockResponse res = throwingSupplierWrapper(() -> client.lock(req));
//
//      throwingSupplierWrapper(() -> client.abortTxns(txnIds));

//
//      // create a lock component on a partition (SHARED_WRITE)
//      lockComponent = new Util.LockComponentBuilder()
//              .setDbName(dbName)
//              .setSemiShared()
//              .setTableName(tblName)
//              .setPartitionName("date=2008-01-01")
//              .setOperationType(DataOperationType.UPDATE)
//              .build();
//
//      // acquire a txn
//
//
//      List<LockComponent> lockComponents = new ArrayList<>();
//      lockComponents.add(lockComponent);
//      LockRequest req = new LockRequest(lockComponents, "me", "localhost");
//      req.setTxnid(txnIds.get(0));
//
//      throwingSupplierWrapper(() -> client.lock(req));
//      throwingSupplierWrapper(() -> client.abortTxns(txnIds));




      Log.info("### - setup");
    }

    private LockComponent createLockComponent(LockType lockType, LockLevel lockLevel, String dbName, String tableName, String partitionName, DataOperationType dataOperationType){
      LockComponent lockComponent = new LockComponent(lockType, lockLevel, dbName);
      lockComponent.setTablename(tableName);
      lockComponent.setPartitionname(partitionName);
      lockComponent.setOperationType(dataOperationType);

      return lockComponent;
    }

    @TearDown
    public void doTearDown() throws Exception {
      LOG.debug("dropping table {}", tblName);
      throwingSupplierWrapper(() -> client.dropTable(dbName, tblName));

      Log.info("### - teardown");
    }

    @Benchmark
    public void testReadyToCleanAborts(TestGetValidWriteIds.ThreadState state) throws TException {
//      LOG.debug("executing getValidWriteIds");
//      state.client.getValidWriteIds(this.fullTableNames);
//
      CompactionTxnHandler compactionTxnHandler = new CompactionTxnHandler();
      compactionTxnHandler.setConf(client.getHadoopConf());
      compactionTxnHandler.findReadyToCleanAborts(1, 1);

      Log.info("### - test");
    }

  }
}

