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
class RotateListSolution {
  public ListNode rotateRight(ListNode head, int k) {
    /**
     * First we have to check if the head is null or not
     * Then, we need to find the number of nodes in the list
     * Afterwards, will find the nodeCount % k which will give us actual rotation
     * As it is a right rotation, we can find the number of nodes to be rotated 
     * by: nodeCount - actualRotation
     * Thus we need to point previous head with a pointer and 
     * previous node of the nodes which need to be rotated to 
     * another pointer (e.g: prevNode. It's next will be the new head).
     * Then assign prevNode's next to null.
     * Then need to connect with the last node of the rotated nodes to previous head pointer
     */


    // Check for null
    if (head == null) return null; 

    // If not null there must be at least one node
    ListNode lastNode = head;
    int nodeCount = 1;

    // Find the number of node and the lastNode
    while (lastNode.next != null) {
      nodeCount++;
      lastNode = lastNode.next;
    }

    int rotateCount = nodeCount <= k ? k % nodeCount : k;
    // return if there's no need to rotate
    if (rotateCount == 0) return head;

    ListNode pointer = head;
    int tillNode = nodeCount - rotateCount;
    ListNode prevNode = head; 

    /* We need to traverse before we reach till the nodes to be rotated
     * As we are reaching previous node, condition won't be tillNode > 0
     * For tillNode > 0 we will reach at the first node that needs to be rotated
     */
    while (tillNode > 1) { 
      tillNode--;
      prevNode = prevNode.next;
    }

    // Then re-arrange the list structure
    head = prevNode.next;
    prevNode.next = null;
    lastNode.next = pointer;

    return head;
  }
}