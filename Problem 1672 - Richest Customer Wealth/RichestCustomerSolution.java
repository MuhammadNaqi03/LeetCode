class RichestCustomerSolution {
  public int maximumWealth(int[][] accounts) {
    // Easy problem. Nothing to describe in here.
    int maxWealth = 0;
    for (int [] UserAccount: accounts) {
      int wealth = 0;
      for (int bank: UserAccount) {
        wealth += bank;
      }
      if (wealth > maxWealth) {
        maxWealth = wealth;
      }
    }
    return maxWealth;
  }
}