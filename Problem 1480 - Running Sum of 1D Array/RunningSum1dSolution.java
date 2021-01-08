class RunningSum1dSolution {
  public int[] runningSum(int[] nums) {
    int [] copy = new int[nums.length];
    copy[0]  = nums[0];
    for (int i = 1; i<nums.length; i++){
      copy[i] = copy[i-1]+nums[i];
    }
    return copy;
  }
}