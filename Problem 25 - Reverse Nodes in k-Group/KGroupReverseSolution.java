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
class KGroupReverseSolution {
  public ListNode reverseKGroup(ListNode head, int k) {
    /**
     * Approach 1: Using arraylist
     * Firstly, we have to create an arraylist of type arraylist of ListNode.
     * Then, we will create two pointers to point to the
     * starting and ending of each part (say, partHead and partTail) of the list based on k value.
     * We will reverse each part of the list and put the list and its tail inside an arraylist.
     * Which will be added to the arraylist created at the very beginning.
     * Afterwards, we will add one part's tail's next to other part's head sequentially.
     * If, there is a part which is unreversed (if the list's length is not fully divisible by k),
     * we will add that part with the last reversed part's tail.
     * Then, return the first part's head.
     * We don't need to validate k's value as per constraint:
     * 1 <= k <= n <= 5000
     */
    
    // ArrayList <ArrayList<ListNode>> listParts = new ArrayList<>();
    // int nodeCount = 1;
    // ListNode partHead = head;
    // ListNode partTail = head;

    // // Make partition(s) of the linked list
    // while (partTail != null) {
    //   if (nodeCount == k) {
    //     ListNode tailNext = partTail.next; // Point partHead to the next partition's head
    //     partTail.next = null;  // Make part of the list
      
    //     ArrayList <ListNode> revPart = partitionList(partHead);
    //     listParts.add(revPart);
    //     nodeCount = 1;

    //     partHead = tailNext;
    //     partTail = tailNext;
    //   } else {
    //     nodeCount++;
    //     partTail = partTail.next;
    //   }
    // }

    // // Make one part's tail's next to point the next part's head
    // for (int i = 1; i < listParts.size(); i++) {
    //   ArrayList <ListNode> arrayList1 = listParts.get(i - 1);
    //   ArrayList <ListNode> arrayList2 = listParts.get(i);
    //   arrayList1.get(0).next = arrayList2.get(1);
    // }

    // // Add the unreversed part with the last reverted tail
    // if (partHead != null) {
    //   ArrayList <ListNode> lastArrayList = listParts.get(listParts.size() - 1);
    //   lastArrayList.get(0).next = partHead;
    // }

    // ArrayList <ListNode> firstArrayList = listParts.get(0);
    // return firstArrayList.get(1);




    /**
     * Approach 2: Using constant space
     * It could be thought of as an extended version of the reverse linked list problem.
     * In normal reverse linked list approach, we continue till the node becomes null.
     * Here, we can make partition like the previous approach but
     * will stop when we find the part's next instead of null.
     * So for each partition, the reversed tail will point to the next partition's head.
     * Thus, we don't need to care if the length of the linked list is not fully divisible by k.
     * Also, as the partition's head changes and becomes tail for each partition,
     * we have to mark the tail of the previous partition and make its next to point
     * the reversed head of the next partition.
     */

    
    int nodeCount = 1;
    ListNode partHead = head;
    ListNode partTail = head;
 
    ListNode dummyHead = new ListNode(-1, head); // As the head reference will be changed
    ListNode prevTail = dummyHead;
 
    // Make partition(s) of the linked list
    while (partTail != null) {
      if (nodeCount == k) {
        ListNode tailNext = partTail.next;
        ListNode revHead = revPartition(partHead, tailNext);  // Get the reverse head of the partition
 
        prevTail.next = revHead;  // Link the previous partition's tail's next to the current partition's head
        prevTail = partHead;  // Previous partHead becomes prevTail as the part gets reversed
        partHead = tailNext; // Point partHead to the next partition's head
        partTail = partHead;
        nodeCount = 1;
      } else {
      nodeCount++;
      partTail = partTail.next;
      }
    }
    return dummyHead.next;
  }



  // Reverse the list and return tail (of the reversed list) and the reversed list
  // public ArrayList<ListNode> partitionList (ListNode head) {
  //   ArrayList <ListNode> tailAndRevList = new ArrayList <ListNode>();
  //   tailAndRevList.add(head); // That would be the tail of the list

  //   ListNode revHead = null;
  //   while (head != null) {
  //     ListNode nextNode = head.next;
  //     head.next = revHead;
  //     revHead = head;
  //     head = nextNode;
  //   }

  //   tailAndRevList.add(revHead); // Add the reversed list
  //   return tailAndRevList;
  // }




  // Reverse the list and return reversed list
  public ListNode revPartition (ListNode head, ListNode tailNext) {
    ListNode revHead = tailNext;  // Point to the next partiiton's head/null
    while (head != tailNext) {
      ListNode nextNode = head.next;
      head.next = revHead;
      revHead = head;
      head = nextNode;
    }
    return revHead;
  }
}
