class CountAsterisksSolution {
  public int countAsterisks(String s) {
    /**
     * Approach:
     * The given constraint:
     * "s contains an even number of vertical bars '|'"
     * guarantees that we don't need to think about a lone vertical bar '|'.
     * So, all we need to do is count the number of asterisks that are outside the vertical bar pairs.
     * To do that, we will keep a boolean flag that will become true when the first vertical bar is found
     * and will become false after the second one is found.
     * Thus, using that boolean flag, we can decide which asterisks are out of the vertical bar pairs.
     */

    int asteriskCount = 0;
    boolean insideBarPair = false;

    for (int i = 0; i < s.length(); i++) {
      char currChar = s.charAt(i);
      if (currChar == '*' && !insideBarPair) {
        asteriskCount += 1;
      } else if (currChar == '|') {
        insideBarPair = !insideBarPair;
      }
    }

    return asteriskCount;
  }
}
