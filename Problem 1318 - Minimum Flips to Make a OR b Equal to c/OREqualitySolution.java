class OREqualitySolution {
  public int minFlips(int a, int b, int c) {
    /**
     * Approach:
     * First, we will convert all the numbers to binary strings of length 32.
     * Then, simply check the conditions for a OR b to be equal to c.
     */
    String aBinString = String.format("%32s", Integer.toBinaryString(a)).replace(' ', '0');
    String bBinString = String.format("%32s", Integer.toBinaryString(b)).replace(' ', '0');
    String cBinString = String.format("%32s", Integer.toBinaryString(c)).replace(' ', '0');

    int minFlip = 0;
    for (int i = 0; i < 32; i++) {
      if (cBinString.charAt(i) == '1' && (aBinString.charAt(i) == '0' && bBinString.charAt(i) == '0')) {
        minFlip += 1;
      }

      if (cBinString.charAt(i) == '0') {
        if (aBinString.charAt(i) == '1' && bBinString.charAt(i) == '1') {
          minFlip += 2; // Both bits of a and b need to be flipped
        } else if (aBinString.charAt(i) == '1' || bBinString.charAt(i) == '1') {
          minFlip += 1;
        }
      }
    }

    return minFlip;
  }
}
