class DisappearedNumbersSolution {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    /**
     * Approach 1: Using extra space
     * First, we have to put all the numbers in an arraylist/hashset.
     * Then from 1 to n, we will check if the number is present there or not.
     * Those numbers which are not present will be added to an arraylist and be returned.
     * Time complexity: O(n), Space complexity: O(n).
     * Time limit exceeds.
     */
    
//     ArrayList<Integer> numberList = new ArrayList<>();
//     for (int num: nums) {
//       numberList.add(num);
//     }

//     ArrayList<Integer> missingNumberList = new ArrayList<>();
//     for (int i = 1; i <= nums.length; i++) {
//       if (!numberList.contains(i)) {
//         missingNumberList.add(i);
//       }
//     }

//     return missingNumberList;
    
    
    
    
    

    /**
     * Approach 2: Negating values in corresponding index 
     * We will traverse the array and for every number we will negate the value
     * of the number in corresponding index - 1. (As, the number starts from 1 to n)
     * Afterwards, we will traverse again to find which indices have non negative values.
     * Those indices + 1, will be the numbers that we are looking for.
     * Time complexity: O(n), Space complexity: O(1)
     */
    


    for (int i = 0; i < nums.length; i++) {
      int absoluteNumber = Math.abs(nums[i]); // In case the corresponding value is already negative
      if (nums[absoluteNumber - 1] > 0) { // Check if the index is already marked or not
        nums[absoluteNumber - 1] = - nums[absoluteNumber - 1];
      }
    }

    ArrayList<Integer> missingNumberList = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        missingNumberList.add(i + 1);
      }
    }

    return missingNumberList;  
  }
}