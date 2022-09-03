class RemoveDuplicates2Solution {
  public int removeDuplicates(int[] nums) {
    /**
     * Approach:
     * As, the numbers can appear at most twice - 
     * First, check the array length and if it's less than 3, then return the array length.
     * Afterwards, we will start a loop from 2 and will check 
     * if the previous two indices have the same numbers as the current index's number or not.
     * If the numbers are not the same then, we will put that value in index k of nums and we will increment k.
     * The initial value of k will be 2, as at least the first two elements can be the same.
     * Return the k after the loop ends.
     */

    if (nums.length < 3) {
      return nums.length;
    }

    int k = 2;
    for (int i = 2; i < nums.length; i++) {
      if (nums[i] != nums[k-1] || nums[i] != nums[k-2]) {
        nums[k++] = nums[i];
      }
    }
    return k;
  }
}
