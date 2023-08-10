class LongestSubarraySolution {
  public int longestSubarray(int[] nums) {
    /**
     * Approach: In this problem, we have to remove exactly one element.
     * So, we will keep two counters:
     * one for counting the length of the sequence of 1 before finding a 0 (say, currCount)
     * and one for tracking the length of the previous sequence after finding a 0 (say, prevCount).
     * Whenever we find a 0, we will measure if the summation of currCount and prevCount forms the longest sequence of 1.
     * Then, we will update the prevCount with the value of currCount and update currCount with 0.
     * But if we encounter a 1, we will simply increment the currCount.
     * Here, we have to remove exactly one element, so we will keep a boolean flag to check if we encounter at least one 0.
     * After the loop ends, we need to calculate the longest subsequence with
     * the sum of the existing values of currCount and prevCount.
     * If we haven't encountered a 0 in the sequence, we have to remove one 1, so in this case,
     * the result will be 1 less than the calculated longest subsequence.
     */
    
    int currCount = 0;
    int prevCount = 0;
    int longestSubArray = 0;
    boolean encounteredZero = false;

    for (int num: nums) {
      if (num == 1) {
        currCount += 1;
      } else {
        encounteredZero = true;
        longestSubArray = Math.max(currCount + prevCount, longestSubArray);
        prevCount = currCount;
        currCount = 0;
      }
    }

    return encounteredZero
      ? Math.max(currCount + prevCount, longestSubArray)
      : currCount + prevCount - 1;
  }
}
