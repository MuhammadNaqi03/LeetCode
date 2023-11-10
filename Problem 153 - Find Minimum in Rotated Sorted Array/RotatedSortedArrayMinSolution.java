class RotatedSortedArrayMinSolution {
  public int findMin(int[] nums) {
    /**
     * Approach:
     * We know that, if we divide any rotated sorted array (which contains all unique elements)
     * into two halves, at least one half will be sorted.
     * So, at first, we will have two pointers, leftIndex and rightIndex, pointing to the start and end of the array.
     * Also, we will assign an arbitrary number from the array as the minimum number (min).
     * Until leftIndex becomes greater than rightIndex, we will run a loop,
     * and in every iteration we will find out the value of middle index (midIndex).
     * Also, in every iteration, we will check which half is sorted.
     * The midIndex's element will be greater or equal to the leftIndex's element if the left half is sorted.
     * Otherwise, the right half is sorted.
     * If the left half is sorted, we will update the leftIndex value by midIndex + 1.
     * But if the right half is sorted, we will update the rightIndex value by midIndex - 1.
     * For both cases, we will update the min value if necessary.
     * If the left half is sorted, the min value of the left half is the element in leftIndex;
     * if the right half is sorted, the min value of the right half is the element in midIndex.
     * After the loop ends, we will return the minimum element that we have found.
     * We don't need to check for empty arrays as per the constraints:
     * n == nums.length
     * 1 <= n <= 5000
     */

    int leftIndex = 0;
    int rightIndex = nums.length - 1;
    int min = nums[0];

    while (leftIndex <= rightIndex) {
      int midIndex = (leftIndex + rightIndex) / 2;
      if (nums[leftIndex] <= nums[midIndex]) { // Left half is sorted
        min = Math.min(min, nums[leftIndex]);
        leftIndex = midIndex + 1;
      } else { // Right half is sorted
        min = Math.min(min, nums[midIndex]);
        rightIndex = midIndex - 1;
      }
    }

    return min;
  }
}
