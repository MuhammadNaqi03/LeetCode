class DivisibleNonDivisibleDiffSolution {
  public int differenceOfSums(int n, int m) {
    /**
     * Approach:
     * Find the total of both divisible and nondivisible numbers.
     * Return the difference between them.
     */

    int divisible = 0;
    int nonDivisible = 0;
    for (int i = 1; i <= n; i++) {
      if ((i % m) == 0) {
        divisible += i;
      } else {
        nonDivisible += i;
      }
    }

    return nonDivisible - divisible;
  }
}
