# Write your MySQL query statement below

select emp_uni.unique_id, emp.name from Employees emp left join EmployeeUNI emp_uni on emp.id = emp_uni.id;
