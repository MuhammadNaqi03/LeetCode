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
 *    }
 * }
 */
class BSTRangeSumSolution {
  public int rangeSumBST(TreeNode root, int low, int high) {
    /**
     * Approach 1: Recursive
     * If the root becomes null, we will just return 0.
     * Else, we will recursively add the node values of left subtree and right subtree
     * if those are within the range of high and low (inclusive)
     */
    
    // if (root == null) {
    //   return 0;
    // }

    // int sum = 0;
    // if (root.val >= low && root.val <= high) {
    //   sum = root.val;
    // }
    // sum = sum + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    // return sum;





    /**
     * Approach 2: Recursive (Optimized)
     * We can reduce the recursive calls here.
     * If the nodes value is more or equal to high value 
     * all other right subtree will be more than high value as well, as per constraint:
     * 'All Node.val are unique'.
     * Similarly, if the nodes value is less than or equal to low value,
     * all other right subtree will be less than low value as well.
     * We can reduce those calls.
     */
    
    if (root == null) {
      return 0;
    }
    
    int sum = 0;
    if (root.val >= low && root.val <= high) {
      sum = root.val;
    }

    if (root.val >= high) {
      sum = sum + rangeSumBST(root.left, low, high);
    } else if (root.val <= low) {
      sum = sum + rangeSumBST(root.right, low, high);
    } else {
      sum = sum + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
    return sum;





    /**
     * Approach 3: Iterative (DFS)
     * Firstly, check if the root is null.
     * If so, then return 0. Else, create a stack and push root into it.
     * Then, until the stack is empty, we will pop the current node and add its value if it's within the range.
     * To insert the left and right node of the current node, we will check like the previous approach.
     * We will only add the left subtree if the current node's value is greater than or equal to high.
     * Similarly, we will add only the right subtree if the current node's value is less than or equal to low.
     * And add both otherwise, given that the respective left and right node both or one is not null
     * in respect to the the cases.
     * After the stack becomes empty, we will return the sum.
     */
    
    // if (root == null) {
    //   return 0;
    // }

    // Stack <TreeNode> nodeStack = new Stack<>();
    // nodeStack.push(root);
    // int sum = 0;

    // while (!nodeStack.isEmpty()) {
    //   TreeNode currNode = nodeStack.pop();
    //   if (currNode.val >= low && currNode.val <= high) {
    //     sum = sum + currNode.val;
    //   }

    //   if (currNode.val <= low && currNode.right != null) { 
    //     // If the value is less than/equal to low, then just add the right node
    //     nodeStack.push(currNode.right);
    //   } else if (currNode.val >= high && currNode.left != null) {
    //     // If the value is greater than/equal to high, then just add the left node
    //     nodeStack.push(currNode.left);
    //   } else {
    //     // Else add both the right and left left node if they are not null
    //     if (currNode.left != null) {
    //       nodeStack.push(currNode.left);
    //     }
    //     if (currNode.right != null) {
    //       nodeStack.push(currNode.right);
    //     }
    //   }
    // }
    // return sum;





    /**
     * Approach 4: Iterative (BFS)
     * Same as approach 3, but we will use queue instead of stack.
     */

    // if (root == null) {
    //   return 0;
    // }

    // Queue <TreeNode> nodeQueue = new LinkedList<>();
    // nodeQueue.add(root);
    // int sum = 0;

    // while (!nodeQueue.isEmpty()) {
    //   TreeNode currNode = nodeQueue.remove();
    //   if (currNode.val >= low && currNode.val <= high) {
    //     sum = sum + currNode.val;
    //   }

    //   if (currNode.val <= low && currNode.right != null) { 
    //     // If the value is less than/equal to low, then just add the right node
    //     nodeQueue.add(currNode.right);
    //   } else if (currNode.val >= high && currNode.left != null) {
    //     // If the value is greater than/equal to high, then just add the left node
    //     nodeQueue.add(currNode.left);
    //   } else {
    //     // Else add both the right and left left node if they are not null
    //     if (currNode.left != null) {
    //       nodeQueue.add(currNode.left);
    //     }
    //     if (currNode.right != null) {
    //       nodeQueue.add(currNode.right);
    //     }
    //   }
    // }
    // return sum;
  }
}