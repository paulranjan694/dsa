# Write your MySQL query statement below
#select max(salary) as SecondHighestSalary from Employee where salary < (select max(salary) from Employee);

#select max(salary) as SecondHighestSalary from Employee where salary < (select salary from Employee order by salary desc limit 1);

select max(salary) as SecondHighestSalary from (select * , dense_rank() over(order by salary desc) as dr from Employee) t where t.dr = 2;