# Write your MySQL query statement below
select s.user_id, Coalesce(ROUND(j.countCon/j.totalCon,2),0) as confirmation_rate from Signups s left join (
    select t.user_id, t.totalCon, c.countCon from 
    (select user_id, count(*) as totalCon from Confirmations group by user_id) as t 
    join 
    (select user_id, count(*) as countCon from Confirmations where action = 'confirmed' group by user_id) as c 
    on t.user_id = c.user_id
    ) as j 
    on s.user_id = j.user_id order by confirmation_rate asc;