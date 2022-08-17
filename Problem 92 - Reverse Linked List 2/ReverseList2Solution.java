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
class ReverseList2Solution {
  public ListNode reverseBetween(ListNode head, int left, int right) {
    /**
     * Approach: Iterative
     * First, we have to check if the value of left and right is the same or not.
     * If they are the same, we don't need to rotate anything and return the actual list.
     * Then we will run a loop and find out the right node (rightNode), 
     * right's next node (rightNext), and left's previous node (leftPrev).
     * Here, we don't need to verify if right and left are within the list size or negative as per constraint:
     * 1 <= left <= right <= n.
     * Then, we will loop from left node till right node and reverse the in between nodes.
     * Afterwards, if left > 1, we will connect the reversed nodes' head node with leftPrev.
     * Otherwise, we will return the reversed head.
     * We don't need to check for empty list as per constraint:
     * 1 <= n <= 500
     */

    if (left == right) {
      return head;
    }

    int count = 1;
    ListNode rightNode = head;
    ListNode leftPrev = null;
    while (count != right) {
      if (left - 1 == count) {
        leftPrev = rightNode;
      }
      rightNode = rightNode.next;
      count++;
    }
    ListNode rightNext = rightNode.next;

    // Now reverse from left node till right node
    ListNode revHead = rightNext;
    // If leftPrev is null that indicates that left = 1 and we have to start reversing from head
    ListNode currNode = leftPrev == null ? head : leftPrev.next ;
    while (currNode != rightNext) {
      ListNode nextNode = currNode.next;
      currNode.next = revHead;
      revHead = currNode;
      currNode = nextNode;
    }

    if (leftPrev == null) {
      return revHead;
    }

    // If leftPrev is not null that indicates that we did't reverse from head
    // Thus will have to connect revHead with leftPrev
    leftPrev.next = revHead;
    return head;
  }
}
