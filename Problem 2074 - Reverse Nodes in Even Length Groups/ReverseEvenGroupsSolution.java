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
class ReverseEvenGroupsSolution {
  public ListNode reverseEvenLengthGroups(ListNode head) {
    /**
     * Approach:
     * If the list contains fewer than three nodes,
     * we can just return the head, as there's nothing to reverse.
     * Otherwise, we need to have four pointers here pointing to:
     * the current group's previous node (say, currGroupPrev),
     * the current group's first node (say, currGroupHead),
     * the current group's last node (say, currGroupTail).
     * and the current group's last node's next node (say, currGroupTailNext).
     * Also, we need to count the current group's number (say, currGroup)
     * and the number of nodes in the current group (say, nodesInCurrGroup).
     * We'll start from the second group, so the currGroupPrev will be the head of the linked list,
     * the currGroupHead and currGroupTail will be head.next, and the currGroupTailNext will be head.next.next.
     * The currGroup will be 2, and the nodesInCurrGroup will be 1 
     * as we're already pointing to the head of the current group which is not null.
     * Until the currGroupTailNext becomes null, we will run a loop, and inside the loop
     * we'll increment the nodesInCurrGroup and update the currGroupTail and currGroupTailNext.
     * Whenever the current group's node count becomes equal to the current group's number,
     * we'll reset the current group's node count and increment the current group's number.
     * Also, if the current group's number is even,
     * we have to reverse the corresponding nodes of the current group
     * and connect the reversed head to the currGroupPrev.
     * We also need to update the currGroupPrev and currGroupHead
     * regardless of whether the current group's number is even or odd.
     * After the loop ends, we still need to check if the last group needs to be reversed
     * (if the last group has an even number of nodes and has not been reversed already).
     */

    // Return the original list if the list contains fewer than three nodes
    if (head.next == null || head.next.next == null) { // The number of nodes in the list is in the range [1, 105]
      return head;
    }

    ListNode currGroupPrev = head;
    ListNode currGroupHead = head.next;
    ListNode currGroupTail = head.next;
    ListNode currGroupTailNext = head.next.next;
    int currGroup = 2;
    int nodesInCurrGroup = 1;

    while(currGroupTailNext != null) {
      currGroupTail = currGroupTailNext;
      currGroupTailNext = currGroupTailNext.next;
      nodesInCurrGroup += 1;
      if (nodesInCurrGroup == currGroup) {
        if (currGroup % 2 == 0) {
          ListNode revHead = revPartialList(currGroupHead, currGroupTailNext);
          currGroupPrev.next = revHead; // currGroupPrev.next = currGroupTail; would also work
          currGroupPrev = currGroupHead;
        } else {
          // Odd group, so just update the previous node for the next group
          currGroupPrev = currGroupTail;
        }
        currGroupHead = currGroupTailNext; // Update currGroupHead thus it points to the next group
        nodesInCurrGroup = 0; // The currGroupHead could be null, so don't update until the next iteration
        currGroup += 1;
      }
    }

    // If the last group is even and not reversed previousely (has less nodes than the group number)
    if (nodesInCurrGroup % 2 == 0) {
      ListNode revHead = revPartialList(currGroupHead, currGroupTailNext);
      currGroupPrev.next = revHead;
    }
    return head;
  }

  // Helper method
  public ListNode revPartialList(ListNode head, ListNode tailNext) {
	  ListNode revHead = tailNext;
	  while (head != tailNext) {
  	  ListNode nextNode = head.next;
  	  head.next = revHead;
      revHead = head;
      head = nextNode;
  	}
    return revHead;
  }
}
