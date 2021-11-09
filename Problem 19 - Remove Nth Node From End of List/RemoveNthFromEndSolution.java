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
  /*
  * It's a two pointer problem where 
  * One pointer (runner) will move until n becomes 0
  * Then we will move both the pointers until runner.next becomes null
  * At that point the other pointer will be the prev node of the node to remove
  * For case like [1] n=1; [1,2] n=2;
  * We have to first check if list length and n is the same 
  * If so we will make head = head.next
  * We don't need to check if n is valid or if the list is empty as given:
  * 1 <= n <= sz
  */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    int count = 0;
    ListNode listSize = head;
    while (listSize != null) {
      listSize = listSize.next;
      count++;
    }
    if (n == count) {
      head = head.next;
      return head;
    }
    // If n and list size is not equal
    ListNode pointer = head;
    ListNode runner = head;
    while (n > 0) {
      runner = runner.next;
      n--;
    }
     
    while (runner.next != null) {
      pointer = pointer.next;
      runner = runner.next;
    }
    pointer.next = pointer.next.next;
    return head;
  }
}