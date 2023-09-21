class ExcelCellsSolution {
  public List<String> cellsInRange(String s) {
    /**
     * Approach:
     * First, find the starting and ending column numbers, along with the starting and ending row numbers.
     * Then, just append the corresponding column to the row number from the starting to the ending column and row.
     */
    List <String> cellList = new ArrayList<>();

    int startingCharAscii = (int)(s.charAt(0));
    int endingCharAscii = (int)(s.charAt(3));
    int startingNum = Character.getNumericValue(s.charAt(1));
    int endingNum = Character.getNumericValue(s.charAt(4));

    for (int i = startingCharAscii; i <= endingCharAscii; i++) {
      for (int j = startingNum; j <= endingNum; j++) {
        cellList.add(Character.toString((char)(i)) + j);
      }
    }

    return cellList;
  }
}
