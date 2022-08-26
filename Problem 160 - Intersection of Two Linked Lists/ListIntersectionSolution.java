/**
 * Definition for singly-linked list.
 * public class ListNode {
 *   int val;
 *   ListNode next;
 *   ListNode(int x) {
 *     val = x;
 *     next = null;
 *   }
 * }
 */
public class ListIntersectionSolution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    /**
     * Approach 1: By calculating length
     * First, we have to traverse both the linked list and find out their lengths.
     * Then, we have to traverse the extra length for the longest linked list.
     * Afterwards, traverse both the linked lists till they point to the same node.
     * When we first time find the lists point to the same node, that's the intersecting node.
     * In case they are not intersected with each other, both nodes will be null and thus equal.
     * So just return the node after the loop ends for both cases.
     * We don't need to find out if the lists are empty as per constraints:
     * The number of nodes of listA is in the m.
     * The number of nodes of listB is in the n.
     * 1 <= m, n <= 3 * 104
     */
    
    int firstListLength = findLength(headA);
    int secondListLength = findLength(headB);
 
    int lengthDiff = Math.abs(firstListLength - secondListLength);
    ListNode longerList = firstListLength > secondListLength ? headA : headB;
    ListNode smallerList = longerList == headA ? headB: headA;

    while (lengthDiff != 0) {
      longerList = longerList.next;
      lengthDiff--;
    }
 
    while (longerList != smallerList) {
      longerList = longerList.next;
      smallerList = smallerList.next;
    }
 
    return longerList;
 
    
    
    
    
    
    /**
     * Approach 2: Without finding length
     * The main moto is same here as the first approach - traverse till you find a match.
     * If one list's pointer becomes null during traversion, will update that to point to other list's head.
     * If not intersection occurs, then both will be null at the same time,
     * Or if intersection takes place they will meet at the same node.
     *
     * Example 1:
     * Say, first list and second list have length 7 and 4 respectively and they intersect at node with value 7.
     * 1 - 3 - 5 - 4 -\
                         --- 7 - 0 - 2 - null
     *             9 -/ 
     * So, when second list's pointer becomes null the first list's pointer is at node with value 7.
     * Then, we update the second list pointer to point to first list and 
     * when first list's pointer becomes null the second list's pointer is at value 4 node at first list.
     * Then, we update the first list's pointer to second list beginning and 
     * at the next iteration they both meet at node with value 7.
     * Example 2: 
     * Say, first list and second list have length 3 and 4 respectively and they do not intersect.
     * 1 - 5 - 2 - null
     * 3 - 7 - 8 - 5 - null
     * When first list's pointer becomes null the seond list's pointer at node with value 5.
     * Then, we update the first list's pointer to point at the beginning of second list.
     * When, second list's pointer becomes null, first list's pointer is at node with value 7 of second list.
     * Then, we update the second list's pointer to point the beginning of the first list.
     * After 3 iterations both of them becomes null.
     */
    
//     ListNode firstListPointer = headA;
//     ListNode secondListPointer = headB;

//     while (firstListPointer != secondListPointer) {
//       firstListPointer = firstListPointer == null ? headB : firstListPointer.next;
//       secondListPointer = secondListPointer == null ? headA : secondListPointer.next;
//     }
//     return firstListPointer;
  }
  
  
  
  
  public int findLength(ListNode head) {
    int length = 1;
    while (head.next != null) {
      length++;
      head = head.next;
    }
    return length;
  }
}
