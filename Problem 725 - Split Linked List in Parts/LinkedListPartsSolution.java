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
class LinkedListPartsSolution {
  public ListNode[] splitListToParts(ListNode head, int k) {
    /**
     * Given that k can not be negative (1 <= k <= 50), we can encounter the following scenarios:
     * 1. The value of k is greater than the list's length.
     * In this scenario we will find out how many nulls needed to be inserted
     * after the linked list's elements are inserted.
     * 2. K's value is less or equal to the list's length:
     * In this case, we need to find how many element(s) are needed to be added in each partition.
     * Also, we need to find how many extra elements are needed to be added in the first partition(s),
     * if the list's length is not fully divisible by k.
     */
    
    ListNode currNode = head;
    int listLength = 0;
    while (currNode != null) {
      listLength++;
      currNode = currNode.next;
    }
    ListNode [] arrToReturn = new ListNode [k];
 
 
    if (listLength < k) {
      int index = 0;
      while (head != null) {
        // Make partition with only one node
        ListNode nextHead = head.next;
        head.next = null;
        arrToReturn[index++] = head;
        head = nextHead;
      }
 
      // Insert empty nodes
      for (int i = index; i < k; i++) {
        arrToReturn[i] = null;
      }
    } else {
      int elementsPerPart = listLength/k;
      int extra = listLength % k;
      int index = 0;
      for (int i = 0; i < k; i++) {
        int totalElementsPerParts = elementsPerPart;
        // Add one extra element until all the extra elements are included
        if (extra != 0) {
          totalElementsPerParts++;
          extra--;
        }
 
        ListNode partitionHead = head;
        // Move the head reference to the last node of the current partition
        while (totalElementsPerParts > 1) {
          head = head.next;
          totalElementsPerParts--;
        }
 
        // Make partition of the list
        ListNode nextHead = head.next;
        head.next = null;
        head = nextHead; // Move head to the next partition's beginning
        arrToReturn[index++] = partitionHead;
      }
    }
    return arrToReturn;
  }
}
