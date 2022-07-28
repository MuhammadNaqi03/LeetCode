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
class RemoveElementsSolution {
  public ListNode removeElements(ListNode head, int val) {
    /**
     * Approach 1: Using pointers
     * First, return the head if the head is null.
     * Then find the valid head.
     * For that continue a loop until the head's val is not the given val.
     * If we reach null return null at this point.
     * Otherwise we get the valid head.
     * Afterwards, we will initialize two pointers.
     * One will point to head and other one will point to head's next.
     * Until the second pointer is not null, we will continue a loop.
     * Within the loop we will check if the second pointer's val is equal to given val or not.
     * If they are equal, we will move the second pointer to one step and connect it to the first pointer's next.
     * Otherwise, both of them will move one step.
     * After the loop ends, return the valid head.
     */
    
    if (head == null) {
      return head;
    }
    
    while (head.val == val) {
      head = head.next;
      if (head == null) {
        return head;
      }
    }
    
    ListNode firstPointer = head;
    ListNode secondPointer = head.next;
    while (secondPointer != null) {
      if(secondPointer.val != val) {
        firstPointer = secondPointer;
      } else {
        firstPointer.next = secondPointer.next;
      }
      secondPointer = secondPointer.next;
    }
    return head;
  }
}
