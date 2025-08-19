create table source_tbl2(col_001 int, col_002 int, col_003 int, p1 int);

create view b_v_4 as
select *
from (select col_001, row_number() over (partition by src.p1) as r_num
        from source_tbl2 src) v1;
