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
class CriticalPointsSolution {
  public int[] nodesBetweenCriticalPoints(ListNode head) {
    /**
     * Approach 1:
     * A node will be a critical point if it's less or greater than the adjacent nodes.
     * As a result, a list with fewer than three nodes will, by definition, lack critical points.
     * Therefore, we will return [-1, -1] in those cases. For other cases, however, we will use two pointers:
     * One will point to head (firstPointer) and the other will point to head's next (secondPointer).
     * Our goal is to determine if the secondPointer is a critical point.
     * To accomplish this, we will execute a loop until secondPointer's next becomes null
     * (means until the secondPointer points to the rightmost node).
     * We'll check if both firstPointer and secondPointer's next values are greater (for local minima)
     * or less than (for local maxima) the secondPointer's value.
     * In that case, we can call that a critical point and add that node's index to an array list (criticalPoints).
     * Whether it is a critical point or not, we will update all the pointers.
     * After the loop ends, we will check if the array list's size is less than 2 (means 1 or no critical point).
     * If the size is less than 2, we will return [-1, -1] because no critical point or min/max difference is found.
     * Otherwise, the maximum difference will be the first and last critical points' difference.
     * And for the minimum difference, we will find the differences between adjacent critical points.
     */

    // If the linked list has less than 3 nodes, it won't have a local maxima or minima
    // if (head == null || head.next == null || head.next.next == null) {
    //   return new int [] {-1, -1};
    // }

    // ArrayList<Integer> criticalPoints = new ArrayList<>();
    // ListNode firstPointer = head;
    // ListNode secondPointer = head.next;
    // int secondPointerIndex = 1; // Considering head is 0th index
  
    // while (secondPointer.next != null) {
    //   if ((firstPointer.val > secondPointer.val && secondPointer.val < secondPointer.next.val)
    //     || (firstPointer.val < secondPointer.val && secondPointer.val > secondPointer.next.val)) {
    //     criticalPoints.add(secondPointerIndex);
    //   }
    //   firstPointer = secondPointer;
    //   secondPointer = secondPointer.next;
    //   secondPointerIndex += 1;
    // }

    // if (criticalPoints.size() <= 1) {
    //   return new int [] {-1, -1};
    // }

    // int maxDiff = criticalPoints.get(criticalPoints.size()-1) - criticalPoints.get(0);
    // int minDiff = criticalPoints.get(1) - criticalPoints.get(0);

    // for (int i = 2; i < criticalPoints.size(); i++) {
    //   int localMinDiff = criticalPoints.get(i) - criticalPoints.get(i - 1);
    //   if (localMinDiff < minDiff) {
    //     minDiff = localMinDiff;
    //   }
    // }

    // return new int [] {minDiff, maxDiff};








    /**
     * Approach 2:
     * We don't need to use an arraylist to keep track of the critical points.
     * In other words, we don't need to store all critical points in order to 
     * find the minimum or maximum number of nodes (distance) between critical points.
     * To find the maximum distance (maximum number of nodes), we only need two critical points:
     * the first one (firstCriticalPoint) and the last one (secondCriticalPoint).
     * However, to find out the minimum distance (minimum number of nodes), we need another pointer (midCriticalPoint).
     * If we find only two critical points, we will assign the first one to firstCriticalPoint, and the latter to lastCriticalPoint. 
     * We can't find the minimum and maximum distance unless we have at least two critical points.
     * As a result, we have to return [-1, -1] if we find fewer than 2 critical points.
     * But, if we have more than 2 critical points, we will update the lastCriticalPoint with
     * the latest found critical point and midCriticalPoint with the previous lastCriticalPoint.
     * And we'll calculate the distance of midCriticalPoint from the first and last one.
     * Thus, we'll find the minimum distance between critical values.
     * Example: 
     * [5,3,1,2,5,1,2,1] (Assume the list's head is 0th index)
     * We have 4 critical points at indices : 2, 4, 5, 6.
     * Before finding any critical point:
     * firstCriticalPoint = -1; int midCriticalPoint = -1; lastCriticalPoint = -1;
     * After finding the first critical point:
     * firstCriticalPoint = 2; int midCriticalPoint = -1; lastCriticalPoint = -1;
     * After finding the second critical point:
     * firstCriticalPoint = 2; int midCriticalPoint = -1; lastCriticalPoint = 4;
     * After finding the third critical point:
     * firstCriticalPoint = 2; int midCriticalPoint = 4; lastCriticalPoint = 5;
     * minDiff = 1
     * After finding the last critical point:
     * firstCriticalPoint = 2; int midCriticalPoint = 5; lastCriticalPoint = 6;
     * minDiff = 1
     */

    if (head == null || head.next == null || head.next.next == null) {
      return new int [] {-1, -1};
    }

    ListNode firstPointer = head;
    ListNode secondPointer = head.next;
    int secondPointerIndex = 1; // Considering head is 0th index
    int firstCriticalPoint = -1;
    int lastCriticalPoint = -1;
    int midCriticalPoint = -1;
    int minDiff = Integer.MAX_VALUE;

    while (secondPointer.next != null) {
      if ((firstPointer.val > secondPointer.val && secondPointer.val < secondPointer.next.val)
        || (firstPointer.val < secondPointer.val && secondPointer.val > secondPointer.next.val)) {
        if (firstCriticalPoint == -1) { // If it's the first critical point
          firstCriticalPoint = secondPointerIndex;
        } else {
          midCriticalPoint = lastCriticalPoint; // Will be -1 if it's the second critical point
          lastCriticalPoint = secondPointerIndex;
          if (midCriticalPoint != -1) { // If more than 2 critical points are found
            int localMinDiff = Math.min(midCriticalPoint - firstCriticalPoint, lastCriticalPoint - midCriticalPoint);
            minDiff = localMinDiff < minDiff ? localMinDiff: minDiff;
          }
        }
      }
      firstPointer = secondPointer;
      secondPointer = secondPointer.next;
      secondPointerIndex += 1;
    }

    // If one or no critical points are found
    if (firstCriticalPoint == -1 || lastCriticalPoint == -1) {
      return new int [] {-1, -1};
    }

    int maxDiff = lastCriticalPoint - firstCriticalPoint;
    // minDiff could be Integer.MAX_VALUE (if only two critical points are found)
    minDiff = minDiff > maxDiff ? maxDiff : minDiff;
    return new int [] {minDiff, maxDiff};
  }
}
