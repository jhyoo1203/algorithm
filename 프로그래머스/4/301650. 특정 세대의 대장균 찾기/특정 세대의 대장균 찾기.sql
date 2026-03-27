select ed3.id 
from ecoli_data ed1 
    join ecoli_data ed2 on ed1.id = ed2.parent_id
    join ecoli_data ed3 on ed2.id = ed3.parent_id
where ed1.parent_id is null
order by ed3.id;