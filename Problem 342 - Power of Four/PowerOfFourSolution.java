class PowerOfFourSolution {
  public boolean isPowerOfFour(int n) {
    /**
    * First Approach: Division by 4
    * If a number is power of 4 then if we divide that number consecutively with 4, we will not get any reminder.
    * Thus we will be checking for if the modulo gives us 0 and then we will divide the number with 4 until we reach at 1.
    * We will return true in that case. Otherwise, we will return false.
    * Examples: 
    * 16 % 4 --> 0 -- 16/4 --> 4 % 4 --> 0 -- 4/4 --> 1 (true) 
    * 8 % 4 --> 0 -- 8/4 --> 2 % 4 --> 2 (false) 
    * Special cases: We have to look for n <= 0 and 1 (1 is a power of 4; 4^0)
    */

//     if (n <= 0) {
//       return false;
//     }

//     while (n != 1) {
//       if (n % 4 != 0) {
//         return false;
//       }
//       n = n/4;
//     }

//     return true;
    
    
    
    
    
    /**
    * Second Approach: Recursive
    * Same as first approach, but will be done recursively.
    */
    // if (n <= 0) {
    //   return false;
    // }
    // return n == 1 || (n % 4 == 0 && isPowerOfFour(n/4));
    
    
    
    

    
    /**
    * Third Approach: Bit manipulation
    * If a number is a power of 2 it will have only one set bit at odd position
    * Examples: 
    * 1 --> 0001
    * 4 --> 0100
    * 16 --> 0001 0000
    * 64 --> 0100 0000
    * We can take advantage of this scenario.
    * Like previous approach we will return false at first if n <= 0.
    * Otherwise, First we will check if the rightmost set bit is at odd position.
    * To do that, we will have a counter to find at which position the set bit is 
    * if it is on even position, false will be returned
    * After that, we will use the rightmost bit unset method:
    * We know that if we do x - 1, the rightmost set (1) bit and all it's right bit got toggled.
    * So, if we do x & (x - 1) then, we would unset the rightmost set bit of x.
    * As power of 4s have only one set bit, those will become 0 after the operation. 
    */

    if (n <= 0) {
      return false;
    }

    int count = 0;
    int temp = n;
    while (temp != 0) {
      temp = temp >> 1;
      count++;
    }

    if (count % 2 != 1) {
      return false;
    }

    return (n & (n -1)) == 0;

  }
}