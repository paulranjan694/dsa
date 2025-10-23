# Write your MySQL query statement below

select max(num) as num from (select num, count(*) over(partition by num) as freq from MyNumbers ) t where freq=1;