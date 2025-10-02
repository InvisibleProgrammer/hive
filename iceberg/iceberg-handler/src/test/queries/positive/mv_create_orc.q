-- Creates a materialized view with metadata stored in Iceberg

set hive.support.concurrency=true;
set hive.txn.manager=org.apache.hadoop.hive.ql.lockmgr.DbTxnManager;
set hive.iceberg.materialized.view.metadata.location=iceberg;

drop materialized view if exists mv_create_orc;
drop table if exists ice_tbl_orc;

explain create table ice_tbl_orc (col1 int, col2 string) stored by iceberg stored as orc;

create table ice_tbl_orc (col1 int, col2 string) stored by iceberg stored as orc;
insert into ice_tbl_orc (col1, col2) values (1, 'Joe'), (2, 'Jack'), (3, 'Jill');

explain create materialized view mv_create_orc stored by iceberg stored as orc
as
select col1, col2 from ice_tbl_orc where col1 > 1;

create materialized view mv_create_orc stored by iceberg stored as orc
as
select col1, col2 from ice_tbl_orc where col1 > 1;

-- select * from ice_tbl_orc;
-- select * from mv_create_orc;

-- insert into ice_tbl_orc (col1, col2) values (4, 'Chuck');

-- create external table ice_ext_tbl_orc (col1 int, col2 string) stored by iceberg stored as orc;
-- insert into ice_ext_tbl_orc (col1, col2) values (1, 'Chuck');

-- select * from default.mv_create_orc.manifests;
