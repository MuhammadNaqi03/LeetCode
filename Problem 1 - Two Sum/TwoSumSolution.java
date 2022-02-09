class TwoSumSolution {
  public int[] twoSum(int[] nums, int target) {
    /** Approach 1: HashMap 2 Pass
    * The idea is to first put all the elements into a hashmap.
    * The element will be stored as key and the index will be value of the map.
    * It is done so that, we can get the index by using the get() method of hashmap.
    * Then loop again to find out if map contains target-nums[i].
    * If so then return the map value and current index.
    */
    
//       HashMap <Integer, Integer> map = new HashMap<>();
//       for (int i = 0; i < nums.length; i++) {
//         map.put(nums[i], i);
//       }
    
//       for (int i = 0; i < nums.length; i++) {
//         int complement = target - nums[i];
//         // i!= map.get(target-nums[i] is needed to check the same index pulling
//         if (map.containsKey(complement) && i != map.get(complement)) {
//           return new int [] {i, map.get(complement)};
//         }
//       }
//       return null; // Ask what the return value should be in case no match is found
    
    
    
    
    
    /** Approach 2: HashMap 1 Pass
    * This implementation also requires hashmap where we can solve the problem with one for loop.
    * The key, value storing will be the same as previous one.
    * But we will check for complement before storing.
    * If we don't find a complement we will store the data.
    * Otherwise, we will return the index and the index of the complement.
    * We need to put the index of the complement first, as it's appeared before.
    * We also don't need to check i!= map.get(target-nums[i]. 
    * As we are doing one pass thus same index lookup won't happen.
    */
    
    HashMap <Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int [] {map.get(complement), i};
      }
      map.put(nums[i], i);
    }
    return null; // Ask what the return value should be in case no match is found
    
  } 
}