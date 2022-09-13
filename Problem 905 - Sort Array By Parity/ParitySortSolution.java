class ParitySortSolution {
  public int[] sortArrayByParity(int[] nums) {
    /**
     * Approach 1: By creating a new array
     * First, we will create an array with the same length as the given array.
     * Then, we will traverse through the given array and find out the numbers which
     * are even numbers and put them at the beginning of the new array.
     * We have to mark until which index the even numbers are occupied.
     * Then for the rest of the array, we will occupy the array with the remaining odd numbers.
     * We don't need to check for empty array as per constraint: 
     * 1 <= nums.length <= 5000
     * And also negative numbers as per constraint:
     * 0 <= nums[i] <= 5000
     */
    
//     int [] arrToReturn = new int [nums.length];
//     int indexTracker = 0;

//     // Fill up the first portion with even numbers
//     for (int num: nums) {
//       if (num % 2 == 0) {
//         arrToReturn[indexTracker++] = num;
//       }
//     }

//     // Fill up the rest of the array with odd numbers
//     for (int num: nums) {
//       if (num % 2 != 0) {
//         arrToReturn[indexTracker++] = num;
//       }
//     }
//     return arrToReturn;
    
    
    
    
    
    
    /**
     * Approach 2: Two pointers (Out of place)
     * We can optimize the previous solution and use two pointers which will point first and last indices.
     * If we find even number, we will put that in the first pointer's place and update the pointer;
     * if we find odd number, we will put that in second pointer's place and update the pointer.
     */
    
//     int [] arrToReturn = new int [nums.length];
//     int evenPointer = 0;
//     int oddPointer = nums.length - 1;

//     for (int num: nums) {
//       if (num % 2 == 0) {
//         arrToReturn[evenPointer++] = num;
//       } else {
//         arrToReturn[oddPointer--] = num;
//       }
//     }
//     return arrToReturn;
    
    
    
    
    
    
    /**
     * Approach 3: Two pointers (In place)
     * We will use two pointers to point the last and first index as previous approach.
     * We will check if the pointers are pointing to what they should
     * (even pointer points to even number and odd pointer points to odd number).
     * If both pointers point to the number they should not, then we will swap the numbers.
     * Other than that we will update the pointers to see if the next numbers are in respective positions or not.
     * Until they both point to the same index we will run the loop then return the array.
     */
    
    int evenPointer = 0;
    int oddPointer = nums.length - 1;

    while (evenPointer < oddPointer) {
      // If both of them point to what they shouldn't, then swap the numbers
      if ((nums[evenPointer] % 2 != 0) && (nums[oddPointer] % 2 == 0)) {
        nums[evenPointer] = nums[evenPointer] ^ nums[oddPointer];
        nums[oddPointer] = nums[evenPointer] ^ nums[oddPointer];
        nums[evenPointer] = nums[evenPointer] ^ nums[oddPointer];
        evenPointer++;
        oddPointer--;
      } else if (nums[evenPointer] % 2 != 0) {
        // If both pointers point to odd numbers, then update the oddPointer
        oddPointer--;
      } else if (nums[oddPointer] % 2 == 0) {
        // If both pointers point to even numbers, then update the evenPointer
        evenPointer++;
      } else {
        // If both of them point to what they should, then update both the pointers
        evenPointer++;
        oddPointer--;
      }
    }
    return nums;
  }
}