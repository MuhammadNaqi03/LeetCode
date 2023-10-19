class AcronymStringSolution {
  public boolean isAcronym(List<String> words, String s) {
    /**
     * Approach:
     * To be the accronym:
     * 1. The string size and the list size have to be the same.
     * 2. The first character of every string in the list has to be the same as the corresponding character of the acronym string.
     */

    if (words.size() != s.length()) {
      return false;
    }

    int sPointer = 0;
    for (String word: words) {
      if (word.charAt(0) != s.charAt(sPointer)) {
        return false;
      }
      sPointer += 1;
    }
    return true;
  }
}
