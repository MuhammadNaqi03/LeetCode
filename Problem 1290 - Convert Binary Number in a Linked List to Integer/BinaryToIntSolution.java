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
  public int getDecimalValue(ListNode head) {
    /**
     * Approach:
     * It will be done by normal binary to decimal conversion.
     * First, we have to find out the total length of the linked list and 
     * from it we will get the maximum power/exponent (say, n).
     * Then, will loop through and convert the binary value of the linked list to decimal value.
     */
    
    int length = 1;  // As per constraint - The Linked List is not empty.
    ListNode curr = head;
    while (curr.next != null) {
      curr = curr.next;
      length++;
    }
    
    int n = length - 1;
    double decimalValue = 0;
    while (head != null) {
      if (head.val != 0) {
        decimalValue = decimalValue + Math.pow(2, n);
      }
      head = head.next;
      n--;
    }
    return (int)decimalValue;
  }
}