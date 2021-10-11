/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycleSolution {
  public boolean hasCycle(ListNode head) {
    //If there is no repeatation of node value. Not accepted and naive
    // HashSet <Integer> set = new HashSet<>();
    // ListNode n = head; //Making the head reference intact
    // while(n != null) {
    //     if (set.contains(n.val)) return true;
    //     set.add(n.val);
    //     n = n.next;
    // }
    // return false;
      
    /*Similar to the previous one but let's save the ListNode instead of val 
    Accepted but slower*/
    // HashSet <ListNode> set = new HashSet<>();
    // ListNode n = head; //Making the head reference intact
    // while(n != null) {
    //     if (set.contains(n)) return true;
    //     set.add(n);
    //     n = n.next;
    // }
    // return false;
      
    // If val can be changed. Accepted and faster
    ListNode n = head; //Making the head reference intact
    while(n != null) {
      if (n.val == Integer.MAX_VALUE) return true;
        n.val = Integer.MAX_VALUE;
        n = n.next;
    }
    return false;
      
    //This problem can also be solved with floyd's cycle finding algorithm  
  }
}