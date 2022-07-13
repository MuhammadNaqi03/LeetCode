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
public class LinkedListCycleSolution {
  public boolean hasCycle(ListNode head) {
    /* Approach 1: 
     * If there is no repeatation of node value (Not accepted and naive)
     */

    // HashSet <Integer> set = new HashSet<>();
    // ListNode n = head; //Making the head reference intact
    // while(n != null) {
    //   if (set.contains(n.val)) return true;
    //   set.add(n.val);
    //   n = n.next;
    // }
    // return false;
      
      
      
        
    /* Approach 2: 
     * Similar to the previous one but let's save the ListNode instead of val
     */

    // HashSet <ListNode> set = new HashSet<>();
    // ListNode n = head; //Making the head reference intact
    // while(n != null) {
    //   if (set.contains(n)) return true;
    //   set.add(n);
    //   n = n.next;
    // }
    // return false;
        
      
      
      
    /* Approach 3:
     * If value can be changed, then change the value of the node
     * and if the same value is found again that means a cycle is present.
     */

    // ListNode n = head; //Making the head reference intact
    // while(n != null) {
    //   if (n.val == Integer.MAX_VALUE) return true;
    //   n.val = Integer.MAX_VALUE;
    //   n = n.next;
    // }
    // return false;
      
      
      
      
        
    /* Approach 4: 
     * Using Floyd's cycle detection algorithm.
     * Here we will have two pointers - one will move one step at a time and other will move two steps.
     * If there is no cycle, then the fast pointer will become null.
     * But if there is a cycle present, then the fast and the slow pointers will meet each other inside the loop.
     * You can read more about it: 
     * https://www.codingninjas.com/blog/2020/09/09/floyds-cycle-detection-algorithm/
     */
      
    ListNode slowNode = head;
    ListNode fastNode = head;
    while (fastNode != null && fastNode.next != null) {
      slowNode = slowNode.next;
      fastNode = fastNode.next.next;
        
      if (fastNode == slowNode) {
        return true;
      }
    }
    return false;
  }
}