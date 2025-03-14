class MinOperations1Solution {
  public int minOperations(int[] nums, int k) {
    // Pretty easy problem; no explanation is needed
    int minOperations = 0;
    for (int num : nums) {
      minOperations = num < k ? minOperations + 1 : minOperations;
    }
    return minOperations;
  }
}