class HighestAltSolution {
  public int largestAltitude(int[] gain) {
    int maxGain = 0;
    int runningTotal= 0;
    for (int currGain : gain) {
      runningTotal += currGain;
      maxGain = runningTotal > maxGain ? runningTotal : maxGain;
    }
    return maxGain;
  }
}
