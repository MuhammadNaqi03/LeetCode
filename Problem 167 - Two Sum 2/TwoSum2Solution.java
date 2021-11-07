class TwoSum2Solution {
  public int[] twoSum(int[] numbers, int target) {
    // Approach 1: Just like two sum solution (Problem 1)
    // HashMap <Integer,Integer> map = new HashMap<>();
    // for (int i=0; i<numbers.length; i++){
    //     map.put(numbers[i],i);
    // }
    // for (int i=0; i<numbers.length; i++){
    //     int complement = target - numbers[i];
    //     // We cannot use same element twice so: map.get(complement) != i
    //     if (map.containsKey(complement) && map.get(complement) != i) {
    //         return new int [] {i+1, map.get(complement)+1}; // Index starts at 1
    //     }
    // }
    // // For the "no return statement" error it shows
    // return null;
      
    // Approach 2: As the number is sorted we can use solution with pointer
    int left = 0;
    int right = numbers.length - 1;
    // Adjust the distance between the two pointers if they are not equal to target
    while (numbers[left] + numbers[right] != target) {
      if (numbers[left] + numbers[right] > target) right--;
      else left ++; 
    }
    return new int [] { left+1, right+1 }; // Index starts at 1 and we have at least one solution
  }
}