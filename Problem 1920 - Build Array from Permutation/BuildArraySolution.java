class BuildArraySolution {
  public int[] buildArray(int[] nums) {
    int [] returnArr = new int [nums.length];

    for (int i = 0; i < nums.length; i++) {
      returnArr[i] = nums[nums[i]];
    }

    return returnArr;   
  }
}
