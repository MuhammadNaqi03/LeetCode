class UniqueCharSolution {
  public int firstUniqChar(String s) {
    /**
     * Approach: Using frequency array
     * One of the constraints states that "s consists of only lowercase English letters".
     * So, we can convert the ASCII value of the letters and use them as array indices to store their frequencies.
     * After that, we can traverse again, and we can check which letter is the first to appear only once (has frequency 1).
     * If no such letter can be found, we will return -1 as instructed.
     */
    int [] frequencyArr = new int [26];

    // Build the frequency array
    for (int i = 0; i < s.length(); i++) {
      int modifiedCharVal = s.charAt(i) - 97; // ASCII value of 'a' is 97
      frequencyArr[modifiedCharVal]++;
    }

    // Find out the first unique character
    for (int i = 0; i < s.length(); i++) {
      int modifiedCharVal = s.charAt(i) - 97;
      if (frequencyArr[modifiedCharVal] == 1) {
        return i;
      }
    }
    return -1;
  }
}
