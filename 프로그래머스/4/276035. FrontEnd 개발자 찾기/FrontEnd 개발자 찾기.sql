with fe_skill as (
    select sum(code) as cnt from skillcodes where category = 'Front End'
)
select d.id, d.email, d.first_name, d.last_name
from developers d
join fe_skill on 1=1
where d.skill_code & fe_skill.cnt
order by d.id;