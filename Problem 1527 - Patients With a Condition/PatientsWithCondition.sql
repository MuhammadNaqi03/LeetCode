/**
 * Approach:
 * For matching conditions that start with DIAB1 (e.g., DIAB100 MYOP): ^DIAB1
 * For matching conditions that start with something else,
 * where DIAB1 is separated by a space (e.g., ACNE DIAB100): .* DIAB1
 */

SELECT
  *
FROM
  Patients
WHERE
  conditions REGEXP '^DIAB1|.* DIAB1';
