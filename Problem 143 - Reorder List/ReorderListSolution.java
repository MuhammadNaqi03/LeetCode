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
class ReorderListSolution {
  public void reorderList(ListNode head) {
    /**
     * Approach 1: Using Stack
     * Firsly, Using two pointers we will move to the middle of the linked list.
     * For reaching the middle, we will move one pointer one step at a time (slowPointer)
     * and other pointer two steps at a time (fastPointer).
     * We will loop till the fastPointer's next or next's next becomes null.
     * After the loop ends, we will reach at the middle of the linked list and will make the middle node's next null.
     * We do that because, it will be the last node of the reordered list.
     * Then, we will put all the nodes after the middle node into a stack. 
     * Afterwards, we will start another loop untill the stack becomes emtpy.
     * Inside the loop, we will connect the L0 node with Ln node and the other nodes similarly.
     * We don't need to check for empty list as per constraint:
     * The number of nodes in the list is in the range [1, 5 * 104].
     */
    
    // ListNode slowPointer = head;
    // ListNode fastPointer = head;
    // while (fastPointer.next != null && fastPointer.next.next != null) {
    //   slowPointer = slowPointer.next;
    //   fastPointer = fastPointer.next.next;
    // }

    // ListNode slowPointerNext = slowPointer.next;
    // slowPointer.next = null;
    // slowPointer = slowPointerNext;
  
    // Stack<ListNode> stack = new Stack<>();
    // while(slowPointer != null) {
    //   stack.push(slowPointer);
    //   slowPointer = slowPointer.next;
    // }

    // ListNode currNode = head;
    // while (!stack.isEmpty()) {
    //   ListNode nextNode = currNode.next;
    //   ListNode poppedNode = stack.pop();
    //   currNode.next = poppedNode;
    //   poppedNode.next = nextNode;
    //   currNode = nextNode;
    // }






    /**
     * Approach 2: By reversing the latter half
     * We will find the middle node of the list just like the previous approach and 
     * will make the middle node's next to null as it will be the last node of the reordered list.
     * Then, we will reverse the latter half of the list.
     * Afterwards, till the reversed list becomes null we will run a loop,
     * and will add the first half's head with reversed half's head and so on.
     */
    
    ListNode slowPointer = head;
    ListNode fastPointer = head;
    while (fastPointer.next != null && fastPointer.next.next != null) {
      slowPointer = slowPointer.next;
      fastPointer = fastPointer.next.next;
    }

    ListNode slowPointerNext = slowPointer.next;
    slowPointer.next = null;
    slowPointer = slowPointerNext;
     
    ListNode reversedHead = null;
    while (slowPointer != null) {
      ListNode nextNode = slowPointer.next;
      slowPointer.next = reversedHead;
      reversedHead = slowPointer;
      slowPointer = nextNode;
    }

    ListNode currNode = head;
    while (reversedHead != null) {
      ListNode headNextNode = currNode.next;
      ListNode revHeadNextNode = reversedHead.next;
      currNode.next = reversedHead;
      reversedHead.next = headNextNode;
      currNode = headNextNode;
      reversedHead = revHeadNextNode;
    }
  }
}
