class PlusOneSolution {
  public int[] plusOne(int[] digits) {
    /*
    As it won't have any leading 0 (given constraint) so if it has a 0 then
    it means that the array is [0]. 
    */
    if (digits[0]==0) return new int[]{1};
    int arrLen = digits.length-1; //Need to preserve the length of the array
      
    /* 
    Convert the last 9(s) to 0
    Example 1: 99 --> 00 ; If this type go to way 1
    Example 2: 3829 --> 3820 ; 121 --> 121; If this type go to way 1
    */
    while (arrLen >=0 && digits[arrLen] ==9){
      digits[arrLen] = 0;
      arrLen--;
    }
      
    //Way 1
    //Check if the array is full of 0(s). In this case we will return a new array
    if (digits[0]==0) {
      int newArr [] = new int[digits.length+1]; //By default all entries will be 0
      newArr [0] = 1;
      return newArr;
    }
      
    //Way 2
    //For numbers that has one more or none (but not all) 9(s)
    digits[arrLen]++;
    return digits;
  }
}