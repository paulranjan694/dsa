# Write your MySQL query statement below
-- select student_id, subject_name, count(subject_name) from Examinations group by student_id, subject_name order by student_id, subject_name;

select s.student_id, s.student_name, s1.subject_name, COALESCE(j.attended_exams, 0) AS attended_exams from Students s cross join Subjects s1 left join (
    select student_id, subject_name, count(*) as attended_exams from Examinations 
    group by student_id, subject_name)as j 
    on s.student_id = j.student_id and s1.subject_name = j.subject_name order by s.student_id, s1.subject_name;