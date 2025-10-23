# Write your MySQL query statement below
select round(count(*)/(select count(distinct player_id) from Activity),2) as fraction from Activity a1 join (  select player_id, min(event_date) as f_login
    from activity 
    group by player_id) a2 on a1.player_id = a2.player_id
and datediff(event_date, f_login) = 1;

