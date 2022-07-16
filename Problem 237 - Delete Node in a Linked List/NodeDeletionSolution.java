/**
 * Definition for singly-linked list.
 * public class ListNode {
 *   int val;
 *   ListNode next;
 *   ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public void deleteNode(ListNode node) {
    /**
     * Approach: 
     * It's a weird problem indeed. 
     * The node which needs to be deleted is given as a param for a singly linked list.
     * Even the head of the linked list is not given.
     * Thus we can't find the previous node and link between the previous node and 
     * the next node of the node that needs to be deleted.
     * Thus, We can't delete the node but we can alter the value of the given node.
     * It is permitted as per the constraints which which say -
     * "The value of each node in the list is unique."
     * "The node to be deleted is in the list and is not a tail node."
     * So, we can just copy the next node's value to the node that has to be deleted (given node).
     * And then remove the next node of the given node and link between the given node and next node's next. 
     * Also we don't need to check for empty list as per constraint - 
     * "The number of the nodes in the given list is in the range [2, 1000]"
     */
    
    ListNode nextNode = node.next;
    node.val = nextNode.val;
    node.next = nextNode.next;
    nextNode = null;
  }
}
