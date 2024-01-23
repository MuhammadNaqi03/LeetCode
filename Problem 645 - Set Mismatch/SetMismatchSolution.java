class SetMismatchSolution {
  public int[] findErrorNums(int[] nums) {
    /**
     * Approach: 
     * We need to find two things here:
     * A duplicate number and a missing number.
     * To find the duplicate number, we will use the given numbers as indices.
     * The number starts from 1 to n, so to use those as indices, we will deduct 1.
     * For every number, we will negate the corresponding number in that index.
     * So, if we find a number that is already less than 0,
     * the number representing that index is a duplicate number.
     * And, to find the missing number, we will add the numbers (the duplicate number will be added once),
     * then remove the summation from the summation of 1 to n.
     */

    int duplicateNumber = 0;
    int totalSum = 0;
    for (int i = 0; i < nums.length; i++ ) {
      int currNum = Math.abs(nums[i]);
      if (nums[currNum - 1] > 0) {
        totalSum += currNum;
        nums[currNum - 1] = -nums[currNum - 1];
      } else {
        duplicateNumber = currNum;
      }
    }

    int missingNumber = (nums.length * (nums.length + 1)) / 2 - totalSum;
    return new int [] {duplicateNumber, missingNumber};
  }
}
