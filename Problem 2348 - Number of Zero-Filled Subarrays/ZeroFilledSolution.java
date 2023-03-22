class ZeroFilledSolution {
  public long zeroFilledSubarray(int[] nums) {
    /**
     * Approach:
     * In this problem, we need to find the numbers of consecutive zeros.
     * There is a relationship between the number of "Zero-Filled" subarrays and the number of consecutive zeros:
     * for 1 consecutive zero: number of subarray 1.
     * for 2 consecutive zeros: number of subarray 3 --> 2 + 1.
     * for 3 consecutive zeros: number of subarray 6 --> 3 + 2 + 1.
     * for 4 consecutive zeros: number of subarray 10 --> 4 + 3 + 2 + 1.
     * for 5 consecutive zeros: number of subarray 15 --> 5 + 4 + 3 + 2 + 1.
     * Thus, we can use the "Sum of n Natural Numbers" formula : (n ( n + 1)) / 2 --> (n ^ 2 + n) / 2
     * to count the number of subarrays.
     */

    long totalSubArray = 0;
    int numberOfConsecutiveZeros = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        while ( i < nums.length && nums[i] == 0) {
          numberOfConsecutiveZeros += 1;
          i++;
        }

        totalSubArray += (Math.pow(numberOfConsecutiveZeros, 2) + numberOfConsecutiveZeros) / 2;
        numberOfConsecutiveZeros = 0;
      }
    }
    return totalSubArray;
  }
}
