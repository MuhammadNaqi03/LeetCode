class BestTimeSolution {
  public int maxProfit(int[] prices) {
    int minPrice = prices[0];
    int maxProfit = 0;
    /*
    Here we need to find maximum difference between two numbers
    Hence, to maximize the difference we have to find the minimum on the go
    then find the difference between the minimum number and the current number on the loop
    */
    for (int i = 1; i<prices.length; i++) {
      if (minPrice > prices[i]) minPrice = prices[i];
      else if (prices[i] - minPrice > maxProfit) maxProfit = prices[i] - minPrice;
    }
    return maxProfit;
  }
}