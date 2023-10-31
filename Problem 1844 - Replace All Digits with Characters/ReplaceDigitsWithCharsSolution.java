class ReplaceDigitsWithCharsSolution {
  public String replaceDigits(String s) {
    StringBuilder sb = new StringBuilder(s.length());

    for (int i = 0; i < s.length() - 1; i = i + 2) {
      sb.append(s.charAt(i));
      sb.append(shift(s.charAt(i), s.charAt(i + 1)));
    }

    if (s.length() % 2 != 0) {
      sb.append(s.charAt(s.length() - 1));
    }

    return sb.toString();
  }

  public char shift(char c, char shiftPositionChar) {
    int shiftPosition = shiftPositionChar - '0';
    char shiftedChar = (char)(c + shiftPosition);
    return shiftedChar;
  }
}
