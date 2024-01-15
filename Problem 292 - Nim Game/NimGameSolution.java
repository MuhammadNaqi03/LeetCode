class NimGameSolution {
  public boolean canWinNim(int n) {
    /**
     * Approach:
     * As both players are playing optimally and the first player goes first,
     * the only way that the opponent can win is if the number of piles is a multiplication of 4.
     */

    return n % 4 != 0; 
  }
}
