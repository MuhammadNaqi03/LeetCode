class SplitIntoBalancedStringsSolution {
  public int balancedStringSplit(String s) {
    //Algo: Whenever we find R we increase some count
    //Otherwise decrease it
    //So whenever it becomes 0 we have one substring with 
    //same number of R and L
      
    int numR = 0;
    int quantity = 0;
      
    for (int i=0; i<s.length(); i++){
      numR += s.charAt(i) == 'R'? 1:-1;
      if (numR==0){
        quantity +=1;
      }
    }
    return quantity;
  }
}