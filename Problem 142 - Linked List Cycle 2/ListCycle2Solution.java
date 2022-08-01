/**
 * Definition for singly-linked list.
 * class ListNode {
 *   int val;
 *   ListNode next;
 *   ListNode(int x) {
 *     val = x;
 *     next = null;
 *   }
 * }
 */
public class ListCycle2Solution {
  public ListNode detectCycle(ListNode head) {
    /**
     * Approach 1: Using Floyd's cycle detection algorithm
     * First, we have to check for empty list and return null if the head is null.
     * Then, we will use two pointers:
     * hare - will move two steps at a time,
     * tortoise - will move one step at a time.
     * If hare's next or hare's next's next becomes null, that indicates there is no cycle present.
     * Otherwise the tortoise and hare will meet, which indicates that a cycle is present.
     * When they meet together for the first time,
     * we will move the tortoise to the beginning of the linked list (head node).
     * And will move both the tortoise and hare one step at a time.
     * The node they will meet at this time, will be the node from where the cycle begins.
     *
     * But why does this work?
     * Let's assume, the distance from head and the node where the cycle begins is x
     * The distance between the node where the cycle begins and the node where they first meet is y.
     * The distance between the node where they first meet and the node where the cycle begins is z.
     * Considering the hare completes a complete cycle before they meet.
     * So, when they first meet, the total distance covered by,
     * the tortoise d = x + y
     * and the hare 2d = x + y + z + y  [As hare completes a complete cycle, it covers twice the distance]
     * or, 2 (x + y) = x + 2y + z
     * or, 2x + 2y = x + 2y + z
     * So, x = z.
     * The prove is given for the case where hare completed a complete cycle before they first meet,
     * which can also be proved for multiple cycles similarly.
     */

//     if (head == null) {
//       return null;
//     }
    
//     ListNode tortoise = head;
//     ListNode hare = head;

//     while (hare.next != null && hare.next.next != null) {
//       tortoise = tortoise.next;
//       hare = hare.next.next;
//       if (tortoise == hare) {
//         // They meet together, so move the tortoise reference to head
//         tortoise = head;
//         // Now move them one step at a time until they meet at the node where the cycle begins
//         while (tortoise != hare) {
//           tortoise = tortoise.next;
//           hare = hare.next;
//         }
//         return hare;
//       }
//     }

//     // No cycle is found
//     return null;
    
    
    
    
    
    /**
     * Approach 2: Using a flag with Floyd's cycle detection algorithm
     * Here all the approaches are the same but we want to move the second while loop from the first one.
     * To do so, we will use a flag that will indicate if a cycle is found or not.
     * By default it will be false and when the tortoise and the hare first meet we will make it true.
     * Then outside the while loop, we will check if the flag is false or not.
     * If it's false that means no cycle is found, so we will return null.
     * Otherwise similar to the approach 1, we will move the tortoise to the start of the linked list 
     * and move the tortoise and the hare one step at a time.
     * Return the node where they meet again.
     */
    
    if (head == null) {
      return null;
    }
    
    ListNode tortoise = head;
    ListNode hare = head;
    boolean hasCycle = false;

    while (hare.next != null && hare.next.next != null) {
      tortoise = tortoise.next;
      hare = hare.next.next;
      if (tortoise == hare) {
        // They meet together, so update the hasCycle flag and break the loop
        hasCycle = true;
        break;
      }
    }
    
    
    if (hasCycle) {
      tortoise = head;
      while (tortoise != hare) {
        tortoise = tortoise.next;
        hare = hare.next;
      }
      return hare;
    }
    return null;
  }
}