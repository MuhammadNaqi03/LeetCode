/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeTwoListsSolution {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      /*
      First approach - iterative
      We have to create a dummy head and a ref head first then will add the nodes to ref Head's next 
      as well as replace it's position to next and return the dummyHead.next
      We first use a while loop that we will continue untill any of the linked list becomes null
      then we will add the rest to the reference
      We can not replace that dummy head as we can not use it while referencing if 
      one or both of the link list is/becomes empty
      */
      
      ListNode dummyHead = new ListNode(0); 
      ListNode refHead = dummyHead;
      while (list1 != null && list2 != null) {
          if (list1.val < list2.val) {
              refHead.next = list1;
              refHead = refHead.next;
              list1 = list1.next; // We are not preserving the list1 reference
          } else {
              refHead.next = list2;
              refHead = refHead.next;
              list2 = list2.next; // We are not preserving the list2 reference
          }
      }
      
      // If one linked list is/becomes empty then we have to send the rest of the other one.
      // For this if-else block, we can not replace the dummy head.
      if (list1 == null) {
          refHead.next = list2;
      } else {
          refHead.next = list1;
      }
      
      return dummyHead.next;
  }
}