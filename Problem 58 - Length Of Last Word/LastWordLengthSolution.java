class LastWordLengthSolution {
  public int lengthOfLastWord(String s) {
    // Approach 1. Using split methods:
        
    // String [] splitted = s.split("\s+");
    // return splitted[splitted.length-1].length();
        
        
    /* Approach 2. If split and trim method can not be used:
    * Here we will loop from backwards.
    * Initialize a variable for counting word length.
    * If we find space before a word we will continue. (length will be 0 here)
    * But if we find a space after a word means we just traversed the last word.
    * Return the length of the word
    * And there will be at least one word so we don't need to check for empty string
    */
        
    int wordLength = 0;
    for (int i = s.length()-1; i>=0; i--) {
      if (s.charAt(i) != ' ') {
        wordLength++;
      }
      else if (wordLength > 0) return wordLength;
    }
    return wordLength;
  }
}