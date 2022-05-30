class ProductExceptSelfSolution {
  public int[] productExceptSelf(int[] nums) {
    /**
     * Approach:
     * First, we have to create an array with the same size as the given array.
     * Then we will multiply all the numbers to get the result of total multiplication.
     * If the result becomes 0, that indicates that there is one or more 0's present in the sequence.
     * We will go two different routes depending on it.
     * Route 1 - If the result is 0:
     * We will multiply all the numbers that are non zero and save the result in a variable.
     * As well as, we will count how many 0's are in there.
     * If the number of 0 becomes more than 2 then all the indices will become 0. No need to continue the loop at this point.
     * If the number of 0 is one, then we will save the index in a variable.
     * And after completing the loop, we will put the non-zero result only on that index.
     * Route 2 - If the result is not 0:
     * For every element we will divide the multiplication result with the given element
     * and then fill up the respective index.
     */

    // Find the multiplication result first
    int multiplicationResult = 1;
    for (int num: nums) {
      multiplicationResult *= num;
    }
    int [] resultOfMult = new int[nums.length];

    // Route 1
    if (multiplicationResult == 0) {
      int resultWithoutZero = 1;
      int zeroCount = 0;
      int zeroIndex = 0;
      for (int i = 0; i<nums.length; i++) {
        if (nums[i] == 0) {
          zeroCount++;
          zeroIndex = i;
          if (zeroCount > 1) break;
        } else {
          resultWithoutZero *= nums[i];
        }
      }

      if (zeroCount == 1) {
        resultOfMult[zeroIndex] = resultWithoutZero;
      }
    }

    // Route 2
    else {
      for (int i = 0; i<nums.length; i++) {
        resultOfMult[i] = multiplicationResult/nums[i];
      }
    }
    return resultOfMult;
  }
}