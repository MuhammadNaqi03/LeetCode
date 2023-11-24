class MaxCoinSolution {
  public int maxCoins(int[] piles) {
    /**
     * Approach:
     * Our job here is to find every pile with the second-highest number of coins for every triplet.
     * To do that, we will sort the array first, then find out how many piles we will accumulate.
     * As the total number of players is 3, we can calculate that by dividing the total number of piles by 3.
     * As per the constraint: "piles.length % 3 == 0", the piles will always be a multiple of 3.
     * Afterwards, we will fetch every pile with the second-highest number of coins until
     * we accumulate the total number of piles assigned to a player.
     */

    Arrays.sort(piles);

    int numberOfPilesToTake = piles.length / 3;
    int currIndex = piles.length - 2;
    int maxNumberOfCoins = 0;

    while (numberOfPilesToTake > 0) {
      maxNumberOfCoins += piles[currIndex];
      numberOfPilesToTake -= 1;
      currIndex -= 2;
    }

    return maxNumberOfCoins;
  }
}
