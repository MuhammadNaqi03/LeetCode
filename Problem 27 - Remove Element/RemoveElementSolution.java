class RemoveElementSolution {
  public int removeElement(int[] nums, int val) {
    int k = 0;
    for (int i = 0; i<nums.length; i++) {
      if (nums[i] == val) {
        if (i != nums.length-1){
          nums[k] = nums[i+1];
        }
      }
      else{
        nums[k] = nums[i];
        k += 1;
      }
          
    }
    return k;
  }
}