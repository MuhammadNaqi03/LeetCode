class SignElemSolution {
  public int[] rearrangeArray(int[] nums) {
    /**
     * Approach:
     * One of the constraints states that - 'nums consists of equal number of positive and negative integers'.
     * So, we will store the positive and negative numbers in two different arrays.
     * And then we will store positive numbers in even indices and negative numbers in odd indices in the resulting array.
     */

    int [] positiveNums = new int [nums.length/2];
    int [] negativeNums = new int [nums.length/2];
    int positiveNumsIndex = 0;
    int negativeNumsIndex = 0;

    for (int num: nums) {
      if (num < 0) {
        negativeNums[negativeNumsIndex++] = num;
      } else {
        positiveNums[positiveNumsIndex++] = num;
      }
    }

    int currIndex = 0;
    for (int i = 0; i < nums.length; i = i+2) {
      nums[i] = positiveNums[currIndex];
      nums[i + 1] = negativeNums[currIndex++];
    }

    return nums;
  }
}
