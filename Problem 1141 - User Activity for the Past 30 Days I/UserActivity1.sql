SELECT 
  activity_date AS day, 
  COUNT(
    DISTINCT(user_id)
  ) AS active_users 
FROM 
  Activity 
GROUP BY 
  activity_date 
HAVING 
  activity_date BETWEEN CAST('2019-06-28' AS DATE) 
  AND CAST('2019-07-27' AS DATE);
