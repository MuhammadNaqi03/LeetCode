class MissingNumberSolution {
  public int missingNumber(int[] nums) {
    /**
    * First Approach: Adding them up
    * As the numbers are in range and all the numbers except one number are present,
    * we will get that number if we subtract the looped total from the total of all numbers in the range [0,n]
    * Remember if the range is not from 0, we have to change the starting point of the loop and
    * if the range starts from negative number, this approach will not work.
    */
    // int totalSum = 0;
    // int totalSumExceptOne = 0;

    // for (int i = 0; i<= nums.length; i++) {
    //   totalSum += i;
    // }

    // for (int i = 0; i< nums.length; i++) {
    //   totalSumExceptOne += nums[i];
    // }

    // return totalSum - totalSumExceptOne;
      
      
      
    /**
    * Second Approach: Using XOR
    * Using the principle: x ^ x = 0, we will solve this problem.
    * For this specific problem the range is [0, n] and the array will have those numbers in range.
    * So, we can say that we would have n+1 numbers if all the numbers (including 0) were present 
    * but we will get n numbers for the missing one.
    * Thus, if we XOR numbers with index, corresponding index will make the number 0, leaving the only missing number.
    */
      
    int missingNumber = nums.length; // For the max number as we can't loop through nums[nums.length]
    for (int i = 0; i < nums.length; i++) {
      missingNumber = missingNumber ^ nums[i] ^ i;
    }

    return missingNumber;
  }
}