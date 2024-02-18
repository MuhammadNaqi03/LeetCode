class FirstPalindromeSolution {
  public String firstPalindrome(String[] words) {
    /**
     * Approach:
     * We will check the strings for a palindrome with two pointers and return the first one we get.
     * Will return an empty string otherwise.
     */

    for (String word: words) {
      boolean isPalindrome = checkPalindrome(word);
      if (isPalindrome) {
        return word;
      }
    }

    return "";
  }

  public boolean checkPalindrome(String word) {
    int firstPointer = 0;
    int secondPointer = word.length() - 1;

    while (firstPointer < secondPointer) {
      if (word.charAt(firstPointer++) != word.charAt(secondPointer--)) {
        return false;
      }
    }

    return true;
  }
}
