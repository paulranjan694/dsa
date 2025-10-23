# Write your MySQL query statement below
select distinct num as ConsecutiveNums from (
    select num, 
    lead(num,1) over(order by id) as next1,
    lead(num,2) over(order by id) as next2
    from Logs
) t
WHERE num = next1 AND num = next2;