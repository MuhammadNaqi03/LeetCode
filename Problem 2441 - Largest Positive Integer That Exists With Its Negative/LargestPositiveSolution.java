class LargestPositiveSolution {
  public int findMaxK(int[] nums) {
    /**
     * Approach 1: HashMap
     * To solve this problem, we will use a hashmap and a variable (say, maxPositive)
     * to track the largest positive integer that exists with its negative.
     * For every number, we will check if the opposite sign of that number is present in the hashmap or not.
     * If the number with the opposite sign presents, then we will update the maxPositive.
     * Otherwise, we will put the number into the hashmap.
     */
  
    // HashMap <Integer, Integer> freqMap = new HashMap<>();
    // int maxPositive = -1;

    // for (int num: nums) {
    //   if (freqMap.containsKey(-num)) {
    //     maxPositive = Math.abs(num) > maxPositive
    //       ? Math.abs(num)
    //       : maxPositive; 
    //   } else {
    //     freqMap.put(num, 1);
    //   }
    // }

    // return maxPositive;





    /**
     * Approach 2: Frequency Array
     * Since the number range is very small (-1000 <= nums[i] <= 1000),
     * we can use a frequency array instead of a hashmap.
     * First, we need to create an array of size 1001.
     * If we find a positive number, we will update the corresponding index with 1,
     * and if we find a negative number, we will update the corresponding index with -1.
     * Thus, we can check for every positive or negative number if the corresponding index
     * is already occupied with the opposite sign of that number.
     * We will update the maxPositive number in this way.
     */

    int [] freqArr = new int [1001];
    int maxPositive = -1;

    for (int num: nums) {
      if (num > 0) {
        if (freqArr[num] == -1) { // Negative number already exists
          maxPositive = num > maxPositive
            ? num
            : maxPositive; 
        } else {
          freqArr[num] = 1;
        }
      } else {
        int absoluteNum = Math.abs(num);
        if (freqArr[absoluteNum] == 1) { // Positive number already exists
          maxPositive = absoluteNum > maxPositive
            ? absoluteNum
            : maxPositive; 
        } else {
          freqArr[absoluteNum] = -1;
        }
      }
    }

    return maxPositive;
  }
}
