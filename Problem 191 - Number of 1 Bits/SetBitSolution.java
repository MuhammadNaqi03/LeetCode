public class SetBitSolution {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    
    /**
      * First approach: Anding with 1 and right shifting afterwards
      * As we know if we do x & 1, it does & operation with the last digit of x,
      * we can use that to find out if the last digit is 1 or not.
      * If x & 1 = 1 then we will increment the count.
      * Then we will shift the number to 1 bit right and keep repeating the process until x becomes 0.
      */
 
//     int count = 0;
//     while (n != 0) {
//       if ((n & 1) == 1) {  // Need to wrap n & 1 into parenthesis
//         count++;
//       }
//       n = n >>> 1;  
//       /**
//       * The problem states that, unsigned integer will be sent.
//       * But as java doesn't accept unsigned integer, signed integer is sent with first bit as sign bit.
//       * For languages which accept unsigned integer we can use >> 
//       * In that case, n = n/2 would do the same, as right shifting 1 bit is the same as dividing by 2
//       * But for java we also need to shift the sign bit as well. So, >>> is used.
//       */
//     }
 
//     return count;
    
    
    
    
 
    /**
      * Second Approach: Brian Kernighan's Algorithm
      * We know that if we do x - 1, the rightmost set (1) bit and all it's right bit got toggled.
      * So if we do x & (x - 1) then, we would remove the rightmost set bit of x.
      * In this approach, we will do the same until x becomes 0.
      */
 
    int count = 0;
    while (n != 0) {
      count++;
      n = n & (n - 1);
    }
 
    return count;
  }
}