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
      * Approach 1: Using extra space
      * Firstly, we will check if the linked list is empty or have just one node.
      * If so, we will return the head.
      * Afterwards, we will create a dummy head which next will be the given head.
      * Thus, we can change the list's head if its value is not less than x.
      * Then, we will traverse the linked list and will remove the nodes which values 
      * are equal or more than x and store them in an arraylist.
      * Afterwards, will add those nodes after the modified linked list's last node and return the llinked list.
      */
    
//     if (head == null || head.next == null) {
//       return head;
//     }

//     ListNode dummyHead = new ListNode(-201, head);
//     ListNode currNode = dummyHead;
//     ArrayList <ListNode> nodesToAppend = new ArrayList<>();

//     while (currNode.next != null) {
//       if (currNode.next.val >= x) {
//         nodesToAppend.add(currNode.next);
//         currNode.next = currNode.next.next;
//       } else {
//         currNode = currNode.next;
//       }
//     }

//     // After the loop the currNode will become the last node of the modified list
//     for (ListNode node: nodesToAppend) {
//       node.next = null;
//       currNode.next = node;
//       currNode = currNode.next;
//     }

//     return dummyHead.next;
    
    
    
    
    
    /**
     * Approach 2: Two pointers 
     * Just like approach 1, we will return head if head is null or head's next is null.
     * Then, we will have two dummy heads this time.
     * One for connecting the nodes whose values are less than x.
     * The other one is for connecting the nodes whose values are more than or equal to x.
     * Then, connect them together and we have our desired linked list.
     * Space complexity: O(1). 
     * Because we are reforming the original list by moving the original nodes.
     */
 
    if (head == null || head.next == null) {
      return head;
    }
     
    ListNode firstPartDummy = new ListNode(-201);
    ListNode firstPartPointer = firstPartDummy;
    ListNode secondPartDummy = new ListNode(-201);
    ListNode secondPartPointer = secondPartDummy;
 
    while (head != null) {
      if (head.val < x) {
        firstPartPointer.next = head;
        firstPartPointer = head;
      } else {
        secondPartPointer.next = head;
        secondPartPointer = head;
      }
      head = head.next;
    }
 
    firstPartPointer.next = secondPartDummy.next;
    secondPartPointer.next = null;
    secondPartDummy.next = null;
    return firstPartDummy.next;
  }
}