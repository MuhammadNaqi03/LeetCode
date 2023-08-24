class DeciBinarySolution {
  public int minPartitions(String n) {
    /**
     * If we look closely, we can see that the number of deci-binary doesn't depend on the length of the number;
     * rather, it depends on the highest digit in the number.
     * For example,
     * For 19, we need nine deci-binary numbers: 11, 1, 1, 1, 1, 1, 1, 1, 1.
     * For 200000001, we need two deci-binary numbers: 100000001 and 100000000.
     * So, to solve this problem, we need to find the greatest digit in the given input.
     * Because 9 is the highest digit in the decimal system,
     * the count of the needed deci-binary numbers cannot be greater than 9.
     * Also, as per the constraints:
     * 'n consists of only digits.'
     * 'n does not contain any leading zeros and represents a positive integer.'
     * We don't need to worry about invalid or negative numbers.
     */

    char largestChar = '0';
    for (int i = 0; i < n.length(); i++) {
      if (n.charAt(i) > largestChar) {
        largestChar = n.charAt(i);
      }
      
      if (largestChar == '9') {
        break;
      }
    }
    
    return largestChar - 48; // ASCII value of '0' is 48
  }
}
