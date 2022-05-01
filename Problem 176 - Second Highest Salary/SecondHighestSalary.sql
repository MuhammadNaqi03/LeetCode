SELECT 
-- To check the value is null or not we wrap the query
-- Have to use DISTINCT in case of duplication
    IFNULL((SELECT DISTINCT Salary
            FROM Employee
            ORDER BY Salary DESC
            LIMIT 1,1),NULL)
            AS SecondHighestSalary
