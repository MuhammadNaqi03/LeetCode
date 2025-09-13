class MostFreqSolution {
  public int maxFreqSum(String s) {
    /**
     * Approach:
     * A constraint states,
     * "s consists of lowercase English letters only."
     * So, we can use a frequency array to tackle the problem.
     */

    int [] freqArr = new int [26];
    char [] charArr = s.toCharArray();
    for (char ch: charArr) {
      int convertedNumber =  ch - 97; // 'a' is 97 in ASCII table
      freqArr[convertedNumber]++;
    }

    int maxVowelFreq = 0;
    int maxConsonantFreq = 0;

    for (int i = 0; i < freqArr.length; i++) {
      if (i == 0 || i == 4 || i == 8 || i == 14 || i == 20) {
        maxVowelFreq = maxVowelFreq < freqArr[i] ? freqArr[i] : maxVowelFreq;
      } else {
        maxConsonantFreq = maxConsonantFreq < freqArr[i] ? freqArr[i] : maxConsonantFreq;
      }
    }

    return maxVowelFreq + maxConsonantFreq;
  }
}