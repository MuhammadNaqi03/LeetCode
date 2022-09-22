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
class PartitionListSolution {
  public ListNode partition(ListNode head, int x) {
    /**
      * Approach 1: Using extra space (Modifying original list)
      * Firstly, we will check if the linked list is empty or have just one node.
      * If so, we will return the head.
      * Afterwards, we will create a dummy head which next will be the given head.
      * Thus, we can change the list's head if its value is not less than x.
      * Then, we will traverse the linked list and will remove the nodes which values 
      * are equal or more than x and store them in an arraylist.
      * Afterwards, will add those nodes after the modified linked list's last node and return the llinked list.
      */
    
    if (head == null || head.next == null) {
      return head;
    }

    ListNode dummyHead = new ListNode(-201, head);
    ListNode currNode = dummyHead;
    ArrayList <ListNode> nodesToAppend = new ArrayList<>();

    while (currNode.next != null) {
      if (currNode.next.val >= x) {
        nodesToAppend.add(currNode.next);
        currNode.next = currNode.next.next;
      } else {
        currNode = currNode.next;
      }
    }

    // After the loop the currNode will become the last node of the modified list
    for (ListNode node: nodesToAppend) {
      node.next = null;
      currNode.next = node;
      currNode = currNode.next;
    }

    return dummyHead.next;  
  }
}