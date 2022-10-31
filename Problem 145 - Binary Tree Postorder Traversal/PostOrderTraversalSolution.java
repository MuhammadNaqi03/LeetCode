/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class PostOrderTraversalSolution {
  public List<Integer> postorderTraversal(TreeNode root) {
    /**
     * Approach 1: Recursively using the addAll method
     * We will create a new arraylist in every recursive call
     * and return them at the end of the call.
     * Add those together and return the final arraylist.
     */
//     ArrayList<Integer> postOrder = new ArrayList<>();
//     if (root == null) {
//       return postOrder;
//     }
 
//     postOrder.addAll(postorderTraversal(root.left));
//     postOrder.addAll(postorderTraversal(root.right));
//     postOrder.add(root.val);
//     return postOrder;
    
    
    

    
    
    /**
     * Approach 2: Recursively using a helper method
     * The previous method was memory intensive and we can reduce that using a helper method.
     * Where instead of creating multiple arraylists, we will create a single one and add values into it recursively.
     */
    // ArrayList <Integer> postOrder = new ArrayList<>();
    // helperMethod(root, postOrder);
    // return postOrder;
    
    
    
    
    
    
    /**
     * Approach 3: Iteratively using Stack
     * We are using stack in here as it follows FIFO principle.
     * Firstly, if not null, we will push root to the stack.
     * We will create two linked lists for storing the traversal result (say, preOrder) and visited nodes (say, visited).
     * Until the stack becomes empty, we will run a loop.
     * Inside the loop, we will check if the last inserted node has left/right or both nodes and if they are not visited already.
     * If so, we will insert the left/right or both nodes to the stack and will add them to the visited arraylist.
     * If the node doesn't have any unvisited left/right node, or both left and right is null,
     * then we will pop the node and insert that into the preOrder arraylist.
     * After the loop ends, we will return the preOrder arraylist.
     */
    
    
    ArrayList <Integer> postOrder = new ArrayList<>();
    if (root == null) {
      return postOrder;
    }
 
    Stack <TreeNode> nodeStack = new Stack<>();
    ArrayList <TreeNode> visited = new ArrayList<>();
    nodeStack.push(root);
 
    while (!nodeStack.isEmpty()) {
      TreeNode lastNode = nodeStack.peek();
      if ((lastNode.right != null && !visited.contains(lastNode.right))
          || (lastNode.left != null && !visited.contains(lastNode.left))) {
        if (lastNode.right != null && !visited.contains(lastNode.right)) {
          nodeStack.push(lastNode.right);
          visited.add(lastNode.right);
        }
        if (lastNode.left != null && !visited.contains(lastNode.left)) {
          nodeStack.push(lastNode.left);
          visited.add(lastNode.left);
        }
      } else {
        postOrder.add(nodeStack.pop().val);
      }
    }
 
    return postOrder;
  }
  
//   public void helperMethod(TreeNode root, ArrayList<Integer> postOrder) {
//     if (root == null) {
//       return;
//     }
 
//     helperMethod(root.left, postOrder);
//     helperMethod(root.right, postOrder);
//     postOrder.add(root.val);
//   }
}