--! qt:dataset:src
set hive.mapred.mode=nonstrict;
set datanucleus.cache.collections=false;
set hive.stats.autogather=true;
;
set hive.exec.reducers.max = 1;
set hive.cbo.fallback.strategy=NEVER;

CREATE TABLE bucket3_1_n0(key int, value string) partitioned by (ds string) CLUSTERED BY (key) INTO 2 BUCKETS;

explain
insert overwrite table bucket3_1_n0 partition (ds='1')
select * from src;

insert overwrite table bucket3_1_n0 partition (ds='1')
select * from src;

insert overwrite table bucket3_1_n0 partition (ds='1')
select * from src;

insert overwrite table bucket3_1_n0 partition (ds='2')
select * from src;

select * from bucket3_1_n0 tablesample (bucket 1 out of 2) s where ds = '1' order by key;

explain analyze table bucket3_1_n0 partition (ds) compute statistics;
analyze table bucket3_1_n0 partition (ds) compute statistics;

describe formatted bucket3_1_n0 partition (ds='1');
describe formatted bucket3_1_n0 partition (ds='2');
describe formatted bucket3_1_n0;
