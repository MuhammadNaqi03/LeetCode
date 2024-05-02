class Solution {
  public String reversePrefix(String word, char ch) {
    /**
     * Approach:
     * First, we need to find out if the character exists in the string.
     * If it doesn't, we will just return the original string.
     * But if the character exists, then we will find the substring containing
     * the first appearance of the character and reverse it.
     * Then, we will add that to the last part of the string.
     */

    int firstIndex = word.indexOf(ch);
    if (firstIndex == -1) {
      return word;
    }

    StringBuilder sb = new StringBuilder(word.substring(0, firstIndex + 1))
                           .reverse()
                           .append(word.substring(firstIndex + 1));

    return sb.toString();
  }
}
