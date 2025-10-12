class ReverseDegreeSolution {
  public int reverseDegree(String s) {
    /**
     * Approach:
     * Here, we need to consider only the lowercase English letters as per the constraint:
     * 's contains only lowercase English letters.'
     * To get the 'Index in Reversed Alphabet' of the current character,
     * we need to deduct the ASCII value of the character from the
     * ASCII value of 'z' + 1 (index count starts from 1).
     * Then just multiply the index of the character with it (index count starts from 1).
     * We have to do that for every character in the string by running a loop to get the total.
     */

    int total = 0;
    for (int i = 0; i < s.length(); i++) {
      total += (123 - s.charAt(i)) * (i + 1);  // ASCII value of 'z' is 122
    }

    return total;
  }
}