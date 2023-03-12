class ReverseWords3Solution {
  public String reverseWords(String s) {
    /**
     * Approach:
     * We'll use two stringBuilders for that problem.
     * One will reverse the current word, and the other will add the reversed word.
     * If a space is found, that is also added with the appended word.
     * We don't need to worry about trailing or leading spaces or multiple spaces as per the constraints:
     * 's does not contain any leading or trailing spaces'.
     * 'All the words in s are separated by a single space'.
     * Also, the sentence will not have invalid characters as per the constraint:
     * 's contains printable ASCII characters'.
     */
    
    int pointer = 0;
    StringBuilder currWordSb = new StringBuilder();
    StringBuilder totalSentenceSb = new StringBuilder();
    while (pointer < s.length()) {
      if (s.charAt(pointer) != ' ') {
        currWordSb.insert(0, s.charAt(pointer));
      } else {
        totalSentenceSb.append(currWordSb);
        totalSentenceSb.append(' ');
        currWordSb.setLength(0); // Empty the stringBuilder with the reversed word
      }
      pointer += 1;
    }

    totalSentenceSb.append(currWordSb); // Add the last reversed word that doesn't end with a space
    return totalSentenceSb.toString();
  }
}
