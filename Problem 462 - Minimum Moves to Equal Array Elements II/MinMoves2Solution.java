class Solution {
  public int MinMoves2Solution(int[] nums) {
    /**
     * Approach:
     * We have to find the median of the array. 
     * The sum of the differences between the median and all the values in the array 
     * will be the minimum number of moves needed to make the array elements equal.
     * We don't need to check for empty arrays as per the constraint:
     * 1 <= nums.length <= 105
     */
    Arrays.sort(nums);
    int median;
    if (nums.length % 2 == 0) {
      int firstMedianIndex = nums.length / 2;
      int secondMedianIndex = firstMedianIndex - 1;
      median = (int)Math.ceil((nums[firstMedianIndex] + nums[secondMedianIndex]) / 2);
    } else {
      int medianIndex = (int)Math.ceil(nums.length / 2);
      median = nums[medianIndex];
    }

    int minMovesNeeded = 0;
    for (int num: nums) {
      minMovesNeeded += Math.abs(median - num);
    }
    return minMovesNeeded;
  }
}
