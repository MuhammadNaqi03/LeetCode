class MemoryLeakSolution {
  public int[] memLeak(int memory1, int memory2) {
    /**
     * Approach:
     * Until any memory stick has more memory than the current time (in seconds),
     * the program will not crash. We just need to find here which stick we will deduct the memory from.
     */

    int currSecond = 1;
    while (memory1 >= currSecond || memory2 >= currSecond) {
      if (memory1 >= memory2) {
        memory1 -= currSecond;
        currSecond += 1;
      } else {
        memory2 -= currSecond;
        currSecond += 1;
      }
    }
    return new int [] {currSecond, memory1, memory2};
  }
}
