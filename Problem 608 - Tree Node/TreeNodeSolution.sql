/**
 * Approach: Using Case
 * We have to check the following conditions:
 * If p_id is null, that means the node is the Root.
 * If node id is present in p_id, that means the node is an Inner node.
 * Otherwise, the node is not a parent of any node, thus leaf node.
 */

SELECT
  id,
  CASE
    WHEN p_id IS NULL THEN 'Root'
    WHEN id IN (SELECT p_id FROM Tree) THEN 'Inner'
    ELSE 'Leaf'
  END AS type
FROM
  Tree;
