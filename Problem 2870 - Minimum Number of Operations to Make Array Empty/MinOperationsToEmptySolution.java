class MinOperationsToEmptySolution {
  public int minOperations(int[] nums) {
    /**
     * At first, we need to find the sequence of the same number.
     * To do that, we will sort the array at the very beginning.
     * Then, we will check if it is possible to empty the array
     * (if we find any number that occurs just once, then the array is impossible to empty as per the given logic).
     * To minimize the total number of operations, we need to choose three elements to remove at once as much as possible.
     * In order to do that, we will divide the whole sequence by 3 and find the quotient,
     * which will be added to the total number of operations.
     * If the sequence is fully divisible by 3, then we don't need to add any extra value.
     * Otherwise, one extra value should be added to the total number of operations.
     * Example:
     * Sequence length: 30
     * Needed operations: 30 / 3 = 10
     *
     * Sequence length: 31
     * Needed operations: 27 / 3 + 4 / 2 = 9 + 2; or, 31 / 3 + 1 = 10 + 1 = 11
     * 
     * Sequence length: 32
     * Needed operations: 30 / 3 + 2 / 2 = 10 + 1; or, 32 / 3 + 1 = 10 + 1 = 11
     */

    Arrays.sort(nums);
    int sameNumberSequence = 1;
    int currNumber = nums[0];
    int minNumberOfOperations = 0;

    for (int i = 1; i < nums.length; i++) {
      if (currNumber == nums[i]) {
        sameNumberSequence += 1;
      } else if (sameNumberSequence == 1) {
        return -1;
      } else {
        minNumberOfOperations = minNumberOfOperations + minOperationForCurrentSequence(sameNumberSequence);
        currNumber = nums[i];
        sameNumberSequence = 1;
      }
    }

    if (sameNumberSequence == 1) {
      return -1;
    }

    return minNumberOfOperations = minNumberOfOperations + minOperationForCurrentSequence(sameNumberSequence);
  }

  public int minOperationForCurrentSequence (int sameNumberSequence) {
    int lastValue = sameNumberSequence % 3 == 0 ? 0 : 1;
    return (int) (sameNumberSequence / 3) + lastValue;
  }
}
