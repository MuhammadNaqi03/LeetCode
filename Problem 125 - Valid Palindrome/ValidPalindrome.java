class ValidPalindromeSolution {
  public boolean isPalindrome(String s) {
    /** Approach 1: Using regex in replaceAll
    * 1. Make the string lowercase and remove all non-alphanumeric characters
    * 2. Use two pointers to find if the string is palindrome or not.
    */
    
    // First make the letters all lower case and remove all the non neumaric characters
    s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

    // Now loop from both sides to see if the characters match or not
    int x = 0;
    int y = s.length() - 1;
    while (x < y) {
      if (s.charAt(x) != s.charAt(y)) return false;
      x++;
      y--;
    }
    return true;
  }
}