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
class MergeTwoListsSolution {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    
    /**First approach - iterative
    We have to create a dummy head and a ref head first then will add the nodes to ref Head's next 
    as well as replace it's position to next and return the dummyHead.next
    Then we will use a while loop that will continue untill any of the linked list's node becomes null
    Afterwards, we will add the remaining nodes reference of the other linked list to ref head's next
    We can not replace that dummy head as we can not use it while referencing if 
    one or both of the link list is/becomes empty
    */
      
    ListNode dummyHead = new ListNode(0); 
    ListNode refHead = dummyHead;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        refHead.next = list1;
        list1 = list1.next; // We are not preserving the list1 reference
      } else {
        refHead.next = list2;
        list2 = list2.next; // We are not preserving the list2 reference
      }
      refHead = refHead.next;
    }
      
    // If one linked list is/becomes empty then we have to attach the rest of the other one.
    // For this if-else block, we can not replace the dummy head.
    if (list1 == null) {
      refHead.next = list2;
    } else {
      refHead.next = list1;
    }
      
    return dummyHead.next;
      
      
    /**Second Approach: Recursive
    (This approach is not liked by me as it would create stack overflow if the lists are big enough)
    First we have to check if any of the linked list is empty. If so, then return the sucker.
    Else we have to create a node which will be the reference of the smallest node of the two.
    Then we will call the method again to get the node's next one.
    After everyting's done, we will return the node.
    */
      
//    if (list1 == null) return list2;
//    if (list2 == null) return list1;
      
//    ListNode ref;
//    if (list1.val < list2.val) {
//      ref = list1;
//      ref.next = mergeTwoLists(list1.next, list2); 
//    } else {
//      ref = list2;
//      ref.next = mergeTwoLists(list1, list2.next);
//    }
//    return ref;
  }
}