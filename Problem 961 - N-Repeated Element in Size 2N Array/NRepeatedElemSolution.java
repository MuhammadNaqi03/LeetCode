class Solution {
  public int repeatedNTimes(int[] nums) {
    
    /**
     * Approach 1: Sorting the array
     * Sort the array first and then traverse the array.
     * If we find adjacent values that are the same, that is the value that we are looking for.
     * We don't need to check for empty array and array length of 1 as per constraints:
     * 2 <= n <= 5000
     * 0 <= nums[i] <= 104
     */
    
    Arrays.sort(nums);
    int dupValue = 0;  // 2 <= n <= 5000
    
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i-1]) {
        dupValue = nums[i];
      }
    }
    return dupValue;
    
    /**
     * Approach 2: Using arraylist/hashset
     * We will need an arraylist or hashset (I am going to use arraylist here)
     * Then, we will traverse the array and insert the elements into arraylist.
     * Before insertion we will check if the value is already present there.
     * If we find the value, we will just return the value.
     */
    
//     ArrayList <Integer> dupFinder = new ArrayList<>();
//     int dupValue = 0;
    
//     for (int num: nums) {
//       if (dupFinder.contains(num)) {
//         dupValue = num;
//       }
//       dupFinder.add(num);
//     }
//     return dupValue;
  }
}
