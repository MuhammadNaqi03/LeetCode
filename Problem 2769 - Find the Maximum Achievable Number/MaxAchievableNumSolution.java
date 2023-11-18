class MaxAchievableNumSolution {
  public int theMaximumAchievableX(int num, int t) {
    /**
     * Approach:
     * To become equal to the maximum achievable number (x),
     * we need to continuously add 1 with num until t times.
     * And continue to decrement x by 1 until t times.
     * The equal number will be: num + (t * 1) or x - (t * 1)
     * Thus, the x will be: num + (t * 1) + (t * 1).
     */

    return num + 2 * t;
  }
}
