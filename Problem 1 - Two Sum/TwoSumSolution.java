class Solution {
  public int[] twoSum(int[] nums, int target) {
    int [] target_index = new int[2];
    for (int i = 0; i<nums.length - 1; i++){
      for (int j = i+1; j<nums.length; j++ ){
        int checker = nums[i] + nums[j];
        if (checker == target ){
          target_index[0] = i;
          target_index[1] = j;        
        }
      }
    }
    return target_index;
  }
}