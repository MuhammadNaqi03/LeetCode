class MaxProductDiffSolution {
  public int maxProductDifference(int[] nums) {
    /**
     * Approach 1: Sorting
     * We need to find the largest two and the smallest two numbers and their differences.
     * Thus, we will sort the array first and find the difference between the first two and the last two numbers.
     */

    // Arrays.sort(nums);
    // return (nums[nums.length - 1] * nums[nums.length - 2]) - (nums[0] * nums[1]);






    /**
     * Approach 2: Without Sorting
     * We just need to find four numbers here: the largest and the smallest two.
     * Just find the four numbers and return the difference between their pairs.
     */

    int smallestNumber = Integer.MAX_VALUE;
    int secondSmallestNumber = Integer.MAX_VALUE;
    int largestNumber = Integer.MIN_VALUE;
    int secondLargestNumber = Integer.MIN_VALUE;

    for (int num: nums) {
      if (num <= smallestNumber) {
        secondSmallestNumber = smallestNumber;
        smallestNumber = num;
      } else if (num < secondSmallestNumber) {
        secondSmallestNumber = num;
      } 
      
      if (num >= largestNumber) {
        secondLargestNumber = largestNumber;
        largestNumber = num;
      } else if (num > secondLargestNumber) {
        secondLargestNumber = num;
      }
    }

    return (largestNumber * secondLargestNumber) - (smallestNumber * secondSmallestNumber);
  }
}
