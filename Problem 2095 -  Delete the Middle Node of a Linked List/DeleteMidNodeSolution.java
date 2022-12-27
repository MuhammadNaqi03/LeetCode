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
class DeleteMidNodeSolution {
  public ListNode deleteMiddle(ListNode head) {
    /**
     * Approach 1: By counting list size
     * First check out if the list is empty or just has one node.
     * For this problem the middle node with a list with one node is that node itself.
     * So, we have to remove the node and return null.
     * (Ask the interviewer about what should you do with list with 1 node)
     * Find out the list size and the mid node's previous node.
     * Plug the mid's previous node with the mid's next.
     * Note about the middle node's index:
     * In this problem the middle node will be the floor(listSize/2)th node of a
     * list which index starts at 0.
     * Ask the interviewer which one will be the mid node for an even sized list.  
     */
 
    // if (head == null || head.next == null) {
    //   return null;
    // }
 
    // int listSize = 0;
    // ListNode currNode = head;
    // while (currNode != null) {
    //   listSize++;
    //   currNode = currNode.next;
    // }
 
    // int midNodeIndex = listSize/2;
    // int currentNodeIndex = 0;
    // ListNode midPrevNode = head;
 
    // // Loop till we find the mid node's previous node
    // while (currentNodeIndex < midNodeIndex - 1) {
    //   currentNodeIndex++;
    //   midPrevNode = midPrevNode.next;
    // }
 
    // // Now connect the mid node's previous node with mid node's next node
    // ListNode midNode = midPrevNode.next;
    // midPrevNode.next = midNode.next;
    // midNode.next = null;
 
    // return head;








    /**
     * Approach 2: Using two pointers
     * Same as approach 1, we will filter empty lists or lists with just one node.
     * As the mid node is the floor(listSize/2)th node with index starting at 0,
     * the mid node can be found with two pointer's - one moving 1 step and the other one two steps,
     * while checking if the fast pointer reaches to null or its next is null.
     * And the slow pointer will be the mid node while the loop is broken.
     * Here, we need to find the middle's previous node.
     * So, we will check if the fast pointer's next, its next's next, or its next's next's next is null.
     * Similar to finding the middle node, 
     * we will move the slow pointer 1 step and the fast pointer 2 steps at a time.
     * After the loop, the slow pointer will point to the middle node's previous node.
     * Then just connect mid's previous with mid's next node.
     */

    if (head == null || head.next == null) {
      return null;
    }
    
    ListNode fastPointer = head;
    ListNode slowPointer = head;

    while (fastPointer.next != null && fastPointer.next.next != null && fastPointer.next.next.next != null) {
      fastPointer = fastPointer.next.next;
      slowPointer = slowPointer.next;
    }

    ListNode midNode = slowPointer.next;
    slowPointer.next = midNode.next;
    midNode.next = null;

    return head;
  }
}
