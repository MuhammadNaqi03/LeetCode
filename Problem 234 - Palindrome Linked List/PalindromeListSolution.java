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
class PalindromeListSolution {
  public boolean isPalindrome(ListNode head) {
    /**
    * First Approach: Using an Arraylist
    * We will put all the values of the linked list into an arraylist.
    * Then, using two pointers (left and right) will find if the sequence is palindrome.
    * We don't need to check for empty linked list as it is said in the constraint:
    * The number of nodes in the list is in the range [1, 105]
    */
    
//     ArrayList <Integer> nodeVal = new ArrayList<>();
//     while (head != null) {
//       nodeVal.add(head.val);
//       head = head.next;
//     }
    
//     int leftIndex = 0;
//     int rightIndex = nodeVal.size() - 1;
//     while (leftIndex < rightIndex) {
//       if (nodeVal.get(leftIndex) != nodeVal.get(rightIndex)) {
//         return false;
//       }
//       leftIndex++;
//       rightIndex--;
//     }
//     return true;
    


    
    
    /**
    * Second Approach: Reversing the latter half of the list
    * We will first find out the middle of the linked list:
    * Two pointers will be used starting from the head reference.
    * One pointer will move one step and the other one will move two steps.
    * When the fast pointer's next or next.next reaches null the slow pointer will be at middle.
    * Example 1: 
    * 1-2-3-2-1
    * First iteration: slow pointer = 2, fast pointer = 3
    * Second iteration: slow pointer = 3, fast pointer = 1
    * Example 2: 
    * 1-2-2-1
    * First iteration: slow pointer = 2, fast pointer = 2
    * Next, we will reverse from the next node of the slow pointer.
    * Then, until the reverse list is not empty we will compare the two lists.
    */
    
    ListNode slowRunner = head;
    ListNode fastRunner = head;
    while (fastRunner.next != null && fastRunner.next.next != null) {
      slowRunner = slowRunner.next;
      fastRunner = fastRunner.next.next;
    }
    
    // Now reverse the latter mid part of the list
    ListNode revHead = null;
    ListNode midNext = slowRunner.next;
    while (midNext != null) {
      ListNode nextNode = midNext.next;
      midNext.next = revHead;
      revHead = midNext;
      midNext = nextNode;
    }
    
    // Now compare the ListNodes' val to check whether they are palindrome or not
    while (revHead != null) {
      if (head.val != revHead.val) {
        return false;
      }
      head = head.next;
      revHead = revHead.next;
    }
    return true;
  }
}
