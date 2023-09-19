class TeemoSolution {
  public int findPoisonedDuration(int[] timeSeries, int duration) {
    /**
     * Approach:
     * To calculate the poisoned duration,
     * we need to get the minimum of the given duration
     * and the difference between the next attack and the current attack.
     * At the very last attack, the poisoned duration will be the whole given duration,
     * as there's no next attack by which the poison duration could reset.
     */

    int totalPoisonedSecond = 0;
    for (int i = 0; i < timeSeries.length - 1; i++) {
      totalPoisonedSecond += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
    }

    return totalPoisonedSecond + duration;
  }
}