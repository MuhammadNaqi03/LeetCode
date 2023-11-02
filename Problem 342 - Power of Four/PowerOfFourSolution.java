class PowerOfFourSolution {
  public boolean isPowerOfFour(int n) {
    /**
     * Approach 1: Division by 4
     * If a number is a power of 4,
     * then if we divide that number consecutively with 4, we will not get any reminder.
     * Thus, we will be checking if the remainder is 0 or not.
     * Examples: 
     * 16 % 4 --> 0 -- 16/4 --> 4 % 4 --> 0 -- 4/4 --> 1 (true) 
     * 8 % 4 --> 0 -- 8/4 --> 2 % 4 --> 2 (false) 
     * Special cases: We have to look for n <= 0 and 1 (1 is a power of 4; 4^0)
     */

    // if (n <= 0) {
    //   return false;
    // }

    // while (n != 1) {
    //   if (n % 4 != 0) {
    //     return false;
    //   }
    //   n = n/4;
    // }

    // return true;
    
    
    
    
    
    /**
     * Approach 2: Recursive
     * Same as the first approach, but done recursively.
     */

    // if (n <= 0) {
    //   return false;
    // }
    // return n == 1 || (n % 4 == 0 && isPowerOfFour(n/4));
    
    
    
    

    
    /**
     * Approach 3: Bit manipulation
     * If a number is a power of 4, it will have only one set bit in an odd position.
     * Examples: 
     * 1 --> 0001
     * 4 --> 0100
     * 16 --> 0001 0000
     * 64 --> 0100 0000
     * We can take advantage of this scenario.
     * Like the previous approaches, we will first check if the number is less than 1.
     * Afterwards, we will check the number of 1 bits in the number.
     * If the number of one bits is greater than 1, we will return false.
     * Then, we will find out the position of the set bit.
     * If it's odd, the number is a power of 4, otherwise not.
     */

    if (n <= 0) {
      return false;
    }

    boolean hasOneSetBit = (n & (n - 1)) == 0;
    if (!hasOneSetBit) {
      return false;
    }

    int count = 0;
    while (n != 0) {
      n = n >> 1;
      count++;
    }

    if (count % 2 != 1) {
      return false;
    }

    return true;
  }
}
