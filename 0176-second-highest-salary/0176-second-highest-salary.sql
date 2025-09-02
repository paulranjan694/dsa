# Write your MySQL query statement below
-- select max(salary) AS SecondHighestSalary  from Employee where salary < (select max(salary) from Employee);

select distinct max(salary) SecondHighestSalary 
from Employee 
where salary < (
    select max(salary) from Employee order by salary desc limit 1
);