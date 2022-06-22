/**
 * Definition for singly-linked list.
 * public class ListNode {
 *   int val;
 *   ListNode next;
 *   ListNode() {}
 *   ListNode(int val) { this.val = val; }
 *   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MaxTwinSumSolution {
  public int pairSum(ListNode head) {
    /**
     * Approach 1: Using Arraylist (O(n) space complexity)
     * We will save every node's val to an ArrayList.
     * Then, we will have two pointers to point leftmost and rightmost indices.
     * Till leftmost is less than rightmost index, we will run a loop.
     * Find the max twin sum, return the max value.
     * Obviously, the two indices need to be shifted within the loop.
     * As per constraint - The number of nodes in the list is an even integer in the range [2, 105],
     * so we don't need to consider about empty list or list with odd number of nodes.
     */
 
 
//     ArrayList <Integer> nums = new ArrayList<>();
//     while (head != null) {
//       nums.add(head.val);
//       head = head.next;
//     }
 
//     int max = 0;
//     int localMax = 0;
//     int leftIndex = 0;
//     int rightIndex = nums.size() - 1;
//     while (leftIndex < rightIndex) {
//       localMax = nums.get(leftIndex) + nums.get(rightIndex);
//       if (localMax > max) {
//         max = localMax;
//       }
//       leftIndex++;
//       rightIndex--;
//     }
//     return max;
    
    
    
    
    /**
    * Approach 2: Reversing the linked list
    * We have to find the middle of the linked list.
    * Then reverse the latter part of the linked list and find max twin sum.
    * In this approach we will create a new list for the latter reversed half.
    * Thus will keep the given linked list intact but use O(n) extra space.
    */

    ListNode slowRunner = head;
    ListNode fastRunner = head;
    while (fastRunner.next.next != null) {
      slowRunner = slowRunner.next;
      fastRunner = fastRunner.next.next;
    }
    ListNode middleNode = slowRunner.next;
    
    // Reverse the latter middle part
    ListNode reverseHead = null;
    
    while (middleNode != null) {
      ListNode middleNodeNext = middleNode.next;
      middleNode.next = reverseHead;
      reverseHead = middleNode;
      middleNode = middleNodeNext;
    }
    
    int max = 0;
    int localMax = 0;
    while (reverseHead != null) {
      localMax = reverseHead.val + head.val;
      if (localMax > max) {
        max = localMax;
      }
      reverseHead = reverseHead.next;
      head = head.next;
    }
    return max;
  }
}