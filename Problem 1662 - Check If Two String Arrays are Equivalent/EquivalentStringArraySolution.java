class EquivalentStringArraySolution {
  public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    /**
     * Approach 1: Concatenation
     * Will just add the strings of both arrays separately 
     * and compare them for equality. 
     */ 
//     StringBuilder sb1 = new StringBuilder();
//     StringBuilder sb2 = new StringBuilder();
    
//     for (String s: word1) {
//       sb1.append(s);
//     }
    
//     for (String s: word2) {
//       sb2.append(s);
//     }
    
//     String firstString = sb1.toString();
//     String secondString = sb2.toString();
    
//     return firstString.equals(secondString);
    

    
    

    /**
     * Approach 2: Using pointers
     * We will use 4 pointers here. 
     * Two for pointing out the ecurrent words of the array 
     * and the other two for current characters of the words.
     * If we find any mismatch between characters, then we will return false.
     * Otherwise we will increment the pointers pointing to the current character of the current word.
     * If we reach the very end of the word, we will move to the next word
     * and update the current character pointer to point to the first character of the word.
     * We will do until we reach the end of both of the arrays.
     * If we don't find any mismatches and both arrays reached to their ends,
     * that means the two string arrays are equivalent, thus we will return true.
     */
    
    int currWordIndex1 = 0;
    int currWordIndex2 = 0;
    int currCharIndex1 = 0;
    int currCharIndex2 = 0;

    // Loop until we reach at the end of the one or both arrays
    while (word1.length > currWordIndex1 && word2.length > currWordIndex2) {
      if (word1[currWordIndex1].charAt(currCharIndex1) != word2[currWordIndex2].charAt(currCharIndex2)) {
        return false;
      }
      currCharIndex1++; 
      currCharIndex2++;

      // If we reach at the end of the word then move to the next word
      if (word1[currWordIndex1].length() == currCharIndex1) {
        currWordIndex1++;  // Move to the next word
        currCharIndex1 = 0;  // Point to the first character
      }
      if (word2[currWordIndex2].length() == currCharIndex2) {
        currWordIndex2++;  // Move to the next word
        currCharIndex2 = 0;  // Point to the first character
      }
    }
    
    // Check if the pointers reached to the last characters of the last words
    return ((word1.length == currWordIndex1) && (word2.length == currWordIndex2));
  }
}