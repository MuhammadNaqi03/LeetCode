class DetectCapitalSolution {
  public boolean detectCapitalUse(String word) {
    /**
     * For a string with length 1, the given cases will always be true.
     * So, we would return true if the string length is 1.
     * The string won't be empty as per the constraint: '1 <= word.length <= 100'.
     * If the string length is more than 1, we need to find out if the first letter is upper or lower.
     * We will determine that from the ASCII value of the given character.
     * If the first character is in lowercase, we have to check if all characters are in lowercase as well.
     * But if the first character is in uppercase, 
     * we need to find out if the second character is in upper or lower case.
     * If the second character is in uppercase,
     * all the other characters have to be uppercase for the result to be true.
     * But if the second character is in lowercase, all the other characters have to be lowercase.
     */

    if (word.length() < 2) {
      return true;
    }

    int firstCharVal = word.charAt(0);
    /**
     * There will be only uppercase and lowercase English letters as per the constraint:
     * 'word consists of lowercase and uppercase English letters'.
     * So, we don't need to check for invalid characters.
     */
    if (firstCharVal < 97) { // First letter is in uppercase
      if ((int)word.charAt(1) < 97) { // Second letter is also an uppercase letter
        return checkIfAllUpper(word, 2);
      }
      return checkIfAllLower(word, 2);
    } else {
      return checkIfAllLower(word, 1);
    }
  }


  boolean checkIfAllUpper(String word, int startingPoint) {
    for (int i = startingPoint; i < word.length(); i++) {
      if ((int)word.charAt(i) > 90) { // ASCII value of 'Z' is 90
        return false;
      }
    }
    return true;
  }


  boolean checkIfAllLower(String word, int startingPoint) {
    for (int i = startingPoint; i < word.length(); i++) {
      if ((int)word.charAt(i) < 97) { // ASCII value of 'a' is 97
        return false;
      }
    }
    return true;
  }
}
