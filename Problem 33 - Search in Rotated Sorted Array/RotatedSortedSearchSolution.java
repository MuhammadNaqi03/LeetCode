class RotatedSortedSearchSolution {
  public int search(int[] nums, int target) {
    /**
     * Approach: Binary search
     * Here, one given constraint is important:
     * 'All values of nums are unique'
     * Because of that constraint, we can observe that, 
     * every time we divide the array into half, 
     * we will be left with at least one part that is sorted (In this problem sorted in ascending order).
     * So, our goal will be to find out the sorted part and to check if the number is in it.
     * If it doesn't then we will move to the other part.
     * We don't need to check for empty array as per constraint:
     * 1 <= nums.length <= 5000
     */
    
    // Iterative way:
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;

      // If mid value is the target then return mid index
      if (nums[mid] == target) {
        return mid;
      }

      if (nums[left] < nums[mid]) { // Left half is sorted
        // Check if the value is in-between left index value and mid index value
        // If so, search that half
        if (nums[left] <= target &&  nums[mid] > target ) { 
          right = mid - 1;
        } else { // search in the right half (may or may not be sorted)
          left = mid + 1;
        }
      } else { // If left half is not sorted, the right half is
        // Check if the value is in between mid index value and right index value
        // If so, search that half
        if ((nums[mid] < target && nums[right] >= target) || (mid == left)) {
          // Here, checking mid == left is needed for cases like:
          // [1,3] target = 3; [5,1,2,3,4] target = 1 and so on, as the left and mid become the same at some point.
          // So, moving the right index doesn't help there.
          left = mid + 1;
        } else { // search in the left half (may or may not be sorted)
          right = mid - 1;
        }
      }
    }
    // Couldn't find the target? return -1
    return -1;
  }
}