class MaxAscendingSumSolution {
  public int maxAscendingSum(int[] nums) {
    /**
     * Approach:
     * Simple problem: just loop through and track the current number, current sum, and maximum sum.
     * If the next number is greater, then just update the current number and current sum.
     * If the next number is not greater, then update all three tracking parameters.
     * Before returning the maximum sum, check if the current sum is greater or not.
     */

    int maxSum = 0;  // Given Constraint: 1 <= nums[i] <= 100
    int currSum = 0;
    int currNum = 0;
    for (int num: nums) {
      if (num > currNum) {
        currSum += num;
        currNum = num;
      } else {
        maxSum = maxSum > currSum ? maxSum : currSum;
        currNum = num;
        currSum = num;
      }
    }

    maxSum = maxSum > currSum ? maxSum : currSum;
    return maxSum;
  }
}
