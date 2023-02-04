-- Approach 1: Using CASE
-- SELECT
--   employee_id,
--   CASE
--     WHEN (employee_id % 2) != 0 AND LEFT(name, 1) != 'M' THEN salary
--     ELSE 0
--   END AS bonus
-- FROM
--   Employees
-- ORDER BY
--   employee_id;




/**
 * Approach 2: Without CASE
 * If the condition is true, we will eventually get 1.
 * Will get 0 if the condition fails.
 * So, we can just multiply the salary with returned result from the condition.
 */
SELECT
  employee_id,
  ((employee_id % 2) != 0  AND LEFT(name, 1) != 'M') * salary AS bonus
FROM
  Employees
ORDER BY
  employee_id;