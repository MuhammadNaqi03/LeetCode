class MergeSortedArraySolution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    /*
    * Here some constraints are important -
    * nums1 will always be bigger than nums2 and both sorted
    * the vacant part of nums1 will be occupied with 0
    * Thus, the used part of nums1 and size of nums2 is = total size of nums1
    * Hence, we should compare from the back (larger numbers) and fill them up at the end first
    * By doing so, the merge becomes much much easier as we don't need to use temp variables
    */
      
    // So first, we need to take the last index (excluding zeros) 
    // of both the arrays and last index for total size 
    int index1 = m - 1; 
    int index2 = n -1;
    int totalLength = m + n - 1;
      
    // Then we have to consider the scenerios where the indices can be negative due to the subtraction
    // Afterwards compare the shit
    // Albeit the solution is easy, it has some repeated code blocks. So, the other one is better
    // for ( ; totalLength >= 0; totalLength--) {
    //     if (index2 < 0) {
    //         nums1[totalLength] = nums1[index1];
    //         break; // No need to continue the for loop if there is nothing to add from second array
    //     }
    //     else if (index1 < 0) {
    //         nums1[totalLength] = nums2[index2];
    //         index2--;
    //     }
    //     else if (nums1[index1] > nums2[index2]) {
    //         nums1[totalLength] = nums1[index1];
    //         index1--;
    //     }
    //     else {
    //         nums1[totalLength] = nums2[index2];
    //         index2--;
    //     }
    // }
      
      
      
    // loop through and compare as long as one/both the array indices are not negative
    while (index1 >=0 & index2 >=0) {
        nums1[totalLength--] = nums1[index1] > nums2[index2] ? nums1[index1--] : nums2[index2--];
    }
      
    // Then we need to consider if the second index is null or not 
    // as we add elements from second array to the first one
    while (index2 >=0) {
        nums1[totalLength--] = nums2[index2--];
    }
  }
}