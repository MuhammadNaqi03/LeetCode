class SumOfTwoIntegersSolution {
  public int getSum(int a, int b) {
    /**
    * Approach 1: Using ++ and -- operator.
    * As the number can be negative as well so we have that scenario as well.
    * If both number is positive:
    * Find out which one is min and which one is max.
    * Loop from 1 to the max and increament the min by one.
    * Return the min.
    * If one or both of them are negative:
    * If none or one is positive:
    * Find out which one is min and which one is max.
    * Loop from 1 to the absolute value of min and decreament the max by one.
    * Return the max.
    */

//     if (a > -1 & b > -1) {
//       int max = a > b ? a : b;
//       int min = a < b ? a : b;
//       for (int i = 1; i <= max; i++) {
//         min++;
//       }
//       return min;
//     }
    
//     int max = a > b ? a : b;
//     int min = a < b ? a : b;
//     for (int i = 1; i <= Math.abs(min); i++) {
//         max--;
//     }
//     return max;
    
    
    
    
    /**
    * Approach 2: Bit Manipulation (if ++ and -- can not be used as well)
    * We will use the half adder logic. 
    * For half adder, we perform & operation to save carry (1 & 1 will have carry 1; 1 & 0 will have carry 0)
    * For non carry number however we use XOR. (XOR 0 with 1 gives 1; XOR 1 with 1 will give 0 where carry will be determined by &)
    * So, first we will have a variable to hold the & operation (will be used as carry)
    * Then we will perform XOR operation and save it in one variable (say in a).
    * To move the carry to the right position, the other variable will be carry << 1 (say b = carry << 1).
    * We will do this until the b becomes 0 and will return a.
    * Example: 0011 (a) and 0001 (b)
    * First iteration:
    * carry = 0011 & 0001 = 0001
    * a = 0011 ^ 0001 = 0010
    * b = carry << 1 = 0010
    * Second iteration:
    * carry = 0010 & 0010 = 0010
    * a = 0010 ^ 0010 = 0000
    * b = carry << 1 = 0100
    * Third iteration:
    * carry = 0000 & 0100 = 0000
    * a = 0000 ^ 0100 = 0100
    * b = carry << 1 = 0000
    * b becomes 0 so get out of the loop
    */

    int carry = 0;
    while (b != 0) {
      carry = a & b;
      a = a ^ b;
      b = carry << 1;
    }
    return a;
  }
}