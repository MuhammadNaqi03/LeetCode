class TwoSum2Solution {
  public int[] twoSum(int[] numbers, int target) {
    HashMap <Integer,Integer> map = new HashMap<>();
    for (int i=0; i<numbers.length; i++){
      map.put(numbers[i],i);
    }
    for (int i=0; i<numbers.length; i++){
      int complement = target - numbers[i];
      // We cannot use same element twice so: map.get(complement) != i
      if (map.containsKey(complement) && map.get(complement) != i) {
        return new int [] {i+1, map.get(complement)+1}; // Index starts at 1
      }
    }
    // In case solution is not found
    return null;
  }
}