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
class MergeNonZeroNodesSolution {
  public ListNode mergeNodes(ListNode head) {
    /**
     * It's a trivial problem, thanks to the constraints they give
     * For example: 
     * The number of nodes in the list is in the range [3, 2 * 105].
     * There are no two consecutive nodes with Node.val == 0.
     * The beginning and end of the linked list have Node.val == 0.
     * Meaning, We don't need to think about empty array (That won't hurt much tbh).
     * And we don't need to worry about if the sequence have only one 0 or no 0 or all 0s
     * as well as, we don't stress over handling multiple consecutive 0s.
     *
     
     * Approach 1: Out-of-place
     * First, we will create a dummy head to initialize the linked list.
     * Also we will have a counter to add the non-zero node values.
     * We will loop through the whole list from head.next until it is null.
     * As we're guaranteed to have 0 as a first node we can start from 
     * head.next knowing the first 0 is found.
     * Then if we find another 0, 
     * we will create a new node for the returned list with the accumulated value
     * and link the node accordingly with the returned list.
     * Also, we will reset the counter to 0.
     * Then update the head as, head = head.next
     * When head.next becomes null, we will return dummyHead.next.
     * 
     * Here, I am modifying the actual head reference.
     * Ask the interviewers if it's okay to do so. 
     * (Just have to use another pointer and 
     * loop through it, if they want the head reference intact)
     */
    
    
//     ListNode dummyHead = new ListNode();
//     ListNode n = dummyHead;
//     int counter = 0;
    
//     while (head.next != null) {
//       if (head.next.val != 0) {
//         counter += head.next.val;
//       } else {
//         ListNode newNode = new ListNode(counter);
//         n.next = newNode;
//         n = newNode;
//         counter = 0;
//       }
//       head = head.next;
//     }
    
//     return dummyHead.next;
    
    
    
    
    
    /**
     * Approach 2: In-place (So the original list will be modified)
     * First, we will keep two references of the head node.
     * One is for looping and another one is for returning.
     * Say, they are loopNode and returnedNextNode respectively.
     * We will loop till loopNode.next becomes null like previous approach.
     * If we find no 0, we will save it in the counter like approach 1.
     * Then if we find another 0, 
     * we will create a new node but it will be head.next node.
     * And we will update the head as, head = head.next 
     * Also, we will reset the counter to 0 like previously and 
     * update the loopNode as loopNode = loopNode.next.
     * Now, when we are out of loop we will just return returnedNextNode.next
     */

    ListNode loopNode = head;
    ListNode returnedNextNode = head;
    int counter = 0;
    
    while (loopNode.next != null) {
      if (loopNode.next.val != 0) {
        counter += loopNode.next.val;
      } else {
        ListNode newNode = new ListNode(counter);
        head.next = newNode;
        head = newNode;
        counter = 0;
      }
      loopNode = loopNode.next;
    }
    return returnedNextNode.next;
  }
}