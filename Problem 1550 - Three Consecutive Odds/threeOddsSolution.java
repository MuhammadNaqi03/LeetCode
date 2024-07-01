class threeOddsSolution {
  public boolean threeConsecutiveOdds(int[] arr) {
    /**
     * Approach:
     * Keep a variable to count consecutive odd numbers.
     * Then, inside a loop, increment that variable if an odd number is found;
     * otherwise, make it 0. If the variable becomes 3, then return true.
     * Otherwise, return false at the end of the loop.
     */

    int consecutiveOddCount = 0;
    for (int elem : arr) {
      consecutiveOddCount = elem % 2 != 0 ? consecutiveOddCount + 1 : 0;

      if (consecutiveOddCount == 3) {
        return true;
      }
    }

    return false;
  }
}
