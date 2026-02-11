CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
    select max(salary) from (select *, dense_rank() over(order by salary desc) as dr from Employee)t where t.dr=N
  );
END