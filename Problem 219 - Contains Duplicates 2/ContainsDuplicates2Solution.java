class ContainsDuplicates2Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    /* 
    * Create a hashmap where we will put
    * the array element as the key and the index as the value
    * Check if the map already has the key (Store if not)
    * If so then check if the current index and stored index difference is <= k
    * If no then update the stored index value
    * Else return true
    * We don't need to check for empty array and k's validity as:
    * -10^9 <= nums[i] <= 10^9; 0 <= k <= 105
    */
    HashMap <Integer,Integer> map = new HashMap <>();
    for (int i = 0; i<nums.length; i++) {
      if (map.containsKey(nums[i])) {
        // Compare the difference
        if (i - map.get(nums[i]) <= k ) return true;
      }
      // Add or update the index
      map.put(nums[i], i);
    }
    return false;
  }
}