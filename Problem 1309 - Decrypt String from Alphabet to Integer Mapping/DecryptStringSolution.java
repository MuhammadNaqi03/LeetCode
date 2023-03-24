class DecryptStringSolution {
  public String freqAlphabets(String s) {
    /**
     * We need to traverse from the end of the array (and thus construct the resulting array the same way)
     * because the value from 10 to 26 has a '#' at the very end.
     * As a result, we can move our pointer 3 steps if we find a '#' as the current character
     * and extract the two characters representing the value of the mapped character.
     * Otherwise, the pointer will move just one step and a single character will represent the value of the mapped character.
     * The problem becomes more easier as per the constraints:
     * 's consists of digits and the '#' letter.'
     * 's will be a valid string such that mapping is always possible.'
     * Thus, we don't need to check for invalid characters as well.
     */

    /**
     * Approach 1:
     * 'a' is set to 1 and 'z' is 26.
     * So, we can store the characters in an array and 
     * the array index + 1 will represent the mapped characters value.
     */

    // char [] charArr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    // int currPointer = s.length() - 1;
    // int currVal = 0;

    // StringBuilder sb = new StringBuilder();
    // while (currPointer >= 0) {
    //   if (s.charAt(currPointer) == '#') {
    //     currVal = Integer.parseInt(s.substring(currPointer - 2, currPointer));
    //     currPointer -= 3;
    //   } else {
    //     currVal = Character.getNumericValue(s.charAt(currPointer));
    //     currPointer -= 1;
    //   }
    //   sb.insert(0, charArr[currVal - 1]);
    // }
    // return sb.toString();





    /**
     * Approach 2:
     * We don't need to save the characters inside an array.
     * We can just convert the values and map them into corresponding characters on the fly.
     */
    int currPointer = s.length() - 1;
    char currChar = ' ';
    int charVal = 0;
    StringBuilder sb = new StringBuilder();
    while (currPointer >= 0) {
      if (s.charAt(currPointer) == '#') {
        charVal = 96 + Integer.parseInt(s.substring(currPointer - 2, currPointer));
        currPointer -= 3;
      } else {
        charVal = 96 + Character.getNumericValue(s.charAt(currPointer));
        currPointer -= 1;
      }
      currChar = (char)charVal;
      sb.insert(0, currChar);
    }
    return sb.toString();
  }
}
