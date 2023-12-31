class MaxLengthInSameCharsSoluton {
  public int maxLengthBetweenEqualCharacters(String s) {
    /**
     * Approach:
     * In this problem, we will store the first occurrence of the characters within a hash map.
     * Then, we will find out the length of the substring by deducting the first occurrence
     * and 1 from the current occurrence.
     */

    HashMap<Character, Integer> indexMap = new HashMap<>();
    int largestSubstringLength = -1;

    for (int i = 0; i < s.length(); i++) {
      char currChar = s.charAt(i);
      boolean currCharExists = indexMap.containsKey(currChar);

      if (!currCharExists) {
        indexMap.put(currChar, i);
      } else {
        int firstIndex = indexMap.get(currChar);
        int currSubstringLength = i - firstIndex - 1;

        largestSubstringLength = largestSubstringLength < currSubstringLength
          ? currSubstringLength
          : largestSubstringLength;
      }
    }

    return largestSubstringLength;
  }
}
