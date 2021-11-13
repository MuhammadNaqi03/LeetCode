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
class ReverseLinkedListSolution {
  public ListNode reverseList(ListNode head) {
    // // Iterative approach:
    // ListNode revHead = null;
    // //Keeping the original head reference intact which is not necessary if not asked
    // ListNode n = head;
    // while (n!=null) {
    //     // This  nextNode ref is needed as we move the next pointer to revHead
    //     ListNode nextNode = n.next;
    //     n.next = revHead;
    //     revHead = n;
    //     n = nextNode;
    // }
    // //Iterative approach
    // return revHead;
      
    // Recursive approach:
    ListNode revHead = null;
    return recursiveReverse(head, revHead);
      
    }
  public ListNode recursiveReverse(ListNode head, ListNode revHead) {
    if (head==null) return revHead;
    ListNode nextNode = head.next;
    head.next = revHead;
    revHead = head;
    head = nextNode;
    return recursiveReverse(head,revHead);
  }
}