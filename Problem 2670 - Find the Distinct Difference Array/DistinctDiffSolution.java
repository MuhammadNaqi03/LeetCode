class DistinctDiffSolution {
  public int[] distinctDifferenceArray(int[] nums) {
    /**
     * Approach:
     * At first, we need to count the total distinct numbers and their occurrences.
     * As per the constraint, the number is between 1 and 50.
     * We can use HashMap here, but as the range is so small,
     * we can simply use frequency arrays to calculate the numbers' occurrences.
     * After getting the numbers and their occurrences,
     * we will run another loop and add the prefix numbers' occurrences and the increment distinct number count.
     * We also need to deduct the previous count from the suffixArray and the suffix distinct number.
     * Then simply calculate the differences and put those in a result array.
     */
  
    int [] prefixNums = new int [51];
    int [] suffixNums = new int [51];
    int [] resultArray = new int [nums.length];

    int prefixDistinctNums = 0;
    int suffixDistinctNums = 0;

    // First, fill up the suffixNums array
    for (int i = 0; i < nums.length; i++) {
      if (suffixNums[nums[i]] == 0) {
        suffixDistinctNums += 1;
      }
      suffixNums[nums[i]]++;
    }

    for (int i = 0; i < nums.length; i++) {
      if (suffixNums[nums[i]] == 1) {
        suffixDistinctNums -= 1;
      }
      suffixNums[nums[i]]--;

      if (prefixNums[nums[i]] == 0) {
        prefixDistinctNums += 1;
      }
      prefixNums[nums[i]]++;

      resultArray[i] = prefixDistinctNums - suffixDistinctNums;
    }

    return resultArray;     
  }
}
