class ArrayPartitionSolution {
  public int arrayPairSum(int[] nums) {
    /**
     * Approach:
     * If we want to maximize the sum of the min values of the pairs,
     * we need to make pairs such that, the smaller values pair with smaller ones,
     * and the larger values pair with larger ones.
     * To do that, we will sort the array in ascending order and pair two consecutive numbers.
     * As the array is sorted already, the first numbers will always be the smallest within a pair.
     * So, we just need to add the first numbers of the pairs and return the sum.
     */
  
    Arrays.sort(nums);
    int sum = 0;
    /**
     * As per constraint: nums.length == 2 * n
     * we can loop till i is less than nums length.
     * If the constraint was not given, we had to use i < nums.length - 1
     */
    for (int i = 0; i < nums.length; i = i + 2) {
      sum += nums[i];
    }
    return sum;

  }
}