-- The approach is to map all the employee
-- against their managers (so did self join)
-- and then compare against their salary
SELECT e1.Name AS Employee
FROM Employee e1
JOIN Employee e2
ON e1.ManagerID = e2.Id
WHERE e1.Salary > e2.Salary