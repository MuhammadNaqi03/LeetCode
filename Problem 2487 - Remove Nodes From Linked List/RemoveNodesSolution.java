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
class RemoveNodesSolution {
  public ListNode removeNodes(ListNode head) {
    /**
     * Approach: Using a Monotonic Stack
     * We'll use a monotonic stack (decreasing) to solve the problem.
     * In our first loop, whenever we find a node with a value greater than the stack top, 
     * we'll remove the top until the top node's value becomes greater or the stack becomes empty.
     * Afterwards, we'll insert the current node.
     * After completing the first loop, we'll connect the nodes inside the stack.
     */
    Stack <ListNode> monoStack = new Stack<>();
    while (head != null) {
      while (!monoStack.isEmpty() && monoStack.peek().val < head.val) {
        monoStack.pop();
      }
      monoStack.push(head);
      head = head.next;
    }

    head = monoStack.pop();
    head.next = null; // Will be the last node, so its next will be null

    while (!monoStack.isEmpty()) {
      ListNode currNode = monoStack.pop();
      currNode.next = head;
      head = currNode;
    }

    return head;
  }
}
