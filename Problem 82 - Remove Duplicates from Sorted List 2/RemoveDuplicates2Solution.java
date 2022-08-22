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
class RemoveDuplicates2Solution {
  public ListNode deleteDuplicates(ListNode head) {
    /**
     * Approach 1: Using arraylist (Out of place)
     * First, check if the list is empty or not. If empty return null/head;
     * Afterwards, we will have an arraylist and a variable which will store current duplicate.
     * We will traverse through the list and will find out if the node's value is already in the arraylist or not.
     * If it's already in there, it means that we have found a duplicate.
     * Thus, we will remove the node's value from the arraylist and put it in the variable that tracks duplicate.
     * If it's not already in there and the variable containing current duplicate is not equal to the number,
     * then we will put the value in the arraylist.
     * After traversing the linked list, we will then traverse the arraylist and create a linked list
     * based on the values inside the arraylist. Then return the newly created linked list's head.
     */
    
     
//     if (head == null) {
//       return head;
//     }

//     ArrayList <Integer> uniqueValues = new ArrayList<>();
//     int currDuplicate = -101; // -100 <= Node.val <= 100
//     while (head != null) {
//       if (uniqueValues.contains(head.val)) {
//         currDuplicate = head.val;
//         uniqueValues.remove(Integer.valueOf(head.val));
//       }
//       if (currDuplicate != head.val) {
//         uniqueValues.add(head.val);
//       }
//       head = head.next;
//     }

//     if (uniqueValues.isEmpty()) {
//       return null;
//     }

//     ListNode currNode = new ListNode(uniqueValues.get(0));
//     ListNode dummyHead = new ListNode();
//     dummyHead.next = currNode;
//     for (int i = 1; i < uniqueValues.size(); i++) {
//       ListNode newNode = new ListNode(uniqueValues.get(i));
//       currNode.next = newNode;
//       currNode = newNode;
//     }
    
//     return dummyHead.next;
    

    
    
    
    /**
     * Approach 2: Using pointers (In place)
     * Firstly, just like approach 1, we will check for empty list.
     * Then, we will have some pointers - one is a dummy head.
     * One is for pointing to the previous node of the current node (prevNode).
     * Other two are for current node (currNode) and it's next node (nextNode).
     * We will move till the nextNode's value becomes null.
     * If, the currNode and nextNode have the same value we will move till we find a new value.
     * Then, assign currNode to that node and nextNode to it's next node.
     * Also, we will update prevNode's next to point the currNode.
     * And, if the values of currNode and prevNode are not the same, we will update prevNode and currNode.
     * In both cases, we will move the nextNode if it's not already null.
     * After the loop ends, return dummy head's next.
     */

    if (head == null) {
      return null;
    }

    ListNode dummyHead = new ListNode();
    dummyHead.next = head;
    ListNode prevNode = dummyHead;
    ListNode currNode = head;
    ListNode nextNode = head.next;

    while (nextNode != null) {
      if (currNode.val == nextNode.val) {
        while (currNode.val == nextNode.val) {
          nextNode = nextNode.next;
          if (nextNode == null) {
            break;
          }
        }
        currNode = nextNode;
        prevNode.next = currNode;
      } else {
        prevNode = currNode;
        currNode = nextNode;
      }
      if (nextNode != null) {
        nextNode = nextNode.next;
      }
    }
    return dummyHead.next;   
  }
}
