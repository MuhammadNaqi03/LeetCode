class BestTime2Solution {
  public int maxProfit(int[] prices) {
    /*
    The approach of the solution is to add up all successive positive differences
    Thus we will end up with maximizing the profit
    */
    int maxProfit = 0;
    for (int i = 0; i<prices.length-1; i++){
      if (prices[i+1] - prices[i] > 0) maxProfit += prices[i+1] - prices[i];
    }
    return maxProfit;
  }
}