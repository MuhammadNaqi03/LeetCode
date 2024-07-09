class AvgWaitingTimeSolution {
  public double averageWaitingTime(int[][] customers) {
    /**
     * Approach:
     * For every customer, the total waiting time and the total finish time need to be tracked.
     * For every customer except for the first, the finish time is the
     * sum of the previous cumulative finish time and the current finish time.
     * But if the previous cumulative finish time is smaller than the arrival time,
     * then the finish time will be the arrival time plus the current finish time.
     * And the total waiting time will be the total finish time minus the current arrival time.
     * For the first customer, the finish time will be the sum of the arrival time and the finish time.
     * The total waiting time will be the finish time.
     * The given constraints state that the array won't be empty,
     * and the arrays within the array won't be empty either.
     * So, we can use the values of the array of the 0th index as initial values.
     */

    int currFinishTime = customers[0][0] + customers[0][1];
    double totalWaitingTime = customers[0][1];

    for (int i = 1; i < customers.length; i++) {
      int [] currCustomerTime = customers[i];
      if (currFinishTime < currCustomerTime[0]) {
        currFinishTime = currCustomerTime[0];
      }

      currFinishTime += currCustomerTime[1];
      totalWaitingTime += currFinishTime - currCustomerTime[0];
    }

    return (totalWaitingTime / customers.length);
  }
}
