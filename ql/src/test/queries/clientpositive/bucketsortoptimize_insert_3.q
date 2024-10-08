--! qt:dataset:src
SET hive.vectorized.execution.enabled=false;
set hive.optimize.bucketmapjoin = true;
set hive.optimize.bucketmapjoin.sortedmerge = true;


set hive.exec.reducers.max = 1;
set hive.merge.mapfiles=false;
set hive.merge.mapredfiles=false; 

set hive.auto.convert.sortmerge.join.to.mapjoin=true;
set hive.cbo.fallback.strategy=NEVER;

-- Create two bucketed and sorted tables
CREATE TABLE test_table1_n19 (key INT, value STRING) PARTITIONED BY (ds STRING)
CLUSTERED BY (key) SORTED BY (key) INTO 2 BUCKETS;
CREATE TABLE test_table2_n18 (value STRING, key INT) PARTITIONED BY (ds STRING)
CLUSTERED BY (key) SORTED BY (key) INTO 2 BUCKETS;

FROM src
INSERT OVERWRITE TABLE test_table1_n19 PARTITION (ds = '1') SELECT *;

-- Insert data into the bucketed table by selecting from another bucketed table
-- The bucketing positions dont match - although the actual bucketing do.
-- This should be a map-only operation
EXPLAIN
INSERT OVERWRITE TABLE test_table2_n18 PARTITION (ds = '1')
SELECT x.value, x.key from 
(SELECT a.key, a.value FROM test_table1_n19 a WHERE a.ds = '1')x;

INSERT OVERWRITE TABLE test_table2_n18 PARTITION (ds = '1')
SELECT x.value, x.key from 
(SELECT a.key, a.value FROM test_table1_n19 a WHERE a.ds = '1')x;

select count(*) from test_table2_n18 where ds = '1';
select count(*) from test_table2_n18 tablesample (bucket 1 out of 2) s where ds = '1';
select count(*) from test_table2_n18 tablesample (bucket 2 out of 2) s where ds = '1';

CREATE TABLE test_table3_n10 (key INT, value STRING) PARTITIONED BY (ds STRING)
CLUSTERED BY (value) SORTED BY (value) INTO 2 BUCKETS;

-- Insert data into the bucketed table by selecting from another bucketed table
-- The bucketing positions dont match - this should be a map-reduce operation
EXPLAIN
INSERT OVERWRITE TABLE test_table2_n18 PARTITION (ds = '1')
SELECT x.key, x.value from 
(SELECT a.key, a.value FROM test_table1_n19 a WHERE a.ds = '1')x;

INSERT OVERWRITE TABLE test_table2_n18 PARTITION (ds = '1')
SELECT x.key, x.value from 
(SELECT a.key, a.value FROM test_table1_n19 a WHERE a.ds = '1')x;

select count(*) from test_table2_n18 where ds = '1';
select count(*) from test_table2_n18 tablesample (bucket 1 out of 2) s where ds = '1';
select count(*) from test_table2_n18 tablesample (bucket 2 out of 2) s where ds = '1';
