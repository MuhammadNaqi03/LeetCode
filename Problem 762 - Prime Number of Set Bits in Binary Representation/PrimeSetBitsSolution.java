class PrimeSetBitsSolution {
  public int countPrimeSetBits(int left, int right) {
    /**
     * Approach 1: Using Brian Kernighan's algorithm 
     * First, we will have an arraylist with all the primes between 0 - 32. 
     * (As the number can be represented by 32 bits)
     * Then we will run a loop from left to right.
     * For every number, we will use Brian Kernighan's algorithm and find out the number of set bits.
     * (To know more about the algorithm check out - Problem 191 - Number of 1 bits)
     * Then, we will find out if the number of set bits is in the prime numbers list or not.
     * We will increment the counter if we find the number of set bits 
     * and will return the counter after the loop ends.
     */


    ArrayList<Integer> primeNumberList = new ArrayList<>(Arrays.asList(2,3,5,7,11,13,17,19,23,29,31));
    int count = 0;

    for (int i = left; i <= right; i++) {
      int currentNum = i;
      int bitCount = 0;
      while (currentNum != 0) {
        bitCount++;
        currentNum = currentNum & (currentNum - 1);
      }
      if (primeNumberList.contains(bitCount)) {
        count++;
      }
     }
    return count;
  }
}
