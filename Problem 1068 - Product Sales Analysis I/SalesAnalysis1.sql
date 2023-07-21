SELECT 
  p.product_name, 
  s.year, 
  s.price 
FROM
  product as p
  JOIN sales as s USING(product_id);
