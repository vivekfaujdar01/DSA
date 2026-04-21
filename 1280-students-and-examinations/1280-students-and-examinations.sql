SELECT S.student_id, S.student_name, St.subject_name, Count(E.student_id) AS attended_exams
FROM Students S CROSS JOIN Subjects St LEFT JOIN Examinations E 
ON S.student_id = E.student_id AND St.subject_name = E.subject_name
GROUP BY S.student_id, S.student_name, St.subject_name
ORDER BY S.student_id ASC, St.subject_name ASC;