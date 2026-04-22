select query_name , 
Round(avg(rating/position), 2) as quality,
Round(100 * Sum(case when rating<3 then 1 else 0 end) / count(query_name), 2) as poor_query_percentage
from Queries 
group by query_name