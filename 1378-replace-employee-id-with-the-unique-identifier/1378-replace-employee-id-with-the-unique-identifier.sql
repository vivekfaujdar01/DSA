# Write your MySQL query statement below
SELECT EU.unique_id, E.name from Employees E Left Join EmployeeUNI EU ON E.id = EU.id;