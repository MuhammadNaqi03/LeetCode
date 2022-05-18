class PowerOfThreeSolution {
  public boolean isPowerOfThree(int n) {
    /**
    * First Approach: Division by 3
    * If a number is power of 3 then if we divide that number consecutively with 3, we will not get any reminder.
    * Thus we will be checking for if the modulo gives us 0 and then we will divide the number with 3 until we reach at 1.
    * We will return true in that case. Otherwise, we will return false.
    * Examples: 
    * 9 % 3 --> 0 -- 9/3 --> 3 % 3 --> 0 -- 3/3 --> 1 (true) 
    * 6 % 3 --> 0 -- 6/3 --> 2 % 3 --> 2 (false) 
    * Special cases: We have to look for n <= 0 and 1 (1 is a power of 3; 3^0)
    */

    if (n <= 0) {
      return false;
    }

    while (n != 1) {
      if (n % 3 != 0) {
        return false;
      }
      n = n/3;
    }
    return true;
    
    
    
    
    /**
    * Second Approach: Recursive
    * Same as first approach, but will be done recursively.
    */
    // if (n <= 0) {
    //   return false;
    // }
    // return n == 1 || (n % 3 == 0 && isPowerOfThree(n/3));
  }
}