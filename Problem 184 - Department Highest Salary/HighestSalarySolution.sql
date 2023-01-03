/**
 * Approach:
 * Using a subquery, we will find out the max salary of the department of the current row
 * and will add that row if the salary matches with the salary fetched by the subquery.
 */
SELECT 
  d.name AS Department,
  e.name AS Employee,
  e.salary AS Salary
FROM
  Department AS d
JOIN
  Employee AS e
  ON d.id = e.departmentId
WHERE
  e.salary = (
    SELECT 
      MAX(salary) 
    FROM 
      Employee 
    WHERE 
      e.departmentId = departmentId
  );
