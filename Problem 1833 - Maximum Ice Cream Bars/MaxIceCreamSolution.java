class MaxIceCreamSolution {
  public int maxIceCream(int[] costs, int coins) {
    /**
     * First we need to sort the array in ascending order.
     * Then, we''ll deduct each ice cream cost (element of 'costs' array) from the number of given coins.
     * If after deduction we are left with a negative number,
     * that means we can't match the current ice cream cost.
     * Thus, we'll return the total number of ice cream that can be bought so far.
     * Otherwise, we'll increment the total ice cream count.
     *
     * The 'costs' array and 'coins' will be valid as per the constraints:
     * '1 <= costs[i] <= 105'
     * '1 <= coins <= 108'
     */
    Arrays.sort(costs);
    int numOfIceCreams = 0;

    for (int cost: costs) {
      coins -= cost;
      if (coins < 0) {
        break;
      }
      numOfIceCreams += 1;
    }

    return numOfIceCreams;
  }
}
