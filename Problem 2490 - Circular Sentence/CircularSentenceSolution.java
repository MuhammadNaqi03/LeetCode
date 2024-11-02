class CircularSentenceSolution {
  public boolean isCircularSentence(String sentence) {
    /**
     * Approach:
     * According to the given constraints, the sentence is not empty and has no leading or trailing spaces.
     * So, first we will check if the last and first characters of the string are the same or not.
     * If they are the same, then we will look for spaces in the sentence.
     * The sentence is separated by a single space, not multiple spaces, as the constraint states:
     * 'The words in sentence are separated by a single space.'
     * So, all we need to do is to check the characters before and after the spaces.
     */

    if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) {
      return false;
    }

    for (int i = 0; i < sentence.length(); i++) {
      if (sentence.charAt(i) == ' ' && sentence.charAt(i - 1) != sentence.charAt(i + 1)) {
        return false;
      }
    }

    return true;  
  }
}
