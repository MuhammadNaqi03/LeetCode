SELECT 
  teacher_id, 
  COUNT(
    DISTINCT(subject_id)
  ) as cnt 
from 
  Teacher 
GROUP BY 
  teacher_id;
