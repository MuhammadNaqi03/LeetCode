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
class GCDLinkedListSolution {
  public ListNode insertGreatestCommonDivisors(ListNode head) {
    /**
     * All we need to do is keep track of the current node and the next node,
     * as we need to plug the node with GCD into it. To calculate GCD, we will use Euclidean algortihm.
     * https://en.wikipedia.org/wiki/Euclidean_algorithm
     */
  
    ListNode curr = head;
    ListNode currNext = curr.next;

    while (currNext != null) {
      int gcd = calculateGCD(curr.val, currNext.val);
      ListNode gcdNode = new ListNode(gcd, currNext);
      curr.next = gcdNode;
      curr = currNext;
      currNext = currNext.next;
    }

    return head;
  }

  public int calculateGCD(int firstVal, int secondVal) {
    if (secondVal == 0) {
      return firstVal;
    }

    return calculateGCD(secondVal, firstVal % secondVal);
  }
}
