class RemoveDuplicatesSolution {
  public int removeDuplicates(int[] nums) {
    if(nums.length==0)
      return 0;
    int counter = 0;
    for(int i=0; i<nums.length-1;i++){
      if(nums[i]!=nums[i+1]){
        nums[counter++] = nums[i];
      }
    }
    nums[counter++] = nums[nums.length-1];
    return counter;
  }
}