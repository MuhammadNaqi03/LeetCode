class ConcatArraySolution {
  public int[] getConcatenation(int[] nums) {
    // Easy problem. Nothing to describe in here.
    int [] returnNums = new int [nums.length * 2];
    for (int i = 0; i < nums.length; i++) {
      returnNums[i] = nums[i];
      returnNums[i + nums.length] = nums[i];
    }

    return returnNums;
  }
}
