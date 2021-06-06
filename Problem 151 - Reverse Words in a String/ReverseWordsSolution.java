class ReverseWordsSolution {
  public String reverseWords(String s) {
    String trimmed = s.trim();
    String [] splitted = trimmed.split("\\s+");
    String reversedWord = "";
    for (int i = splitted.length-1; i>=0; i--){
      reversedWord = reversedWord +splitted[i];
      if(i!=0){
        reversedWord+=" ";
      }
    }
    return reversedWord;
  }
}