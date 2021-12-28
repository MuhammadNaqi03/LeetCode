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
class LinkedListMiddleSolution {
/* First we need to start two pointers at the same point
 * The first one will go only next and the second one will go to next--> next
 * Thus we have to check if the seconde one and it's next become null
 * We will stop our loop there else we will end up with null pointer exception
 * At that point our first pointer reaches at the middle and will return that
 */
  public ListNode middleNode(ListNode head) {
    ListNode middle = head;
    ListNode runner = head;
    // Find the middle element
    while (runner != null && runner.next != null) {
      middle = middle.next;
      runner = runner.next.next;
    }
    return middle;
  }
}