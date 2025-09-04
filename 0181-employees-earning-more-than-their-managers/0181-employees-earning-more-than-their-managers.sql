# Write your MySQL query statement below

SELECT e.name as Employee from Employee e join Employee y on e.managerId=y.id where e.salary > y.salary;