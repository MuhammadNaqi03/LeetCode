class SignOfProductSolution {
  public int arraySign(int[] nums) {
    /**
     * All we need to do is track two things:
     * 1. If any 0 appears:
     * The whole answer would be 0 in this case; thus, we will just return 0.
     * 2. The number of negative numbers:
     * If we have an even number of negative numbers, then the product will be positive.
     * Otherwise, the product will be negative.
     */

    int negativeCount = 0;

    for (int num: nums) {
      if (num == 0) {
        return 0;
      }

      negativeCount = num < 0 ? negativeCount + 1 : negativeCount;
    }

    return negativeCount % 2 == 0 ? 1 : -1;
  }
}
