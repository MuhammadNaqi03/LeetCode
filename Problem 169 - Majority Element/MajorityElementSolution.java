class MajorityElementSolution {
  public int majorityElement(int[] nums) {
    /** Approach 1: Using HashMap
    * Pretty simple approach: 
    * 1. First we will save the numbers and occurances as key-value pairs.
    * 2. Then will loop through the keyset and will get the associated values
    * and compare them to find the maximum occurance.
    */
    
    HashMap <Integer, Integer> numMap = new HashMap<>();
    int maxTimes = 0;
    int elem = 0;
    for (int num: nums) {
      numMap.put(num, numMap.getOrDefault(num, 0) + 1);
    }

    for (int key: numMap.keySet()) {
      if (maxTimes < numMap.get(key)) {
      maxTimes = numMap.get(key);
      elem = key;
      }
    }

    return elem;
  }
}