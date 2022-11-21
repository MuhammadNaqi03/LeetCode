class LongestSubstrSolution {
  public int lengthOfLongestSubstring(String s) {
    /**
     * Approach: Using HashMap
     * We need a hashmap, a local and a global counter for counting the longest substring length.
     * We will traverse through each character of the string and
     * find out if our map has the character in it or not.
     * If not, we will put the current character's position inside the map.
     * Also, we will increase the local counter and
     * replace local with global counter if local counter becomes greater.
     * But if the character is already found in the map,
     * then we will get the character's previous position and
     * will move our loop counter after that position to start a new substring.
     * Also, we will reset the map and local counter.
     * After traversing each character, we will return the global counter.
     */

    HashMap <Character, Integer> charMap = new HashMap<>();
    int longestSubstringLength = 0;
    int localLongest = 0;

    for (int i = 0; i < s.length(); i++) {
      Character currentChar = s.charAt(i);
      if (!charMap.containsKey(currentChar)) {
        localLongest++;
        charMap.put(currentChar, i);
        if (localLongest > longestSubstringLength) {
          longestSubstringLength = localLongest;
        }
      } else {
        localLongest = 0;
        i = charMap.get(currentChar); // i will increment and point to the next character of the duplicate character
        charMap.clear();
      }
    } 
    return longestSubstringLength; 
  }
}