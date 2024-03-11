class MinCommonValueSolution {
  public int getCommon(int[] nums1, int[] nums2) {
    /**
     * Approach: Two Pointers
     * The array is sorted in non-decreasing order, and we need to find out the minimum common value.
     * So, we will use two pointers pointing at the very beginning of the array.
     * Then, if they point to the same number, we will return that.
     * Otherwise, we will move the pointer that points to the lesser value.
     */

    int nums1Pointer = 0;
    int nums2Pointer = 0;

    while (nums1Pointer < nums1.length && nums2Pointer < nums2.length) {
      if (nums1[nums1Pointer] == nums2[nums2Pointer]) {
        return nums1[nums1Pointer];
      } else if (nums1[nums1Pointer] > nums2[nums2Pointer]) {
        nums2Pointer++;
      } else {
        nums1Pointer++;
      }
    }

    return -1;
  }
}
