# Write your MySQL query statement below

select x.student_id, x.student_name, x.subject_name, COALESCE(t.attended_exams,0) as attended_exams from (select * from Subjects ss cross join Students s order by student_id asc, subject_name asc)x left join
 (select *, count(*) as attended_exams from Examinations group by subject_name, student_id)t on x.student_id=t.student_id and x.subject_name=t.subject_name order by x.student_id, x.subject_name;
