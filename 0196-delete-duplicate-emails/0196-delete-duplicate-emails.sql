DELETE p1
FROM Person p1
JOIN Person p2
ON p1.email = p2.email
AND p1.id > p2.id;

-- DELETE FROM Person
-- WHERE id NOT IN (
--     SELECT min_id
--     FROM (
--         SELECT MIN(id) AS min_id
--         FROM Person
--         GROUP BY email
--     ) AS t
-- );