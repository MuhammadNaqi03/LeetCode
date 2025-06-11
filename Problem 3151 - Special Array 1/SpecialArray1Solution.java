class SpecialArray1Solution {
  public boolean isArraySpecial(int[] nums) {
    /**
     * Approach:
     * Keep two flags to determine if the previous number is odd or even.
     * If any successive numbers are odd/even, return false; otherwise, return true.
     */

    boolean isPrevEven = false;
    boolean isPrevOdd = false;

    for (int num: nums) {
      if (num % 2 == 0) {
        if (isPrevEven) {
          return false;
        }
        isPrevEven = true;
        isPrevOdd = false;
      } else {
        if (isPrevOdd) {
          return false;
        }
        isPrevEven = false;
        isPrevOdd = true;
      }
    }

    return true;

  }
}
