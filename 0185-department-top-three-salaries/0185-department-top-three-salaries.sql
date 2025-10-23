-- select d.name as Department, e.name as Employee, e.salary as salary, dense_rank() over(partition by d.name order by salary desc) as rnk from Employee e join Department d on e.departmentId=d.id;

select d.name as Department, e.name as Employee, e.salary as salary from (
    select *, dense_rank() over(partition by departmentId order by salary desc) as rnk from Employee
 ) e join Department d on e.departmentId=d.id and e.rnk <= 3;