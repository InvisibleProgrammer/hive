--! qt:dataset:src
SET hive.vectorized.execution.enabled=false;
set hive.mapred.mode=nonstrict;
set hive.auto.convert.join=true;
set hive.auto.convert.sortmerge.join=true;
set hive.optimize.bucketmapjoin = true;
set hive.optimize.bucketmapjoin.sortedmerge = true;


set hive.exec.reducers.max = 1;
set hive.merge.mapfiles=false;
set hive.merge.mapredfiles=false; 
set hive.auto.convert.sortmerge.join.bigtable.selection.policy=org.apache.hadoop.hive.ql.optimizer.LeftmostBigTableSelectorForAutoSMJ;

set hive.auto.convert.sortmerge.join.to.mapjoin=true;
-- disable hash joins
set hive.auto.convert.join.noconditionaltask.size=10;
set hive.cbo.fallback.strategy=NEVER;

-- Create two bucketed and sorted tables
CREATE TABLE test_table1_n0 (key INT, value STRING) PARTITIONED BY (ds STRING)
CLUSTERED BY (key) SORTED BY (key) INTO 2 BUCKETS;
CREATE TABLE test_table2_n0 (key INT, value STRING) PARTITIONED BY (ds STRING)
CLUSTERED BY (key) SORTED BY (key) INTO 2 BUCKETS;
CREATE TABLE test_table3_n0 (key INT, value STRING) PARTITIONED BY (ds STRING)
CLUSTERED BY (key) SORTED BY (key) INTO 2 BUCKETS;

FROM src
INSERT OVERWRITE TABLE test_table1_n0 PARTITION (ds = '1') SELECT * where key < 10;

FROM src
INSERT OVERWRITE TABLE test_table2_n0 PARTITION (ds = '1') SELECT * where key < 100;

FROM src
INSERT OVERWRITE TABLE test_table1_n0 PARTITION (ds = '2') SELECT * where key < 10;

FROM src
INSERT OVERWRITE TABLE test_table2_n0 PARTITION (ds = '2') SELECT * where key < 100;

-- Insert data into the bucketed table by selecting from another bucketed table
-- This should be a map-only operation
EXPLAIN
INSERT OVERWRITE TABLE test_table3_n0 PARTITION (ds = '1')
SELECT a.key, concat(a.value, b.value) 
FROM test_table1_n0 a JOIN test_table2_n0 b 
ON a.key = b.key WHERE a.ds = '1' and b.ds = '1';

INSERT OVERWRITE TABLE test_table3_n0 PARTITION (ds = '1')
SELECT a.key, concat(a.value, b.value) 
FROM test_table1_n0 a JOIN test_table2_n0 b 
ON a.key = b.key WHERE a.ds = '1' and b.ds = '1';

select * from test_table3_n0 tablesample (bucket 1 out of 2) s where ds = '1';
select * from test_table3_n0 tablesample (bucket 2 out of 2) s where ds = '1';

-- Since more than one partition of 'a' (the big table) is being selected,
-- it should be a map-reduce job
EXPLAIN
INSERT OVERWRITE TABLE test_table3_n0 PARTITION (ds = '1')
SELECT a.key, concat(a.value, b.value) 
FROM test_table1_n0 a JOIN test_table2_n0 b 
ON a.key = b.key WHERE a.ds is not null and b.ds = '1';

INSERT OVERWRITE TABLE test_table3_n0 PARTITION (ds = '1')
SELECT a.key, concat(a.value, b.value) 
FROM test_table1_n0 a JOIN test_table2_n0 b 
ON a.key = b.key WHERE a.ds is not null and b.ds = '1';

select * from test_table3_n0 tablesample (bucket 1 out of 2) s where ds = '1';
select * from test_table3_n0 tablesample (bucket 2 out of 2) s where ds = '1';

-- Since a single partition of the big table ('a') is being selected, it should be a map-only
-- job even though multiple partitions of 'b' are being selected
EXPLAIN
INSERT OVERWRITE TABLE test_table3_n0 PARTITION (ds = '1')
SELECT a.key, concat(a.value, b.value) 
FROM test_table1_n0 a JOIN test_table2_n0 b 
ON a.key = b.key WHERE a.ds = '1' and b.ds is not null;

INSERT OVERWRITE TABLE test_table3_n0 PARTITION (ds = '1')
SELECT a.key, concat(a.value, b.value) 
FROM test_table1_n0 a JOIN test_table2_n0 b 
ON a.key = b.key WHERE a.ds = '1' and b.ds is not null;

select * from test_table3_n0 tablesample (bucket 1 out of 2) s where ds = '1';
select * from test_table3_n0 tablesample (bucket 2 out of 2) s where ds = '1';

-- This should be a map-only job
EXPLAIN
INSERT OVERWRITE TABLE test_table3_n0 PARTITION (ds = '1')
SELECT a.key, concat(a.value, b.value) 
FROM 
(select key, value from test_table1_n0 where ds = '1') a 
JOIN 
(select key, value from test_table2_n0 where ds = '1') b 
ON a.key = b.key;

INSERT OVERWRITE TABLE test_table3_n0 PARTITION (ds = '1')
SELECT a.key, concat(a.value, b.value) 
FROM 
(select key, value from test_table1_n0 where ds = '1') a 
JOIN 
(select key, value from test_table2_n0 where ds = '1') b 
ON a.key = b.key;

select * from test_table3_n0 tablesample (bucket 1 out of 2) s where ds = '1';
select * from test_table3_n0 tablesample (bucket 2 out of 2) s where ds = '1';

-- This should be a map-only job
EXPLAIN
INSERT OVERWRITE TABLE test_table3_n0 PARTITION (ds = '1')
SELECT a.key, concat(a.v1, b.v2) 
FROM 
(select key, concat(value, value) as v1 from test_table1_n0 where ds = '1') a 
JOIN 
(select key, concat(value, value) as v2 from test_table2_n0 where ds = '1') b 
ON a.key = b.key;

INSERT OVERWRITE TABLE test_table3_n0 PARTITION (ds = '1')
SELECT a.key, concat(a.v1, b.v2) 
FROM 
(select key, concat(value, value) as v1 from test_table1_n0 where ds = '1') a 
JOIN 
(select key, concat(value, value) as v2 from test_table2_n0 where ds = '1') b 
ON a.key = b.key;

select * from test_table3_n0 tablesample (bucket 1 out of 2) s where ds = '1';
select * from test_table3_n0 tablesample (bucket 2 out of 2) s where ds = '1';

-- This should be a map-reduce job
EXPLAIN
INSERT OVERWRITE TABLE test_table3_n0 PARTITION (ds = '1')
SELECT a.key+a.key, concat(a.value, b.value) 
FROM 
(select key, value from test_table1_n0 where ds = '1') a 
JOIN 
(select key, value from test_table2_n0 where ds = '1') b 
ON a.key = b.key;

INSERT OVERWRITE TABLE test_table3_n0 PARTITION (ds = '1')
SELECT a.key+a.key, concat(a.value, b.value) 
FROM 
(select key, value from test_table1_n0 where ds = '1') a 
JOIN 
(select key, value from test_table2_n0 where ds = '1') b 
ON a.key = b.key;

select * from test_table3_n0 tablesample (bucket 1 out of 2) s where ds = '1';
select * from test_table3_n0 tablesample (bucket 2 out of 2) s where ds = '1';
