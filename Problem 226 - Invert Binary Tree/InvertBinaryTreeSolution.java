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
class InvertBinaryTreeSolution {
  public TreeNode invertTree(TreeNode root) {
    
    /**
     * Approach: Recursive
     * Simple approach - We will just swap every node's left and right
     * and return if the node becomes null
     */
    
//     if (root == null) {
//       return root;
//     }

//     TreeNode tempNode = root.left;
//     root.left = root.right;
//     root.right = tempNode;
//     invertTree(root.left);
//     invertTree(root.right);
//     return root;
    
    
    
    
    
    
    /**
     * Approach 2:
     * First we will check if the root is null or if it doesn't have both left and right children.
     * We don't need to do anything in these scenarios.
     * If not, then we will push/add the root to a stack/queue.
     * Until the stack/queue becomes empty, we will pop/remove one element.
     * Then for that element, we will swap the left and right child.
     * Then we will push/add the children if they are not null.
     * If we use stack - the process will be depth first.
     * If we use queue - the proces will be bread first
     */
    
    // Depth-first - Using Stack
//     if (root == null || (root.left == null && root.right == null)) {
//       return root;
//     }

//     Stack <TreeNode> nodeStack = new Stack<>();
//     nodeStack.push(root);

//     while (!nodeStack.isEmpty()) {
//       TreeNode currNode = nodeStack.pop();
//       TreeNode tempNode = currNode.left;
//       currNode.left = currNode.right;
//       currNode.right = tempNode;
//       if (currNode.right != null) {
//         nodeStack.push(currNode.right);
//       }
//       if (currNode.left != null) {
//         nodeStack.push(currNode.left);
//       }
//     }
//     return root;
    
    
    
    
    
    // Depth-first - Using Stack
    if (root == null || (root.left == null && root.right == null)) {
      return root;
    }

    Stack <TreeNode> nodeStack = new Stack<>();
    nodeStack.push(root);

    while (!nodeStack.isEmpty()) {
      TreeNode currNode = nodeStack.pop();
      TreeNode tempNode = currNode.left;
      currNode.left = currNode.right;
      currNode.right = tempNode;
      if (currNode.right != null) {
        nodeStack.push(currNode.right);
      }
      if (currNode.left != null) {
        nodeStack.push(currNode.left);
      }
    }
    return root;
  }
}