SELECT
  u.unique_id,
  e.name
FROM
  Employees as e
LEFT JOIN
  EmployeeUNI as u
  USING(id);
