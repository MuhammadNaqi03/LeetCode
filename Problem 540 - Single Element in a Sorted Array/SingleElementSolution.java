class SingleElementSolution {
  public int singleNonDuplicate(int[] nums) {
    /**
     * Approach:
     * The problem states that the array will have exactly one element that
     * appears once and every other element that apears exactly twice.
     * So, the constraint should've been:
     * 3 <= nums.length <= 105 rather than 1 <= nums.length <= 105.
     * Also, if the data is correct, the length of the array will always be odd.
     * We can use this property to our benefit (odd length of array).
     * Every time, we divide the array, the middle element should have
     * the same element on its left or right side (as the array is sorted),
     * except if the element is the element that doesn't appear twice.
     * Thus, we'll check on which side we find the same element.
     * And the length of that side, including that duplicate element (excluding the mid element).
     * So, if that side has an even length, that means the unique value lies there.
     * Otherwise, the unique value lies in the other half.
     *
     * It's important to note that the problem can be solved using some other approaches as well,
     * but the question explicitly asks that the run time should be O(logn).
     */

    // Iterative approach:
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;
      int halfLength = mid;

      if ((mid != 0 && nums[mid] == nums[mid - 1])) {
        if (halfLength % 2 == 0) { // The unique value lies in left half
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else if (mid != nums.length -1 && nums[mid] == nums[mid + 1]) {
        if (halfLength % 2 == 0) {
          left = mid + 1;
        } else {
          right = mid - 1;
        } 
      } else { // If the element has no adjacent duplicates, it is the unique element.
        return nums[mid];
      }
    }
    return -1;



    // Recursive approach:
    // return helper(nums, 0, nums.length - 1);
  }


  // int helper (int [] nums, int left, int right) {
  //   if (left > right) {
  //     return -1;
  //   }

  //   int mid = (left + right) / 2;
  //   int halfLength = mid;
  //   if ((mid != 0 && nums[mid] == nums[mid - 1])) {
  //     if (halfLength % 2 == 0) {
  //       return helper(nums, left, mid - 1);
  //     } else {
  //       return helper(nums, mid + 1, right);
  //     }
  //   } else if (mid != nums.length -1 && nums[mid] == nums[mid + 1]) {
  //     if (halfLength % 2 == 0) {
  //       return helper(nums, mid + 1, right);
  //     } else {
  //       return helper(nums, left, mid - 1);
  //     }
  //   } else {
  //     return nums[mid];
  //   }
  // }
}
