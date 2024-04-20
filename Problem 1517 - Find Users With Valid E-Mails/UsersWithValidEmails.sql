/**
 * Approach:
 * The prefix name must start with a letter: ^[a-zA-Z]
 * The prefix name may contain letters, digits, underscores, periods, and dashes: [a-zA-Z0-9_.-]*
 * The domain has to be a leetcode domain (don't forget to escape the special character '.'): @leetcode\\.com$
 */

SELECT
  *
FROM
  Users
WHERE
  mail REGEXP '^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode\\.com$';
