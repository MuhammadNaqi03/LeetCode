class FindEvenDigitSolution {
  public int findNumbers(int[] nums) {
    /**
     * Approach 1:
     * Convert the integer into a string and check whether the length of the string is even or odd.
     */

    // int totalEvenDigitNumber = 0;
    // for (int num: nums) {
    //   String numberToString = Integer.toString(num);
    //   totalEvenDigitNumber = numberToString.length() % 2 == 0
    //     ? totalEvenDigitNumber + 1
    //     : totalEvenDigitNumber;
    // }

    // return totalEvenDigitNumber;





    /**
     * Approach 2:
     * Count the number of digits by dividing the number by 10,
     * and then check whether or not that digit count is even or odd.
     */

    int totalEvenDigitNumber = 0;
    for (int num: nums) {
      int currNumberDigit = 0;
      while (num > 0) {
        num /= 10;
        currNumberDigit += 1;
      }
      totalEvenDigitNumber = currNumberDigit % 2 == 0
        ? totalEvenDigitNumber + 1
        : totalEvenDigitNumber;
    }

    return totalEvenDigitNumber;
  }
}
