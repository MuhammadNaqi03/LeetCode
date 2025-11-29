class MinOperationsToMakeDivisibleSolution {
  public int minOperations(int[] nums, int k) {
    /**
     * Approach:
     * First we need to find the sum of the given numbers.
     * Then, if the sum is fully divisible by k, then no operations are needed. Thus, we can return 0 here.
     * But if the sum is not fully divisible by k, the number of operations will be equal to the remainder.
     */
    int sum = 0;
    for (int num: nums) {
      sum += num;
    }

    return sum % k == 0 ? 0 : sum % k;
  }
}