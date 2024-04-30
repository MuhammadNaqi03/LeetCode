class MaxProductSolution {
  public int maxProduct(int[] nums) {
    /**
     * Approach:
     * In this problem, we only need to find the two maximum numbers in the array.
     * Afterwards, we need to return the multiplication of those numbers after deducting 1 from both.
     */

    int firstMaxElement = -1;
    int secondMaxElement = -1;

    for (int num: nums) {
      if (num >= firstMaxElement) {
        secondMaxElement = firstMaxElement;
        firstMaxElement = num;
      } else if (num > secondMaxElement) {
        secondMaxElement = num;
      }
    }

    return (firstMaxElement - 1) * (secondMaxElement - 1);
  }
}
