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
CREATE TABLE test_table1_n5 (key INT, value STRING) PARTITIONED BY (ds STRING)
CLUSTERED BY (key) SORTED BY (key) INTO 2 BUCKETS;
CREATE TABLE test_table2_n5 (key INT, value STRING) PARTITIONED BY (ds STRING)
CLUSTERED BY (key) SORTED BY (key) INTO 2 BUCKETS;

FROM src
INSERT OVERWRITE TABLE test_table1_n5 PARTITION (ds = '1') SELECT *;

-- Insert data into the bucketed table by selecting from another bucketed table
-- This should be a map-only operation
EXPLAIN
INSERT OVERWRITE TABLE test_table2_n5 PARTITION (ds = '1')
SELECT x.key, x.value from 
(
SELECT a.key, a.value FROM test_table1_n5 a WHERE a.ds = '1'
)x;

INSERT OVERWRITE TABLE test_table2_n5 PARTITION (ds = '1')
SELECT x.key, x.value from 
(
SELECT a.key, a.value FROM test_table1_n5 a WHERE a.ds = '1'
)x;

select count(*) from test_table2_n5 where ds = '1';
select count(*) from test_table2_n5 tablesample (bucket 1 out of 2) s where ds = '1';
select count(*) from test_table2_n5 tablesample (bucket 2 out of 2) s where ds = '1';

EXPLAIN
INSERT OVERWRITE TABLE test_table2_n5 PARTITION (ds = '1')
SELECT * from 
(
SELECT a.key, a.value FROM test_table1_n5 a WHERE a.ds = '1'
)x;

INSERT OVERWRITE TABLE test_table2_n5 PARTITION (ds = '1')
SELECT * from 
(
SELECT a.key, a.value FROM test_table1_n5 a WHERE a.ds = '1'
)x;

select count(*) from test_table2_n5 where ds = '1';
select count(*) from test_table2_n5 tablesample (bucket 1 out of 2) s where ds = '1';
select count(*) from test_table2_n5 tablesample (bucket 2 out of 2) s where ds = '1';

-- it should be a map-only job
EXPLAIN
INSERT OVERWRITE TABLE test_table2_n5 PARTITION (ds = '1')
SELECT x.key, concat(x.value, x.value) from 
(
SELECT a.key, a.value FROM test_table1_n5 a WHERE a.ds = '1'
)x;

-- it should be a map-reduce job
EXPLAIN
INSERT OVERWRITE TABLE test_table2_n5 PARTITION (ds = '1')
SELECT x.key+x.key, x.value from 
(
SELECT a.key, a.value FROM test_table1_n5 a WHERE a.ds = '1'
)x;

-- it should be a map-only job
EXPLAIN
INSERT OVERWRITE TABLE test_table2_n5 PARTITION (ds = '1')
SELECT x.k1, concat(x.v1, x.v1) from 
(
SELECT a.key as k1, a.value as v1 FROM test_table1_n5 a WHERE a.ds = '1'
)x;
