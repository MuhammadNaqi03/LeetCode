class HammingDistanceSolution {
  public int hammingDistance(int x, int y) {
    /**
     * Approach:
     * We know that, when we XOR two numbers, we are left with set bits where the numbers have different bits.
     * The problem asks to find out the Hamming distance
     * (number of positions at which the corresponding bits are different).
     * So, this problem can be easily solved by doing an XOR operation between the given numbers.
     * To count the set bits faster, we will use Brian Kernighan's algorithm.
     * For more info about Brian Kernighan's algorithm, check out the solution of:
     * 'Number of 1 Bits' (Problem 191).
     */
    int xorValue = x ^ y;
    int numOfDiffBits = 0;
    while (xorValue != 0) {
      numOfDiffBits += 1;
      xorValue  = xorValue & (xorValue  - 1);
    }
    return numOfDiffBits;
  }
}