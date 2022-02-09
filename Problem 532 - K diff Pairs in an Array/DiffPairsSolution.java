class DiffPairsSolution {
  public int findPairs(int[] nums, int k) {
    /**
    * This problem has similarity with the 'Two Sum' problem.
    * But the case here is that, we have to remove the duplicates.
    * For doing so, We will add the numbers as keys and their appearance as values.
    * Then we will traverse through keys using keySet() method.
    * We used complement for 'Two Sum' solution (as it was two sum)
    * And will use summation for this problem (as it is diff pair)
    */
      
      
    // For constraints: 1 <= nums.length <= 104
    // and 0 <= k <= 107, we don't need the following checking though
    if (nums.length == 0 || k < 0) return 0;
      
    HashMap<Integer, Integer> map = new HashMap<>();
    int diffPairs = 0;
    for (int num: nums) {
      map.put( num, map.getOrDefault(num, 0) + 1); // Counting the appearance
    }
      
    for (int num: map.keySet()) {
      int sum = num + k;
      // We need to use this : (k == 0 && map.get(num) > 1) for k = 0 along with
      // cases like [1, 1, 1, 3, 3] and so. Because if the difference is 0 then 
      // there has to be repeated number(s) which will form pair(s) like (1, 1), (3,3)
      // So we are searching if the occurance of the number(s) is more than 1 when 
      // we get k as 0. Don't need to use that if k is always more than 0.
      if ((k > 0 && map.containsKey(sum)) || (k == 0 && map.get(num) > 1)) diffPairs++;
    }
      
    return diffPairs;
  }
}