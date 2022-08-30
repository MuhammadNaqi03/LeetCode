class MonotonicArraySolution {
  public boolean isMonotonic(int[] nums) {
    /**
     * Approach: 
     * First, we need to check the lengtb of the array. 
     * If it's 1, we will send true as it is 'vacuous true'.
     * Then we will find out if the sequence is monotone increasing or decreasing.
     * If both the numbers are the same, we will run a loop until we find difference more/less than 0.
     * Then, from that index till the end of the array,
     * we will run a loop comparing if the increasing/decreasing property persists.
     * We don't need to check for empty array as per constraint:
     * 1 <= nums.length <= 105
     *
     * For more info about 'vacuous true':
     * https://math.stackexchange.com/questions/993448/monotonicity-of-a-sequence-of-length-1-or-0
     * https://math.stackexchange.com/questions/734418/what-precisely-is-a-vacuous-truth
     */
    
    if (nums.length == 1) {
      return true;
    }

    int difference = nums[1] - nums[0];
    int startingPoint = 2;

    while (difference == 0 & startingPoint < nums.length) {
      difference = nums[startingPoint] - nums[0];
      startingPoint++;
      if (startingPoint == nums.length) {
        // If we reach at the very end of the array and the difference is still 0,
        // that means all the numbers in the array are the same. Return true as it is 'vacuous true'.
        return true; 
      }
    }

    for (int i = startingPoint; i < nums.length; i++) {
      if (difference < 0) {
        if (nums[i] > nums[i - 1]) {
          return false;
        }
      } else {
        if (nums[i] < nums[i - 1]) {
          return false;
        }
      }
    }
    return true;
  }
}