class Solution {
  public void rotate(int[] nums, int k) {
    /**
     * Approach 1: Naive - In place (Time limit exceeds at test 37/38)
     * We have to consider some cases in here,
     * a. If the array length is 1 - we don't need to rotate as it will be the same regardless k's value.
     * b. If k's value is more than nums length - then we have to reduce k's value.
     * c. If k's value is 0 or k's value and nums length are equal - then there's no rotation neeeded.
     * So, at first, we have to tackle those cases.
     * Then, We will rotate every number one step right till k.
     * We don't need to check for empty array as per constraint:
     * 0 <= k <= 105
     */

    // Making sure k is less than nums.length
//     k = k % nums.length;

//     if (k != 0 && nums.length != 1) {
//       int rightmostNumber = nums[nums.length - 1];
//       while (k > 0) {
//         for (int i = nums.length - 1; i > 0; i--) {
//           nums[i] = nums[i - 1];
//         }
 
//         // Replace the leftmost value with rightmost value and update the rightmost value
//         nums[0] = rightmostNumber;
//         rightmostNumber = nums[nums.length - 1];
//         k--;
//       }
//     }
    
    
    
    
    
    
    /**
     * Approach 2: Out of place
     * Just like first approach, at the beginning, we have to tackle the cases.
     * Then, we fill find the index (say, startIndex) from where the elements of nums will be shifted.
     * We will create a new array and will put those elements at the very beginning.
     * The rest of the array will be filled up with the elements of 0 index upto startIndex of nums.
     */
    
    // Making sure k is less than nums.length
    k = k % nums.length;

    if (k != 0 && nums.length != 1) {
      int startingIndex = nums.length - k;
      int [] returnedArr = new int [nums.length];
 
      int counter = 0;
      
      // Copy the shifted part
      for (int i = startingIndex; i < nums.length; i++) {
        returnedArr[counter++] = nums[i];
      }
 
      // Copy the rest of the array
      for (int i = 0; i < startingIndex; i++) {
        returnedArr[counter++] = nums[i];
      }
      
      // Copy returnedArr elements to nums array
      for (int i = 0; i < nums.length; i++) {
        nums[i] = returnedArr[i];
      }
    }
  }
}
