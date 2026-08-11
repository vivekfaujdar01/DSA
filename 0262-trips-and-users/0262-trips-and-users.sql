# Write your MySQL query statement below
select
Request_at as Day,
round(sum(status in ('cancelled_by_driver', 'cancelled_by_client' ))/count(*),2) as 'Cancellation Rate'
from Trips
where client_id in (select users_id from Users where banned ='No')
and driver_id in (select users_id from Users where banned ='No')
and Request_at between '2013-10-01' and '2013-10-03'
group by Request_at