class ReverseWordsSolution {
  public String reverseWords(String s) {
    /**
     * Approach 1: 
     * Firstly, we need to trim both sides to remove the spaces.
     * Then, we will split the words based on the space(s).
     * Following that, we will add the words from the end of the array
     * and add space with it, if it's not the last word of the array.
     * Return the sentence after the loop ends.
     */

    // String trimmed = s.trim();
    // String [] splitted = trimmed.split("\\s+");
    // String reversedSentence = "";
    // for (int i = splitted.length-1; i >= 0; i--){
    //   reversedSentence += splitted[i];
    //   if(i != 0){
    //     reversedSentence += " ";
    //   }
    // }
    // return reversedSentence;






    /**
     * Approach 2: Two Pointers
     * First, we will assign two pointers at the very end of the string (say, firstPointer and secondPointer).
     * We also need an object of StringBuilder where we will add the words in reverse.
     * It is important to note that:
     * s contains English letters (upper-case and lower-case), digits, and spaces ' '
     * Now, we'll loop until firstPointer reaches the beginning of the string
     * and will check if the current character is a space (" ").
     * If we find a space, we will move both pointers until we find a non-space character 
     * or if the firstPointer becomes less than 0.
     * And if we find a non-space character, we will just move the firstPointer until we find a 
     * space (" ") or the firstPointer becomes less than 0.
     * We will add the substring from firstPointer + 1 
     * (as the pointer moved to the previous " " or becomes -1). Also, we will add space between the words.
     * Then, after the loop ends, we will transform the StringBuilder object to a string and return it.
     */
    
    StringBuilder reverseSentenceSB = new StringBuilder();
    int firstPointer = s.length() - 1;
    int secondPointer = firstPointer;

    while (firstPointer >= 0) {
      if ((s.charAt(firstPointer) == ' ')) {
        while (firstPointer >= 0 && s.charAt(firstPointer) == ' ') {
          firstPointer -= 1;
          secondPointer = firstPointer;
        }
      } else {
        while (firstPointer >= 0 && s.charAt(firstPointer) != ' ') {
          firstPointer -= 1;
        }

        // If a new word is found, add space before the previous word (if any)
        if (!reverseSentenceSB.isEmpty()) {
          reverseSentenceSB.append(" ");
        }

        // The firstPointer is either at -1 or pointing at a space (" ")
        String word = s.substring(firstPointer + 1, secondPointer + 1);
        reverseSentenceSB.append(word);
      }
    }
    return reverseSentenceSB.toString();
  }
}
