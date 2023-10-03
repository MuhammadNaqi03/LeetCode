SELECT
  p.product_name,
  SUM(o.unit) AS unit
FROM
  Products AS p
  JOIN Orders AS o USING (product_id)
WHERE
  order_date BETWEEN '2020-02-01'
  AND '2020-02-29'
GROUP BY
  product_id
HAVING
  unit >= 100;