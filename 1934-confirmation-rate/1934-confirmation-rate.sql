-- IFNULL() Handles users with no confirmations
-- Avoids integer division (1.0 *)
-- Counts only 'confirmed' actions -> sum(case when c.action = 'confirmed' then 1 else 0 end)
select s.user_id,
Round(
    IFNULL(
        1.0 * sum(case when c.action = 'confirmed' then 1 else 0 end)/count(c.action),
        0),   
    2)
as confirmation_rate
from Signups s left join Confirmations c
on s.user_id = c.user_id 
group by s.user_id  
