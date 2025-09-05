# Write your MySQL query statement below

select t1.id as Id from Weather t1 join Weather t2 on Datediff(t1.recordDate,t2.recordDate) = 1 and t1.temperature > t2.temperature;

