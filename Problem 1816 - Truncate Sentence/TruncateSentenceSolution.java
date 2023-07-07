class TruncateSentenceSolution {
  public String truncateSentence(String s, int k) {
    /**
     * In this problem, we only need to count the number of spaces and the string index.
     * As per the constraint: "The words in s are separated by a single space",
     * we don't need to check for multiple spaces as well.
     * After the space count becomes equal to the given k,
     * we will simply return the substring from the 0th index until the index where the space count equals the value of k.
     * We will return the whole string if the value of k is greater than the space count.
     * Also, we don't need to think about leading or trailing spaces as per the given constraint:
     * "There are no leading or trailing spaces".
     */

    int stringIndex = 0;
    int currSpaceCount = 0;

    for (int i = 0; i < s.length() - 1; i++) {
      if (s.charAt(i) == ' ') {
        currSpaceCount += 1;
        if (currSpaceCount == k) {
          return s.substring(0, stringIndex);
        }
      }
      stringIndex += 1;
    }

    return s;
  }
}
