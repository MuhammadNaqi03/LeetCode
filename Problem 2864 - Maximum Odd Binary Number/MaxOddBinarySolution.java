class MaxOddBinarySolution {
  public String maximumOddBinaryNumber(String s) {
    /**
     * Approach:
     * The number has to be an odd number, and there will be at least one '1' according to the given constraint.
     * So, one '1' needs to always be at the end of the binary number.
     * But before that, we need to count all the '1's in the string.
     * Then, we will put all the ones except the last one in front
     * of the binary number to make the number as large as possible.
     */

    int numOfOnes = 0;
    char [] charArr = s.toCharArray();
    for (char currentChar: charArr) {
      if (currentChar == '1') {
        numOfOnes += 1;
      }
    }

    int currIndex = 0;
    // Fill up the beginning of the binary number with '1's.
    while (numOfOnes > 1) {
      charArr[currIndex++] = '1';
      numOfOnes -= 1;
    }

    // Fill up the rest of the binary number, if any, with '0's.
    while (currIndex < charArr.length - 1) {
      charArr[currIndex++] = '0';
    }

    charArr[charArr.length - 1] = '1'; // s contains at least one '1'.

    return new String(charArr);
  }
}
