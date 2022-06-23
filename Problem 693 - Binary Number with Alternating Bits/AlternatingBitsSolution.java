class AlternatingBitsSolution {
  public boolean hasAlternatingBits(int n) {
    /**
    * Approach: Right shift by one
    * Firstly, We will get the first bit of the given number.
    * Based on that, we will determine what the next bit should be.
    * Until n becomes 0 we will run a loop.
    * Inside the loop, we right shift the number by one and get the nextBit.
    * If the next bit is not what it should be we will return false.
    * We will shift the firstBit and what should be the next bit inside the loop afterwards.
    * If we get out of the loop it means all the bits are alternating, thus will return true.
    */
    
    int firstBit = n & 1;
    int nextBitShouldBe = firstBit == 1 ? 0 : 1;
    while (n != 0) {
      n = n >> 1;
      int nextBit = n & 1;
      if (nextBit != nextBitShouldBe) {
        return false;
      }
      nextBitShouldBe = firstBit;
      firstBit = nextBit;
    }
    return true;
  }
}
