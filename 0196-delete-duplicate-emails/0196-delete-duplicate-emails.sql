# Write your MySQL query statement below
-- delete from Person where (select id from Person group by email having count(*) > 1);

delete p1 from Person p1 join Person p2 on p1.email=p2.email and p1.id > p2.id;  

