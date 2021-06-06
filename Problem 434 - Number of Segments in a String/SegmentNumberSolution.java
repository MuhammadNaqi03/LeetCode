class SegmentNumberSolution {
  public int countSegments(String s) {
    String trimmed = s.trim();
    if(trimmed.equals("")){  //Doesn't work for trimmed == ""
      return 0;
    }
    String [] splitted = trimmed.split("\\s+");
    return splitted.length;
  }
}