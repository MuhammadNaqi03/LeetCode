class ValidAnagramSolution {
  public boolean isAnagram(String s, String t) {
    /**
    * If s and t are not of the same length then they are not anagrams
    * The problem has constraint:
    * s and t consist of lowercase English letters. 
    * But in interview ask the interviewer if the case of letters matters or not.
    * Make an array of size 26 (as there are 26 letters in english language).
    * Then loop for the first string and increment the value of corresponding index of the array by one as the value of respective letter.
    * For doing that, transform the ascii value such that a becomes 0, b becomes 1 and so on.
    * Then make another loop where decrement the value of corresponding index by 1 as the value of respective letter.
    * If we find any negative value that indicates that the letter was not present in previous string.
    * Return false in that case, 
    * return true after looping the whole string.
    */
    
    if (s.length() != t.length()) {
      return false;
    }
    
    int [] anagramChecker = new int [26];
    int charValue = 0;
    char [] sCharArray = s.toCharArray();
    char [] tCharArray = t.toCharArray();

    // Loop for the first string:
    for (int i = 0; i < s.length(); i++) {
      charValue = (int)(s.charAt(i)) - 97;  // Ascii value of a is 97
      anagramChecker[charValue]++; 
    }

    // Loop for the second string:
    for (int i = 0; i < t.length(); i++) {
      charValue = (int)(t.charAt(i)) - 97;
      anagramChecker[charValue]--;
      if (anagramChecker[charValue] < 0) {
        return false;
      }
    }

    return true;
        
  }
}