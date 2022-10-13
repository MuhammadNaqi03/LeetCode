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

class OddEvenListSolution {
  public ListNode oddEvenList(ListNode head) {
    /**
     * Approach: Creating sublists
     * First, we will check if the list length is less than 3.
     * If it is, then we will just return the list.
     * Otherwise, we will have a counter that will track the nodes' indices.
     * For even indices we will have a sublist and for odd indices we will have another sublist.
     * We will move the actual node from the given head so that the space complexity remains O(1).
     * Afterwards, we will merge the sublists and return the head of the new list.
     */
    
    if (head == null || head.next == null || head.next.next == null) {
      return head;
    }
 
    int counter = 1;   // Considering head node's index is 1
    ListNode oddHalfDummyHead = new ListNode();
    ListNode oddHalfCurr = oddHalfDummyHead;
    ListNode evenHalfDummyHead = new ListNode();
    ListNode evenHalfCurr = evenHalfDummyHead;
 
    while (head != null) {
      if (counter % 2 != 0) {
        oddHalfCurr.next = head;
        oddHalfCurr = head;
      } else {
        evenHalfCurr.next = head;
        evenHalfCurr = head;
      }
      head = head.next;
      counter++;
    }
 
    // Now join
    oddHalfCurr.next = evenHalfDummyHead.next;
    evenHalfCurr.next = null;
    evenHalfDummyHead.next = null;
    return oddHalfDummyHead.next;   
  }
}
