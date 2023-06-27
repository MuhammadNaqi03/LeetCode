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
  public int[] nextLargerNodes(ListNode head) {
    /**
     * Approach: Monotonic Stack
     * Similar approach to the problem: "739. Daily Temperatures".
     * Here, we need to convert the linked list to an arraylist
     * and save the actual value of the next greater elements inside the returning array.
     * Solution for the problem 739 (Daily Temperatures):
     * https://github.com/MuhammadNaqi03/LeetCode/blob/master/Problem%20739%20-%20Daily%20Temperatures/DailyTemperaturesSolution.java
     */
    ListNode currNode = head;
    ArrayList<Integer> nodeValue = new ArrayList<>();

    while (currNode != null) {
      nodeValue.add(currNode.val);
      currNode = currNode.next;
    }

    int nextGreaterVal [] = new int [nodeValue.size()];
    Stack <Integer> monotonicStack = new Stack<>();

    for (int i = 0; i < nodeValue.size(); i++) {
      while (!monotonicStack.isEmpty() && nodeValue.get(i) > nodeValue.get(monotonicStack.peek())) {
        int poppedIndex = monotonicStack.pop();
        nextGreaterVal[poppedIndex] = nodeValue.get(i);
      }
      monotonicStack.push(i);
    }

    return nextGreaterVal;
  }
}
