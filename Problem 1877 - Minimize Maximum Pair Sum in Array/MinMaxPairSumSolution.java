class MinMaxPairSumSolution {
  public int minPairSum(int[] nums) {
    /**
     * Approach:
     * To minimize the maximum pair sum,
     * we need to pair the currently available lowest number with the currently available highest number.
     * Thus, we will sort the array first.
     * And then successively add the leftmost number to the rightmost number.
     */

    Arrays.sort(nums);
    int maxPairSum = -1;

    for (int i = 0; i < nums.length/2; i++) {
      int currPairSum = nums[i] + nums[nums.length - i - 1];
      if (maxPairSum < currPairSum) {
        maxPairSum = currPairSum;
      }
    }

    return maxPairSum;
  }
}
