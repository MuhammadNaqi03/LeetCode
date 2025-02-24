class TwoStringsDiffSolution {
  public int findPermutationDifference(String s, String t) {
    /**
     * Approach:
     * Since, as per the given constraints, one character can appear at most once,
     * the string only contains lowercase letters, and the t string is a permutation
     * of the s string, we can solve this problem using a frequency array.
     * First, we need to map the indices of the characters of string s in the frequency array.
     * Then, we have to iterate the t string and find out the corresponding absolute distances
     * of the characters of the t string with respect to the frequency array
     * containing the indices of the s string.
     */

    int [] freqArr = new int [26];
    for (int i = 0; i < s.length(); i++) {
      freqArr[(int)(s.charAt(i)) - 97] = i;
    }

    int absoluteDiff = 0;

    for (int i = 0; i < t.length(); i++) {
      absoluteDiff += Math.abs(freqArr[(int)(t.charAt(i)) - 97] - i);
    }

    return absoluteDiff;
  }
}
