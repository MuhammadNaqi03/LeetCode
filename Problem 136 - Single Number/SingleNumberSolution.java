class SingleNumberSolution {
  public int singleNumber(int[] nums) {
    /* Easier solution could be done with XOR
    We Know that in logic XOR gives 0 for being the same and 1 otherwise.
    In this sense if we do XOR then the same number will become 0 together leaving
    the unique number.
    Example: 4 ^ 1 ^ 2 ^ 1 ^ 2
    4 ^ (1 ^ 1) ^ (2 ^ 2)
    4 ^ 0 ^ 0
    4
    XOR solution applies because the duplicate number appears exactly twice
    Or if they appear even number it will work as well. But for arbitrary number,
    this solution will fail to produce result.
    Again the problem states the array will be non-empty thus we don't need to check 
    for it.
    */
      
    int unique = 0;
    for (int i = 0; i<nums.length; i++){
      unique ^= nums[i];
    }
      
    return unique;
  }
}