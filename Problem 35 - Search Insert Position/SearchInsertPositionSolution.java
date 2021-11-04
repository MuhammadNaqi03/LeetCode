class SearchInsertPositionSolution {
  public int searchInsert(int[] nums, int target) {
    //We have to preserve the index thus make it a global variable
    int i = 0;
    for (; i<nums.length; i++){
      //If number matches then return the index
      if (nums[i] == target) return i;
        /* If the number is greater than the target 
        then the target should be on the number's place */
        if (nums[i]>target) return i;
    }
    //So the target is not in the array so we should put it after the last element
    return i;
  }
}