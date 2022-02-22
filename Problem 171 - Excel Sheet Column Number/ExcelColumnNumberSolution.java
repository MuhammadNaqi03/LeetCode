class ExcelColumnNumberSolution {
  public int titleToNumber(String columnTitle) {
    /**
    * Don't need to look for empty string as constraint: 1 <= columnTitle.length <= 7
    * Also we don't need to look for lower letter as the constraint: 
    * columnTitle consists only of uppercase English letters
    * 1. Will loop through the characters of the string in backwards
    * 2. We will treat the characters as base 26 numbers. 
    * So, have to multiply the number minus 64 (as A = 1, B = 2 and so on), 
    * with the base power number's position
    * Thus, A becomes 65 - 64 + 26^0 --> 1
    * AB becomes (65 - 64 * 26^1)  + (66 - 64 * 26^0) --> 28
    * ZY becomes (90 - 64 * 26^1) + (89- 64 * 26^0) --> 701
    */
    double num = 0;
    int position = 0;

    for (int i = columnTitle.length() - 1; i >= 0; i--) {
      // Will get loosy conversion error if we declare num as int.
      num = num + (columnTitle.charAt(i) - 64) * Math.pow(26, position); 
      position++;
    }
    return (int)num;
  }
}