class LongestSequenceSolution {
  public int longestConsecutive(int[] nums) {
    /**
     * Approach 1: Sorting (Accepted but the time complexity - O(nlogn), space complexity - O(1))
     * First, we have to check if the array is empty or not and return 0 if it's empty.
     * We will initialize a variable for counting the longest sequence with an initial value of 1.
     * (As the number itself is a sequence with a length of 1).
     * And also we will initialize a variable with value 1 for counting sequence within the loop.
     * Then, we will loop through the array (from the first index) and will find out if there is number-1 present for every number.
     * If that present, it means that it is a part of a sequence.
     * We will count the length of the sequence locally.
     * The numbers are not guaranteed to be unique, so in case we find the same number we will skip the local count.
     * But if it's not the above two cases, then we will reset the local count.
     * But before that, we will compare the local and global count and update the global if local is bigger.
     * Return the max between global and local count after the loop ends.
     */
 
//     if (nums.length == 0) {
//       return 0;
//     }
 
//     Arrays.sort(nums);
//     int longestSequence = 1;
//     int localLongest = 1;
 
//     for (int i = 1; i < nums.length; i++) {
//       if (nums[i] == nums[i - 1]) {
//         continue;
//       } else if (nums[i - 1] == nums[i] - 1) {
//         localLongest++;
//       } else { // Won't go inside this block if all the numbers are within sequence
//         longestSequence = longestSequence < localLongest ? localLongest : longestSequence;
//         localLongest = 1;
//       }
//     }
//     return Math.max(longestSequence, localLongest);
    
    
    
    
    
    /**
     * Approach 2: Using set ( time complexity - O(logn), space complexity - O(1))
     * Just like Approach 1, we have to check if the array is empty
     * as well as initialize a variable as 1 for counting longest consecutive subsequence.
     * Afterwards, we will put all the elements into a set.
     * Then, we will loop through the array and find out if the set has number-1 in it.
     * If it has that means, the number is not the start of a sequence, we will skip in this case.
     * Otherwise, we will search for the sequence starting from the number and count the length and save it to a variable.
     * Then, compare the local and global count; return the maximum one.
     * Time complexity : O(n) (which is the requirement),
     * Space complexity : O(n).
     */
 
    if (nums.length == 0) {
      return 0;
    }
 
    HashSet <Integer> set = new HashSet<>();
    int longestSequence = 1;
 
    for (int num: nums) {
      set.add(num);
    }
 
    for (int num: nums) {
      if (!set.contains(num - 1)) {
        int localLongest = 1;
        int nextNum = num + 1;
        while (set.contains(nextNum)) {
          localLongest++;
          nextNum++;
        }
        if (longestSequence < localLongest) {
          longestSequence = localLongest;
        }
      }
    }
    return longestSequence;
  }
}
