SELECT 
  e.name, 
  b.bonus 
FROM 
  Employee AS e 
  LEFT JOIN Bonus AS b USING(empId) 
WHERE 
  b.bonus IS NULL 
  OR b.bonus < 1000;
