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
class Solution {
  /**
   * Approach: No extra space
   * We will calculate the length and save that as a property of the object.
   * Then, when the getRandom method is called, 
   * we will get a random value based on the list's length.
   * Then, return the node's value which is picked up based on the random number.
   */
  ListNode head = new ListNode();
  int length = 0;
  public Solution(ListNode head) {
    this.head = head;
    ListNode currNode = head;
    while (currNode != null) {
      currNode = currNode.next;
      this.length++;
    }
  }
    
  public int getRandom() {
    int randomNumber = (int)(Math.random() * this.length); 
    int count = 0;
    ListNode currNode = head;
    while (count < randomNumber) {
      currNode = currNode.next;
      count++;
    }
    return currNode.val;
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */