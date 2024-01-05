class ConsistentStringSolution {
  public int countConsistentStrings(String allowed, String[] words) {
    /**
     * Approach:
     * To solve this problem, we will map the existing characters in the 'allowed' string to an array.
     * Then, we just need to check every string in the 'words' array to verify
     * that the characters in them exist in the character array or not.
     */

    int [] allowedChars = new int[26];
    for (int i = 0; i < allowed.length(); i++) {
      int charValue = allowed.charAt(i) - 'a';
      allowedChars[charValue] = 1;
    }

    int numberOfConsistantStrings = 0;

    for (String word: words) {
      boolean isConsistantString = true;
      for (int i = 0; i < word.length(); i++) {
        int charValue = word.charAt(i) - 'a';
        if (allowedChars[charValue] == 0) {
          isConsistantString = false;
          break;
        }
      }

      if (isConsistantString) {
        numberOfConsistantStrings += 1;
      }
    }

    return numberOfConsistantStrings;
  }
}
