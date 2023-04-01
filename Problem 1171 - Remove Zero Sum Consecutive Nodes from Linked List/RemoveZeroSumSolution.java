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
class Solution {
  public ListNode removeZeroSumSublists(ListNode head) {
    /**
     * Approach:
     * It's a prefix sum problem in which we have to find out the elements whose summation results in 0. 
     * So, as a starting point, we'll create a dummy head with a value of 0.
     * For each node, we'll save the prefix sum and the node inside a hashmap.
     * In the cases where nodes' summations result in 0, the prefix sum would already be present in the hashmap.
     * Example: 1 --> 2 --> 5 --> -3 --> -2 --> 1,
     * The prefix sum at the node with value 2 would be 3, and 
     * the prefix sum at the node with value -2 would be 3 as well.
     * So we need to remove those nodes in between.
     * And also, the entries of those nodes have to be removed from the hashmap as well.
     * Then, after traversing each node, we can just return the next node of the dummy head.
     */
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    HashMap <Integer, ListNode> valueMap = new HashMap<>();

    ListNode currNode = dummyHead;
    int prefixSum = 0;
    while (currNode != null) {
      prefixSum += currNode.val;

      // If the prefix sum is already present in the hashmap, that indicates a zero sum
      if (valueMap.containsKey(prefixSum)) {
        ListNode node = valueMap.get(prefixSum);
        ListNode nodeToRemove = node.next;
        int currSum = prefixSum;

        // Remove the nodes and their entries from the hashmap
        while (nodeToRemove != currNode) {
          currSum += nodeToRemove.val;
          valueMap.remove(currSum);
          nodeToRemove = nodeToRemove.next;
        }
        node.next = currNode.next;
      } else {
        valueMap.put(prefixSum, currNode);
      }
      currNode = currNode.next;
    }

    return dummyHead.next;
  }
}
