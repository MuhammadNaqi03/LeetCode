SELECT 
  project_id, 
  ROUND(
    AVG(e.experience_years), 
    2
  ) as average_years 
FROM 
  Employee AS e 
  JOIN Project AS p USING (employee_id) 
GROUP BY 
  p.project_id
