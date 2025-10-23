WITH ranked AS (
    SELECT Id,
           ROW_NUMBER() OVER(PARTITION BY email ORDER BY id ASC) AS row_num
    FROM Person
)
DELETE FROM Person
WHERE Id IN (
    SELECT Id FROM ranked WHERE row_num > 1
);