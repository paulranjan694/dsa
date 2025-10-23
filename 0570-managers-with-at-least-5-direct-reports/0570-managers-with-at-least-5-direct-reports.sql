# Write your MySQL query statement below
select e.name as name from Employee e join (select managerId from Employee group by managerId HAVING COUNT(managerId) >= 5) as e1 on e.id=e1.managerId;