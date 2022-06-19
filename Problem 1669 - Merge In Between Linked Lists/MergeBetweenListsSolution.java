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
class MergeBetweenListsSolution {
  public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
    /**
    * Approach: We have to find out three references here:
    * a-1th node reference of list1 for plugging the list2 after it,
    * last node of list2 which will be the previous node of b+1th node of list1,
    * b+1th which will be the next node of list2's last node.
    * The constraints are:
    * 3 <= list1.length <= 104, 1 <= list2.length <= 104
    * So, we don't need to check for empty linked list
    * And, 1 <= a <= b < list1.length - 1
    * So, we don't need to think about special case where ath node could be the head reference.
    */
    
    // Find out the a-1th and b+1th nodes
    int count = 0;
    ListNode runner = list1;
    ListNode prevNode = null;   // a-1th node
    ListNode nextNode = null;   // b+1th node
    while (count <= b) {
      if (count + 1 == a) {
        prevNode = runner;
      }
      if (count == b) {
        nextNode = runner.next;
      }
      runner = runner.next;
      count++;
    }
    
    // Find out the last node of list2
    ListNode lastNode = list2;
    while (lastNode.next != null) {
      lastNode = lastNode.next;
    }
    
    // Now connect the nodes and return
    prevNode.next = list2;
    lastNode.next = nextNode;
    return list1;
  }
}
