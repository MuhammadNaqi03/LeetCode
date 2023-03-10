class MinBitFlipSolution {
  public int minBitFlips(int start, int goal) {
    /**
     * Approach 1:
     * We will first convert both the numbers into 32-bit binary string forms.
     * Then, we will check the number of different bits (characters in the strings) 
     * among the two converted binary string forms.
     */

    // String startBinary = String.format("%32s", Integer.toBinaryString(start)).replaceAll(" ", "0");
    // String goalBinary = String.format("%32s", Integer.toBinaryString(goal)).replaceAll(" ", "0");

    // int minFlip = 0;
    // int pointer = 0;
    // while (pointer < startBinary.length()) {
    //   if (startBinary.charAt(pointer) != goalBinary.charAt(pointer)) {
    //     minFlip += 1;
    //   }
    //   pointer += 1;
    // }
    // return minFlip;






    /**
     * Approach 2:
     * We can solve the problem easily using the XOR operation 
     * because XOR produces 1 for different bits between two numbers.
     * We can thus create a new variable, which will be the XOR of the given two variables.
     * Afterwards, we'll loop through and find out the number of
     * 1 bits (different bits) in the previously produced XOR value.
     * To find out the number of 1 bits, we can use Brian Kernighan's algorithm.
     * For more info about Brian Kernighan's algorithm, check out the solution of:
     * 'Number of 1 Bits' (Problem 191).
     */
    int xorValue = start ^ goal;
    int minFlip = 0;

    while (xorValue != 0) {
      minFlip += 1;
      xorValue = (xorValue - 1) & xorValue;
    }
    return minFlip;
  }
}