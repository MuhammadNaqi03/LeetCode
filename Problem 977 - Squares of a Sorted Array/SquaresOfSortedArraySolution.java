class SquaresOfSortedArraySolution {
  public int[] sortedSquares(int[] nums) {
    /*
    * The array itself is in non decreasing manner.
    * So what we do is to compare the absolute value of two extreme
    * Fill up from the back as it's in non-decreasing order
    */
      
    int front = 0;
    int back = nums.length-1;
    int [] newArr = new int [back+1];
    for (int i = nums.length-1; i>=0; i--) {
      if (Math.abs(nums[front]) < Math.abs(nums[back])){
        newArr[i] = nums[back] * nums[back];
        back--;
      }
      else {
        newArr[i] = nums[front] * nums[front];
        front++;
      }
    }
    return newArr;
  }
}