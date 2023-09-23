class Solution {
  public boolean IsSubsequenceSolution(String s, String t) {
    /**
     * Approach:
     * If 's' is empty, it would be a subsequence of 't',
     * and that needs to be handled at the very beginning.
     * Afterwards, we will keep a pointer that will point to the current character of 's'.
     * The pointer will only be updated if the current character of 's' matches the current character of 't'.
     * Thus, if the pointer traverses the whole 's', that indicates that it is a subsequence of 't'.
     */

    if (s.length() == 0) {
      return true;
    }

    int sPointer = 0;
    for (int i = 0; i < t.length(); i++) {
      if (s.charAt(sPointer) == t.charAt(i)) {
        sPointer += 1;
        if (sPointer == s.length()) {
          return true;
        }
      }
    }

    return false;      
  }
}
