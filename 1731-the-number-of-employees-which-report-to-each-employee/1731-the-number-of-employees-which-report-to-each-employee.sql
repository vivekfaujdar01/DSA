select e.employee_id, e.name,
r.cnt as reports_count, r.avg_age as average_age
from Employees e 
join (
    select reports_to, 
    count(*) as cnt, 
    round(avg(age), 0) as avg_age
    from Employees 
    where reports_to is not null
    group by reports_to
) as r
on e.employee_id = r.reports_to
order by employee_id