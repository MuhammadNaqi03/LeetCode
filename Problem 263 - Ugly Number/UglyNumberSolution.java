class UglyNumberSolution {
  public boolean isUgly(int num) {
    //if num is equal 0 or 1 return false
    if (num==0)
      return false;
    if (num==1)
      return true;
      
    //let's divide with 2,3,5 as long as remainder is 0
    while(num%2==0)
      num = num/2;
    while(num%3==0)
      num = num/3;
    while(num%5==0)
      num = num/5;
      
    //return true if remainder is 1,
    //false other than any prime number
    return num==1;
  }
}