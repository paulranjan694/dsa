# Write your MySQL query statement below
-- select max(salary) AS SecondHighestSalary  from Employee where salary < (select max(salary) from Employee);

select max(salary) AS SecondHighestSalary from (select *, dense_rank() over(order by salary desc) as rnk from Employee) t where t.rnk = 2;
