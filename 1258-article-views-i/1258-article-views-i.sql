# Write your MySQL query statement below
select distinct(v1.author_id) as id from Views v1 join Views v2 on v1.author_id = v2.viewer_id order by v1.author_id asc;