public class ReverseBitsSolution {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    /**
     * Approach:
     * First, create a variable and initialize it with 0.
     * We will do the followings 32 times as the number is 32 bit:
     * We will left shift the variable.
     * Then, we will perform & operation with 1 thus we can find out if the last digit is 1 or 0.
     * If the last digit is 1, then we will add 1 with the variable otherwise we won't.
     * Then we will right shift the number.
     * Return the variable after exiting the loop.
     */

    int reversedBit = 0;
    for (int i = 0; i < 32; i++) {
      reversedBit = reversedBit << 1;
      reversedBit = (n & 1) == 1 ? reversedBit + 1 : reversedBit;
      n = n >> 1;
    }
    return reversedBit;
  }
}