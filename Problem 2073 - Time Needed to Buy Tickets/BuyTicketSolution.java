class BuyTicketSolution {
  public int timeRequiredToBuy(int[] tickets, int k) {
    /**
     * Approach:
     * Here, the person needs to at least come ticket[k]th time to collect her/his desired amount of tickets.
     * Thus, to find out the time needed for it, we need to add the tickets[k]th value with
     * minimum of the tickets[k]th value and tickets[i]th values for all the persons before the kth person.
     * But the person won't stand after s/he collects her/his tickets.
     * So, for the persons after the kth person, we need to add minimum of the tickets[k] - 1, and the tickets[i]th values.
     */

    int totalTime = 0;
    for (int i = 0; i < tickets.length; i++) {
      totalTime = i <= k
        ? totalTime + Math.min(tickets[i], tickets[k])
        : totalTime + Math.min(tickets[i], tickets[k] - 1);
    }

    return totalTime;
  }
}
