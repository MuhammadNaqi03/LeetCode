class BinaryGapSolution {
  public int binaryGap(int n) {
    /**
     * Here, we need to track when we get the first 1 of the pair (if there is any)
     * and the last 1 of the pair (the last 1 would be the first 1 of the next pair if there is any, and so on).
     * Also, we need to count the in-between 0s of the pair.
     * To do so, we will initialize two variables that will track the current (say, currGap)
     * and maximum (say, largestGap) gaps between the pairs.
     * Both will be initialized as 0, which will indicate that no pairs of 1 are still found.
     * Then, we will run a loop that will run until the number becomes 0
     * (we will right shift the number to 1 position on each iteration).
     * If we find a 1, that means it could be the start of a new pair (if there is any)
     * or the end of an existing pair (also the start of a new pair if there is any).
     * In both cases, we need to update the 'currGap' to 1 (which will indicate that the start of a pair is found).
     * And, if it's the end of the existing pair, we need to update the 'largestGap', if applicable.
     * On the other hand, if we encounter a 0 and the 'currGap' is not 0,
     * it means that the 0 resides in-between the pair (if there is any) of 1s.
     * In this case, we need to increment the 'currGap' by 1.
     */

    int currGap = 0;
    int largestGap = 0;
    while (n != 0) {
      if ((n & 1) == 1) {
        if (currGap != 0) { // Last 1 of the pair and the beginning of a new pair
          largestGap = currGap > largestGap ? currGap : largestGap;
        }
        currGap = 1; // First 1 of the pair 
      } else if (currGap != 0) {
        currGap += 1;
      }
      n >>= 1;
    }
    return largestGap;
  }
}
