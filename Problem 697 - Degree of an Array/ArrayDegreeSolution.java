class ArrayDegreeSolution {
  public int findShortestSubArray(int[] nums) {
    /**
     * Approach: 
     * The main goal here is to find out a number that appears more
     * and have minimal distance between first and last appearance
     * if there are more numbers with the same number of appearances.
     * To do so, we need to create two maps to store numbers' frequency 
     * and the first appearance of the numbers.
     * Afterwards, we will run a loop from the start index to the end index of the array.
     * Inside the loop, we will check if the number appears before.
     * If it hasn't appeared before, we will put the index of first occurrence of that number.
     * Then, we will put/update the appearance count on the other map.
     * After that, we will get the appearance count of the given number.
     * If the appearance is more than the max appearance so far 
     * or, the appearance & max appearance are equal along with the current distance being minimal,
     * we will update the absolute distance.
     * After the loop ends, we will return the value of the distance,
     * which will be the length of the subarray.
     */
    HashMap<Integer, Integer> frequencyMap = new HashMap<>();
    HashMap<Integer, Integer> firstAppearance = new HashMap<>();
    int maxAppearance = 1;
    int distance = 1;
 
    for (int i = 0; i < nums.length; i++) {
      // Check if the number is available in firstAppearance map
      if (!frequencyMap.containsKey(nums[i])) {
        firstAppearance.put(nums[i], i);
      }
      
      int currentNumberAppearance = frequencyMap.getOrDefault(nums[i], 0) + 1;
      frequencyMap.put(nums[i], currentNumberAppearance);
      int currentNumberDistance = i - firstAppearance.get(nums[i]) + 1;
      
      if ((currentNumberAppearance > maxAppearance) || 
          (currentNumberAppearance == maxAppearance & currentNumberDistance < distance)) {
        maxAppearance = currentNumberAppearance;
        distance = currentNumberDistance;
      }
    }
    return distance; 
  }
}

