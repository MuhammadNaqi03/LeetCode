class ExcelColumnSolution {
  public String convertToTitle(int n) {
    String title ="";
    while(n!=0){
      /*
      * Instead of 1-26. lets convert it to 0 -25
      * thus 0+65 = 65 will indicate as A, 66 as B 
      * and so on.
      * If we don't do that, say we are using title = (char)(n%26 + 64)
      * Then this will work till Z appears.
      * Because for Z, (char)(n%26 + 64) would be 64, which is @.
      */
            
      title = (char)((n-1)%26 + 65) + title;
      n = (n-1)/26;
            
    }
    return title;
  }
}