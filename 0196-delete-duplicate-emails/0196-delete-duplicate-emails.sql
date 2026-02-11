# Write your MySQL query statement below

delete from Person where id in ( 
    select id from (
        select id, dense_rank() over(partition by email order by id asc) as rnk from Person
    )t where t.rnk > 1
);

