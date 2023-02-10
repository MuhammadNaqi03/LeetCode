class NextGreater1Solution {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    /**
     * Approach: 
     * For this problem, we'll use monotonic stack (mono-decreasing stack)
     * to find out the next greater number for every number in nums2.
     * If the next greater number is found for a number,
     * we'll store the number as a key and its next greater number as a value in a hashmap.
     * Afterwards, for every number in nums1, we'll check if the number is stored in the hashmap.
     * If we find the number is stored in the hashmap, we'll update the corresponding index of the returned array 
     * with the next greater number in the hashmap for the corresponding number.
     * Otherwise, we'll update the corresponding index with -1.
     */

    HashMap <Integer, Integer> nextGreaterMap = new HashMap<>();
    Stack <Integer> monoStack = new Stack<>();
    for (int num: nums2) {
      while (!monoStack.isEmpty() && monoStack.peek() < num) {
        nextGreaterMap.put(monoStack.pop(), num); 
      }
      monoStack.push(num);
    }

    int [] nextGreaterArr = new int [nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      nextGreaterArr[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
    }

    return nextGreaterArr;
  }
}
