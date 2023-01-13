class DeleteColumnsSolution {
  public int minDeletionSize(String[] strs) {
    /**
     * Approach:
     * The number of strings are the number of rows and
     * the problem states that the strings are of the same length,
     * so the total column number will be any string's length.
     * Here, the problem only considers about lexicographically sorted in ascending order.
     * And, if the letters are same in ASCII value, that should not be removed as well.
     * So, we will first check if the number of row is less than 0 or not.
     * As, for array with single row (only one element), all columns are sorted.
     * We don't need to worry about empty string (empty column) as per constraints:
     * 1 <= strs[i].length <= 1000; strs[i] consists of lowercase English letters.
     * If the array has more than 1 element, we will check every column for every row
     * and check if the current column and previous column's ASCII value difference is 
     * equal to 0 (for same letter) or more than 0.
     * If, the value difference is less than 0, the column needs to be removed.
     */
 
    int totalColumn = strs[0].length();
    int totalRow = strs.length;
 
    if (totalRow < 2) {
      return 0;
    }
 
    int columnsToRemove = 0;
    for (int currColumn = 0; currColumn < totalColumn; currColumn++ ) {
      int currRow = 1;
      boolean isSorted = true;
      while (isSorted && currRow < totalRow) {
        int currRowsDiff = strs[currRow].charAt(currColumn) - strs[currRow - 1].charAt(currColumn);
        if (currRowsDiff < 0) {
          columnsToRemove += 1;
          isSorted = false; // break out of the loop
        }
        currRow += 1;
      }
    }
    return columnsToRemove;
  }
}
