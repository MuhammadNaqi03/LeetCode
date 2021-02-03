class MaximumSubarraySolution {
  public int maxSubArray(int[] nums) {
    
    /* This problem is a classic problem that can be done with brute force but the time complexity will be pretty high.
    * A better approach could be using Kadane's Algorithm.
    * Main motivation behind it is to have a local max and a global max. 
    * Global max will be updated if local max becomes greater.
    * Formula: localMax = max(localMax + array[i], array[i])
    * Doing so, we can do continues integration and also compare if
    * there is any value which alone is greater than the added value (can happen if the previous value(s) are negative)
    * But first we have to check if the array is empty and 
    * will return value based on that (0 if not mentioned otherwise).
    * Then, to address arrays with all negative values, we will initialize local max as the first value of the array.
    * Can't use Integer.MIN_VALUE here because adding negative value with it could result in overflow.
    * Integer.MIN_VALUE = -2147483648
    * Integer.MIN_VALUE - 2 = 2147483646 
    * Becomes large positive integer because of the overflow.
    * For more details about the algorithm visit: 
    * https://medium.com/@rsinghal757/kadanes-algorithm-dynamic-programming-how-and-why-does-it-work-3fd8849ed73d
    */
      
      
    // We don't need to check for empty array here as given constraint is 1 <= nums.length <= 10^5.
    if (nums.length == 0) return 0;
    
    int localMax = nums[0];
    int globalMax = nums[0];
    
    for (int i = 1; i<nums.length; i++) {
      localMax = localMax + nums[i] > nums[i] ? localMax + nums[i] : nums[i];
      globalMax = localMax > globalMax ? localMax : globalMax;
    }
    
    return globalMax;
      
  }
}