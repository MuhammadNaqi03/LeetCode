class SingleNumberSolution {
  public int singleNumber(int[] nums) {
    /** Approach 1: Using XOR
    * Easier solution could be found using XOR
    * We Know that in logic, XOR gives 0 for being the same and 1 otherwise.
    * In this sense if we do XOR, then the same numbers will become 0 together leaving
    * the unique number.
    * Example: 4 ^ 1 ^ 2 ^ 1 ^ 2
    * 4 ^ (1 ^ 1) ^ (2 ^ 2)
    * 4 ^ 0 ^ 0
    * 4
    * XOR solution applies because the duplicate number appears exactly twice
    * Or if they appear even number it will work as well.
    * But for arbitrary number, this solution will fail to produce result.
    * Again the problem states the array will be non-empty, thus we don't need to
    * put condition for it.
    */
      
    int unique = 0;
    for (int num : nums){
      unique ^= num;
    }
      
    return unique;
    
    
    
    
    /** Approach 2: If using extra space is permitted (Using set)
    * First we have to create a set where we will insert number if it's not previously found
    * As the number will appear exactly twice except one number, we will remove number if 
    * the number is already in the set. Then, will just return the only remaining number
    */
    
//       Set <Integer> set = new HashSet<>();
    
//       for (int num: nums) {
//         if (set.contains(num)) {
//           set.remove(num);
//         } else {
//           set.add(num);
//         }
//       }
    
//       // We have to use wrapper class inside toArray() to get the type of the array.
//       // Here toArray(new Integer[0]) returns an array of Integer type
//       Integer [] arr = set.toArray(new Integer[0]); 
//       return arr[0];
  }
}