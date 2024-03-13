class PivotIntegerSolution {
  public int pivotInteger(int n) {
    /**
     * Approach:
     * At first, we need to find the total sum of 1 to n.
     * Then, we will run a loop and track the summation (say, currSum) of the integers in the loop.
     * If the currSum becomes equal to the total sum, that integer will be the pivot integer.
     * We also need to deduct the integers in the loop from the total sum.
     * If the currSum gets greater than the total sum,
     * that means there is no pivot integer, and we will simply return -1.
     */

    int totalSum =  (n * (n + 1)) / 2;
    int currSum = 0;

    for (int i = 1; i <= n; i++) {
      currSum += i;
      if (currSum == totalSum) {
        return i;
      }

      totalSum -= i;
      if (currSum > totalSum) {
        return -1;
      }
    }

    return -1;
  }
}
