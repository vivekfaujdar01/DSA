SELECT Department,
       Employee,
       Salary
FROM (
    SELECT d.name AS Department,
           e.name AS Employee,
           e.salary AS Salary,
           DENSE_RANK() OVER (
               PARTITION BY departmentId
               ORDER BY salary DESC
           ) AS rnk
    FROM Employee e
    JOIN Department d
    ON e.departmentId = d.id
) t
WHERE rnk = 1 or rnk = 2 or rnk = 3;