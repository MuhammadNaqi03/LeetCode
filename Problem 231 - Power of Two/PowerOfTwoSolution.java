class PowerOfTwoSolution {
  public boolean isPowerOfTwo(int n) {
    /**
    * First Approach: Division by 2
    * If a number is power of 2 then if we divide that number consecutively with 2, we will not get any reminder.
    * Thus we will be checking for if the modulo gives us 0 and then we will divide the number with 2 until we reach at 1.
    * We will return true in that case. Otherwise, we will return false.
    * Examples: 
    * 8 % 2 --> 0 -- 8/2 --> 4 % 2 --> 0 -- 4/2 --> 2%2 --> 0 -- 2/2 --> 1 (true) 
    * 6 % 2 --> 0 -- 6/2 --> 3 % 2 --> 1 (false) 
    * Special cases: We have to look for n <= 0 and 1 (1 is a power of 2; 2^0)
    */

//     if (n <= 0) {
//       return false;
//     }

//     while (n != 1) {
//       if (n % 2 != 0) {
//         return false;
//       }
//       n = n/2;
//     }
//     return true;  
    
    
    
    
    /**
    * Second Approach: Recursive
    * Same as first approach, but will be done recursively.
    */
    // if (n <= 0) {
    //   return false;
    // }
    // return n == 1 || (n % 2 == 0 && isPowerOfTwo(n/2));
    
    
    
    
    /**
    * Third Approach: Bit manipulation
    * If a number is a power of 2 it will have only one set bit
    * Examples: 
    * 1 --> 0001
    * 2 --> 0010
    * 4 --> 0100
    * 8 --> 1000
    * We can take advantage of this scenario.
    * Like previous approach we will return false at first if n <= 0.
    * Otherwise, we will use the rightmost bit unset method:
    * We know that if we do x - 1, the rightmost set (1) bit and all it's right bit got toggled.
    * So, if we do x & (x - 1) then, we would unset the rightmost set bit of x.
    * As power of 2s have only one set bit, those will become 0 after the operation.
    */

    if (n <= 0) {  
      return false;
    }

    return (n & (n - 1)) == 0;
    
    // Can be shortened as: 
    // return n > 0 && (n & (n - 1)) == 0;
  }
}