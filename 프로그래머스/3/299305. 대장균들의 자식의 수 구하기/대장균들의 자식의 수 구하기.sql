select p.ID ID, count(C.ID) CHILD_COUNT
from ECOLI_DATA p
left join ECOLI_DATA c
    on p.ID = c.PARENT_ID
group by P.ID
order by P.ID;