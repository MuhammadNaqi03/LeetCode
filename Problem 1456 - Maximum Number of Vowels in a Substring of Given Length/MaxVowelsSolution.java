class MaxVowelsSolution {
  /**
   * Approach: Sliding Window
   * As per the given constraints, we don't need to worry about an empty string,
   * invalid characters in the string, or an invalid value of k.
   * To solve the problem, we will first find out the number of vowels in the first substring (from 0 index until k index).
   * Afterwards, following the sliding window approach, we will move the window and 
   * check if the character that we are leaving is a vowel or not.
   * If it's a vowel, then the new substring created by moving the window will have one less vowel.
   * So, we need to subtract 1 from the total vowel count.
   * Before deducting, we need to check if the vowel count is already at 0 or not.
   * If it's already 0, we won't deduct 1 even if the leaving character is a vowel.
   * Similarly, we'll check if the next character that we get by sliding the window is a vowel or not.
   * We'll need to add 1 to the total vowel count if the next character is 1,
   * as we're getting one more vowel in our new substring by moving the window.
   * Another thing to remember is that the maximum possible vowel within a substring of length k is obviously k.
   * So, if our vowel count becomes equal to k at any time, we'll just return k/the vowel count.
   */

  public int maxVowels(String s, int k) {
    int maxVowelCount = 0;
    for (int i = 0; i < k; i++) {
      boolean isCharVowel = isVowel(s.charAt(i));
      maxVowelCount = isCharVowel ? maxVowelCount + 1 : maxVowelCount;
    }

    if (maxVowelCount == k) {
      return maxVowelCount;
    }

    int currVowelCount = maxVowelCount;
    for (int i = 1; i <= s.length() - k; i++) {
      boolean isPrevCharVowel = isVowel(s.charAt(i - 1));
      boolean isNextCharVowel = isVowel(s.charAt(i + k - 1));

      currVowelCount = (isPrevCharVowel && currVowelCount > 0)  ? currVowelCount - 1 : currVowelCount;
      currVowelCount = isNextCharVowel ? currVowelCount + 1 : currVowelCount;
      maxVowelCount = currVowelCount > maxVowelCount ? currVowelCount : maxVowelCount;

      if (maxVowelCount == k) {
        return maxVowelCount;
      }
    }

    return maxVowelCount;
  }




  // Helper method
  public boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c== 'i' || c == 'o' || c == 'u';
  }
}