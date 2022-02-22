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
class InorderSolution {
  public List<Integer> inorderTraversal(TreeNode root) {
    // ArrayList <Integer> inOrder = new ArrayList <Integer>();
    // if (root != null) {
    // inOrder.addAll(inorderTraversal(root.left));
    // inOrder.add(root.val);
    // inOrder.addAll(inorderTraversal(root.right));
    // }
    // return inOrder;
    
    
    
    
    
    ArrayList <Integer> inOrder = new ArrayList <Integer>();
    helperMethod(root, inOrder);
    return inOrder;
  }

  void helperMethod(TreeNode root, ArrayList<Integer> inOrder) {
    if (root == null) return;
    helperMethod(root.left, inOrder);
    inOrder.add(root.val);
    helperMethod(root.right, inOrder);
 }
}