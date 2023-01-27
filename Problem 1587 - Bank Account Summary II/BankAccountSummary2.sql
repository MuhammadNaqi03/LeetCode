SELECT
  u.name,
  SUM(t.amount) AS balance
FROM
  Users AS u
INNER JOIN
  Transactions AS t
  USING (account)
GROUP BY
  u.name
HAVING
  balance > 10000;
