class SmallestEvenMultipleSolution {
  public int smallestEvenMultiple(int n) {
    /**
     * Approach:
     * If n itself divisible by the other number (here it is 2), 
     * then it is the smallest multiple of both self and the other number.
     * Otherwise, we have to multiply n and the other number to get the smallest multiple of them.
     */
    return (n % 2) == 0 ?  n : n * 2;
  } 
}