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
class PreorderSolution {
  public List<Integer> preorderTraversal(TreeNode root) {
    
    /** Approach 1: Iteratively using Stack
    * First we will put the root in the stack, if it's not null
    * Until the stack becomes empty we will pop and add the neighbors of the popped node
    * As stack follows LIFO, we will add the right node first and 
    * then the left node, if they are not null.
    */

//       ArrayList<Integer> preOrder = new ArrayList<>();
//       Stack<TreeNode> stack = new Stack<>();
//       if (root == null) return preOrder;

//       stack.push(root);

//       while (!stack.empty()) {
//         TreeNode poppedNode = stack.pop();
//         preOrder.add(poppedNode.val);
//         if (poppedNode.right != null) {
//           stack.push(poppedNode.right);
//         }
//         if (poppedNode.left != null) {
//           stack.push(poppedNode.left);
//         }
//       }
//       return preOrder;
    
    
    
    
    
    
    /** Approach 2: Using Arraylist's addAll() method
    * It will create instance of arraylist for every step which might be memory inefficient
    */
    
    // ArrayList<Integer> preOrder = new ArrayList<>();
    // if (root == null) return preOrder;
    // preOrder.add(root.val);
    // preOrder.addAll(preorderTraversal(root.left));
    // preOrder.addAll(preorderTraversal(root.right));
    // return preOrder;
    
    
    
    
    
    
    /** Approach 3: With a helper function
    * Will create one arraylist at the beginning and use that to store the node val
    * Also we don't need addAll method, as we are storing within one arraylist.
    */
    ArrayList<Integer> preOrder = new ArrayList<>();
    preOrderHelper(root, preOrder);
    return preOrder;
  }

  public void preOrderHelper(TreeNode root, ArrayList<Integer> preOrder) {
    if (root == null) return;
    preOrder.add(root.val);
    preOrderHelper(root.left, preOrder);
    preOrderHelper(root.right, preOrder);
  }
}