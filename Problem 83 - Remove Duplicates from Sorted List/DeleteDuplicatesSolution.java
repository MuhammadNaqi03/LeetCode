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
class DeleteDuplicatesSolution {
  public ListNode deleteDuplicates(ListNode head) {
    // Approach 1: Using Set
//       if (head == null) return null;
//       Set<Integer> set = new HashSet<Integer>();
//       ListNode n = head; // To preserve the head reference;
//       set.add(n.val);
    
//       while (n.next != null) {
//         if (set.contains(n.next.val)) {
//           n.next = n.next.next;
//         } else {
//           set.add(n.next.val);
//           n = n.next;
//         }
//       }
    
    /* 
    * Approach 2: Using runner node. More Effiecient as the list is sorted.
    * We will traverse the runner as long as it gets duplicate value as head;
    * Then if different value is found, we will update both the runner and current.
    */
    if (head == null) return null;
    ListNode current = head;
    // It's better to assign runner as head.next (after checking the head is not empty)
    // Otherwise might face problem in loop and conditionals (Jibon theke newa :3)
    ListNode runner = head.next;
    while (runner != null) {
      if (runner.val == current.val) {
        runner = runner.next;
        current.next = runner;
      } else {
        current.next = runner;
        current = current.next;
        runner = runner.next;
      }
    }
    
    // Will return head for both the cases
    return head;
  }
}