-- Approach 1: Using GROUP BY
-- SELECT author_id AS id
-- FROM Views
-- WHERE author_id = viewer_id
-- GROUP BY author_id
-- ORDER BY author_id;




-- Approach 2: Using DISTINCT
SELECT DISTINCT author_id AS id
FROM Views
WHERE author_id = viewer_id
ORDER BY author_id;