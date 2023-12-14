class LargestOddNumberSolution {
  public String largestOddNumber(String num) {
    /**
     * Approach:
     * We will start checking from the end of the string and find the last odd number.
     * If we find an odd number, then we will return that substring.
     * Otherwise, we will return an empty string.
     */

    int currIndex = num.length() - 1;

    while (currIndex >= 0) {
      int currNum = num.charAt(currIndex) - '0';
      if (currNum % 2 != 0) {
        return num.substring(0, currIndex + 1);
      }
      currIndex--;
    }

    return "";
  }
}
