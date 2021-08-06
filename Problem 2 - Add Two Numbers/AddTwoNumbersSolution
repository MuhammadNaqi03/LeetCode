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
class AddTwoNumberSolution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //Assign them to temporary pointers
    ListNode node1 = l1;
    ListNode node2 = l2;
    ListNode dummyHead = new ListNode(0);
    ListNode curr = dummyHead;
    int carry = 0;
    int sum = 0;
        
    while(node1!=null||node2!=null){
      //Assiging value by checking nullity
      int valueNode1 = node1==null?0:node1.val;
      int valueNode2 = node2==null?0:node2.val;
            
      sum = valueNode1+valueNode2+carry;
      carry = sum/10;
      //Create a new node with the value
      ListNode newNode = new ListNode(sum%10);
      //Assign it to curr.next and then curr
      curr.next = newNode;
      curr = newNode;
            
      //update the pointers
      if(node1!=null)
        node1 = node1.next;
      if(node2!=null)
        node2 = node2.next;
    }

    //If there is a carry after the while loop add it to the list
    if(carry>0){
      ListNode newNode = new ListNode(carry);
      curr.next = newNode;
    }
    return dummyHead.next;
  }
}