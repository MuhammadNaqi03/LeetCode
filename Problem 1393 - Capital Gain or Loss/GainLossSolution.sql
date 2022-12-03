/*
Approach:
As the problem states:
'It is also guaranteed that each 'Buy' operation for a stock has a 
corresponding 'Sell' operation in an upcoming day'
We can just add price when the operation is 'Sell' and 
deduct price when the operation is 'Buy'
While grouping the stock with the same name together.
*/

SELECT
  stock_name,
  SUM(
    CASE
      WHEN operation = 'Buy' THEN -price
      ELSE price
    END 
  ) AS capital_gain_loss
FROM
  Stocks
GROUP BY
  stock_name;