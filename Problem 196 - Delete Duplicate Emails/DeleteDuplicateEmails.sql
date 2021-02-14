-- Algorithm is simple:
-- Find the min id
-- Select eveything of that id
-- Remove the rest

DELETE FROM Person
WHERE Id NOT IN 
    (
    SELECT * FROM
        (
        -- Don't put space after aggregate functions
        SELECT MIN(Id) 
        FROM Person
        GROUP BY Email
        )
    -- Have to use aliases for outer subqueries
    AS EmailsWithMinID
    )