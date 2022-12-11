class toLowerCaseSolution {
  public String toLowerCase(String s) {
    /**
     * Approach 1: Using built in function
     */
    // return s.toLowerCase();  




    /**
     * Approach 2:
     * The problem states:
     * 's consists of printable ASCII characters'.
     * And we only need to take care of the uppercase letters only, ignoring anything else.
     * So, we will just check if a given character is within the range of upper case letters.
     * If so, we will just convert that to corresponding lower case letter.
     * Convertion: ASCII value of 'A' is 65 and 'Z' is 90.
     * On the other hand, ASCII value of 'a' is 97 and 'z' is 122.
     * So, if we add 32 with the ASCII value of uppercase letters,
     * we will get the corresponding lowercase letters.
     */ 

    char [] charArr = s.toCharArray();
    for (int i = 0; i < charArr.length; i++) {
      int charVal = charArr[i];
      if (charVal >= 65 && charVal <= 90) {
        charArr[i] = (char)(charVal + 32);
      }
    }
    return new String(charArr);
  }
}