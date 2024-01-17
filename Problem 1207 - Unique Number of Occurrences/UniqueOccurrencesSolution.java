class UniqueOccurrencesSolution {
  public boolean uniqueOccurrences(int[] arr) {
    /**
     * Approach:
     * The range of numbers is '-1000 <= arr[i] <= 1000'. So, we have to deal with just 2001 numbers.
     * As a result, we can use a frequency array to map the frequency of each given number.
     * Then, we will transverse the frequency array and save the frequency as a key and the number as a value in a hash map.
     * If the map already has the given frequency, then the answer will be false.
     */

    int [] freqArr = new int [2001];
    for (int num: arr) {
      // As the lowest number is -1000, add 1000, thus it can be mapped as index 0, and so on
      freqArr[num + 1000]++;
    }

    HashMap <Integer, Integer> freqMap = new HashMap<>();
    for (int i = 0; i < freqArr.length; i++) {
      int currFreq = freqArr[i];
      if (currFreq == 0) { // The number is not in the array
        continue;
      }

      if (freqMap.containsKey(currFreq)) {
        return false;
      }

      freqMap.put(currFreq, i - 1000);
    }

    return true;
  }
}
