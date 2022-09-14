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
class SwappingNodesSolution {
  public ListNode swapNodes(ListNode head, int k) {
    /**
     * Approach: 
     * First, we will create a dummy head which next will be the given head.
     * Then, we will find out the kth node from both ends.
     * We have to find out the previous nodes of both of them (thus, created dummy head if k = 1).
     * Then just swap and plug in the nodes.
     * List won't be empty and k won't be out of bounds as per constraint:
     * 1 <= k <= n <= 105
     */

    ListNode dummyHead = new ListNode(-1, head);

    // First find out the kth node from the beginning
    ListNode currNode = dummyHead;
    ListNode firstKthPrev = null;
    ListNode firstKthNode = null;
    int count = 0; // We are starting from dummyhead
    while (count != k) {
      count++;
      if (count == k) {
        firstKthPrev = currNode;
      }
      currNode = currNode.next;
    }
    firstKthNode = firstKthPrev.next;

    // Then find out the kth node from the end
    ListNode lastKthPrev = dummyHead;
    ListNode lastKthNode = null;
    while (currNode.next != null) {
      lastKthPrev = lastKthPrev.next;
      currNode = currNode.next;
    }
    lastKthNode = lastKthPrev.next;

    // Now swap
    ListNode lastKthNext = lastKthNode.next;
    ListNode firstKthNext = firstKthNode.next;
    // Check if the kth nodes are adjacent or not
    if (lastKthPrev == firstKthNode) {
      firstKthPrev.next = lastKthNode;
      lastKthNode.next = firstKthNode;
      firstKthNode.next = lastKthNext;
    } else if (firstKthPrev == lastKthNode) {
      lastKthPrev.next = firstKthNode;
      firstKthNode.next = lastKthNode;
      lastKthNode.next = firstKthNext;
    } else {
      firstKthPrev.next = lastKthNode;
      lastKthPrev.next = firstKthNode;
      lastKthNode.next = firstKthNext;
      firstKthNode.next = lastKthNext;
    }

    return dummyHead.next;    
  }
}