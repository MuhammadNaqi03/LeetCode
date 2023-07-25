class PeakIndexSolution {
  public int peakIndexInMountainArray(int[] arr) {
    /**
     * Approach:
     * Here we have an important point to note:
     * 'arr is guaranteed to be a mountain array.'
     * So, it will always have at least one element after the peak.
     *
     * To solve the problem, we will use binary search.
     * We will have conventional left, right, and mid indices.
     * We will run a loop until the left and right indices become the same.
     * For every mid-index, we will check if the next index is greater or lesser.
     * If the next index is greater, that means the peak is on the right side.
     * So, we will update the left index with midIndex + 1.
     * But if the next index has a lower value, that can have two meanings:
     * 1. The peak is on the left side.
     * 2. Or the current mid index itself is the peak index.
     * Thus, in this case, we will update the right with the mid index.
     * When the loop breaks, we will return the left or right index.
     */


    int leftIndex = 0;
    int rightIndex = arr.length - 1;

    while (leftIndex < rightIndex) {
      int midIndex = (leftIndex + rightIndex) / 2;
      if (arr[midIndex] < arr[midIndex + 1]) {
        leftIndex = midIndex + 1;
      } else {
        rightIndex = midIndex;
      }
    }

    return rightIndex; 
  }
}
