class MaxFreqElemSolution {
  public int maxFrequencyElements(int[] nums) {
    /**
     * Approach 1: Using HashMap
     * We will store the frequencies in a hashamp.
     * Afterwards, we will track the frequencies and find the maximum frequency
     * and how many times the elements with the maximum frequency appear.
     */

    // HashMap <Integer, Integer> freqCounter = new HashMap<>();
    // for (int num : nums) {
    //   freqCounter.put(num, freqCounter.getOrDefault(num, 0) + 1);
    // }

    // int currMaxFreq = 0;
    // int maxElemWithMaxFreq = 0;
    // for (int freq: freqCounter.values()) {
    //   if (currMaxFreq == freq) {
    //     maxElemWithMaxFreq += freq;
    //   } else if (currMaxFreq < freq) {
    //     currMaxFreq = freq;
    //     maxElemWithMaxFreq = freq;
    //   }
    // }

    // return maxElemWithMaxFreq;






    /**
     * Approach 2: Using Frequency Array
     * Same as the previous one, but we will store the frequencies in an array
     * rather than in a hashamap as the number range is small (1 <= nums[i] <= 100).
     */

    int [] freqCounter = new int [101];
    for (int num : nums) {
      freqCounter[num]++;
    }

    int currMaxFreq = 0;
    int maxElemWithMaxFreq = 0;
    for (int freq: freqCounter) {
      if (currMaxFreq == freq) {
        maxElemWithMaxFreq += freq;
      } else if (currMaxFreq < freq) {
        currMaxFreq = freq;
        maxElemWithMaxFreq = freq;
      }
    }

    return maxElemWithMaxFreq;
  }
}
