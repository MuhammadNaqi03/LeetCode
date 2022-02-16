/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *   int val;
 *   TreeNode left;
 *   TreeNode right;
 *   TreeNode() {}
 *   TreeNode(int val) { this.val = val; }
 *   TreeNode(int val, TreeNode left, TreeNode right) {
 *     this.val = val;
 *     this.left = left;
 *     this.right = right;
 *   }
 * }
 */
class SameTreeSolution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    
   /**Approach 1: Recursive approach
   * Pretty trivial, First search if there exist null (null.val is not a property) 
   * and then send result accordingly.
   * Then check for the current nodes' vals' equality and 
   * also the left nodes' and right nodes' vals' equality.
   */
    
    if (p == null || q == null) {
    if (p == null && q == null) return true;
    else if (p == null && q != null) return false;
    else return false;
    }
    
    return (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
  }
}