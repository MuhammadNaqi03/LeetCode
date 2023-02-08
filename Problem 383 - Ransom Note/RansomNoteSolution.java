class RansomNoteSolution {
  public boolean canConstruct(String ransomNote, String magazine) {
    /**
     * Approach: Character count
     * Due to the fact - "Each letter in magazine can only be used once in ransomNote",
     * the magazine should have equal or more number of characters than the ransom note.
     * Thus, the ransom note can't have more length than the magazine,
     * We have to count the number of characters for both the ransom note and the magazine.
     * To do that, we'll create an array of size 26 (As, "ransomNote and magazine consist of lowercase English letters").
     * For each character of the strings, we need to find out the corresponding ASCII values.
     * Afterwards, we'll deduct 97 from the values (ASCII value of 'a' is 97), thus those can be used as array indices.
     * For magazine we'll increment the values of the corresponding indices of the array,
     * and for ransom note we'll decrement the values.
     * If the array has no negative values in any index after the deduction, that means,
     * the ransom note can be written using the magazine as the magazine has more or equal characters needed.
     * Here, we don't need to consider the possibility of empty string(s) as per the constraint:
     * 1 <= ransomNote.length, magazine.length <= 105.
     */

    if (ransomNote.length() > magazine.length()) {
      return false;
    }

    int [] charCounter = new int [26];
    for (int i = 0; i < magazine.length(); i++) {
      int charVal = magazine.charAt(i) - 97;
      charCounter[charVal]++;
    }

    for (int i = 0; i < ransomNote.length(); i++) {
      int charVal = ransomNote.charAt(i) - 97;
      if (charCounter[charVal] == 0) {
        return false;
      }
      charCounter[charVal]--;
    }
    return true;
  }
}
