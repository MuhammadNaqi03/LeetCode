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
  public ListNode swapPairs(ListNode head) {
    /** We have to consider 3 cases here:
    * Case 1: If head is null then return null
    * Case 2: If head.next is not null. Means the list has at least 2 nodes.
    * We will consider for only 2 nodes here to preserve the head reference.
    * Case 3: If more than 2 nodes appear, we will move to them after completing case 2.
    */
    if (head == null) return null;
    
    ListNode curr;
    ListNode prev;
    
    // At least 2 nodes are being present
    if (head.next != null) {
      curr = head.next;
      head.next = curr.next;
      curr.next = head;
      
      prev = head;         // Preserving the reference as it is needed to link after swapping for case 3
      head = curr;
      curr = prev.next;    // Move to 3rd Node or null
    } else {
      return head;
    }
    
    ListNode firstNode;
    ListNode secondNode;
    
    // Will loop until the 3rd node (or other successive odd nodes) is not null and it's next is not null.
    // If the 3rd node's (or other successive odd node's) next is null, 
    // it means total node numbers are odd and swapping is not needed for last node.
    while (curr != null && curr.next != null) {
      firstNode = curr;
      secondNode = curr.next;
      firstNode.next = secondNode.next;
      secondNode.next = firstNode;
      prev.next = secondNode;
      prev = firstNode;
      curr = firstNode.next;
    }
    
    return head;
  }
}