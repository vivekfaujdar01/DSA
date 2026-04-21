SELECT V.customer_id, COUNT(V.customer_id) as count_no_trans
from Visits V left join Transactions T
ON V.visit_id = T.visit_id 
where T.visit_id is NULL and T.transaction_id is NULL
group by V.customer_id ;