SELECT
  v.customer_id,
  COUNT(*) as count_no_trans
FROM
  Visits as v
LEFT JOIN
  Transactions as t
  USING (visit_id)
WHERE
  t.amount IS NULL
GROUP BY
  v.customer_id;
