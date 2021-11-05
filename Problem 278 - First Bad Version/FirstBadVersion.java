/* The isBadVersion API is defined in the parent class VersionControl.
  boolean isBadVersion(int version); */

public class FirstBadVersioSolution extends VersionControl {
  public int firstBadVersion(int n) {
    /*
    * The solution is a binary search problem but here it's not an array 
    * And the condition we put is left < right rather than left <= right in binary 
    * search. So we update the right with the mid value and try to find 
    * previous bad versions. If we are unable to find, we just update left+1
    * Thus the condition was left < right
    */
    int mid;
    int left = 1;
    int right = n;
    while (left < right){
      //mid = (left+right)/2 gives time exceeding error
      mid = left + (right - left) / 2;  
      if (isBadVersion(mid)) right = mid;
      else left = mid+1;
    }
    return left;
  }
}