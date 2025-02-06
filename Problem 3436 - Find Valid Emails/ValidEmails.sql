SELECT 
  user_id, 
  email 
FROM 
  USERS 
WHERE 
  email REGEXP '\w*@[a-zA-Z]*.com$' -- \w equivalent to [A-Za-z0-9_]
