class SmallerNumberCountSolution {
  public int[] smallerNumbersThanCurrent(int[] nums) {
    /**
     * Approach 1: Sort (Time Complexity: O(nlogn))
     * Firstly, we need to copy the array and sort the copied array.
     * Afterwards, we will use a hashmap whose key will be the number in the sorted array,
     * and value will be number of numbers that are smaller than the current number.
     * To count the number(s) that are smaller than a given number,
     * we will have a counter which value will be added to the map
     * when unique number in sorted array is found.
     * Lastly, we will create an array which will contain the number(s) that are
     * smaller than the number in a given index of the nums array fetched from the map.
     */
 
    // int [] copiedArr = Arrays.copyOf(nums, nums.length);
    // Arrays.sort(copiedArr);
    // HashMap <Integer, Integer> map = new HashMap<>();
    // int smallerCounter = 0;

    // for (int i = 0; i < copiedArr.length; i++) {
    //   // Check if the number is a duplicate or not. If not, then add that to the map.
    //   if (!map.containsKey(copiedArr[i])) {
    //     map.put(copiedArr[i], smallerCounter);
    //   }
    //   smallerCounter++;
    // }

    // int [] answerArr = new int [nums.length];
    // for (int i = 0; i < answerArr.length; i++) {
    //   int smallerNumberCount = map.get(nums[i]);
    //   answerArr[i] = smallerNumberCount;
    // }
  
    // return answerArr;





    /**
     * Approach 2: Array index as counter (Time Complexity: O(n))
     * We can use this approach easily, as there is no negative number and the number range is small.
     * (Constraint: 0 <= nums[i] <= 100)
     * We will need three arrays for this approach.
     * The first array is for counting frequency.
     * The second array is for counting how many numbers are smaller than the current number.
     * For that, we will use a counter. Whenever any number's presence is found, 
     * we will put the counter's value inside the corresponding index.
     * And, the counter will increment with the number of appearance that the given number has.
     * Then, the third array will just pick up the number's position in ascending order from the second array.
     */
 
    int [] freqArr = new int [101];  // As per constraint: 0 <= nums[i] <= 100
    for (int num: nums) {
      freqArr[num]++;
    }
 
    int smallCounter = 0;
    int [] smallerCounterArr = new int [101];
    for (int i = 0; i < smallerCounterArr.length; i++) {
      if (freqArr[i] > 0) {
        smallerCounterArr[i] = smallCounter;
        smallCounter = smallCounter + freqArr[i];
      }
    }
 
    int [] answerArr = new int [nums.length];
    for (int i = 0; i < answerArr.length; i++) {
      answerArr[i] = smallerCounterArr[nums[i]];
    }
 
    return answerArr;
  }
}
