class MostWaterSolution {
  public int maxArea(int[] height) {
    /**
     * Approach: Two pointers
     * We can think the container as a rectangle.
     * So, we can maximise the containing water by maximising the area of the rectangle.
     * If we move the pointers to left/right, we decrease the width of the rectangle.
     * Thus, the only way to maximise the area of the rectangle would be maximising the height.
     * We will have two indices to indicate leftmost and rightmost indices.
     * Until the rightIndex is greater we will continue the loop.
     * Inside the loop, we will find the minimum of two heights between the left and right.
     * Then, we will get the area by multiplying the minimum height with the width.
     * The width will be rightIndex - leftIndex.
     * Then we will check the calculated area with the previous maximum area 
     * and update the max if necessary.
     * For moving the pointers, we will move the pointer representing the min height.
     */
 
 
    int leftIndex = 0;
    int rightIndex = height.length - 1;
    int maxArea = 0;
 
    while (leftIndex < rightIndex) {
      int min = Math.min(height[leftIndex], height[rightIndex]);
      int localArea = min * (rightIndex - leftIndex);
      if (localArea > maxArea) {
        maxArea = localArea;
      }
      if (min == height[leftIndex]) {
        leftIndex++;
      } else {
        rightIndex--;
      } 
    }
    return maxArea;
  }
}