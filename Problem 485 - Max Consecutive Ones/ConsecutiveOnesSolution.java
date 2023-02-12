class ConsecutiveOnesSolution {
  public int findMaxConsecutiveOnes(int[] nums) {
    // Pretty easy problem; No explanation is needed
    int consecutiveMaxOnes = 0;
    int localMax = 0;
    for (int num: nums) {
      if (num != 0) {
        localMax += 1;
        if (localMax > consecutiveMaxOnes) {
          consecutiveMaxOnes = localMax;
        }
      } else {
        localMax = 0;
      }
    } 
    return consecutiveMaxOnes; 
  }
}
