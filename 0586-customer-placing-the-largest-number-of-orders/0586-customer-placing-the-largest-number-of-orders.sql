# Write your MySQL query statement below

-- select * from Orders o join (select count(customer_number) as max,  customer_number from Orders group by customer_number)t on t.customer_number = o.customer_number;

select customer_number from Orders group by customer_number order by count(*) desc limit 1;