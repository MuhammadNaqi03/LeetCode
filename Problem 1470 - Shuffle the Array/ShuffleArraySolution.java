class ShuffleArraySolution {
  public int[] shuffle(int[] nums, int n) {
    /**
     * Approach 1: Out of place
     * We will create an array (say, returnedArr) same size as nums array.
     * We will store the value of n in a variable (say, yIndex)
     * and will have a counter to track returnedArr's index.
     * Then we will run a loop from 0 until n and insert the nums element at the ith index of the loop
     * and afterwards the nums element at yIndex in the returnedArr.
     * Also increment yIndex and counter.
     * End of the loop? Return returnedArr.
     * We don't need to check for empty array and negative n as per the constraints:
     * nums.length == 2n 
     * 1 <= n <= 500
     */
    
    int [] returnedArr = new int [nums.length];
    int yIndex = n;
    int counter = 0;
    for (int i = 0; i < n; i++) {
      returnedArr[counter++] = nums[i];
      returnedArr[counter++] = nums[yIndex++];
    }
    return returnedArr;
    
    
    
    
    
    /**
     * Approach 2: In place (Using right shift)
     * Firstly, we have to declare variables for tracking yth index(say, yIndex; which is n primarily), 
     * number of shits (say, nShift, which is y - 1 primarily), 
     * and the index where current y's element should be (say placeForY which is primarily 1).
     * We will loop until n becomes 1.
     * Inside the loop, we will save the value at yIndex in a variable (say, yValue),
     * right shift the values from placeForY to yIndex,
     * and update the value of placeForY with yValue.
     * Also, decrement the values of n, nShift by 1
     * and increment yIndex by 1 and placeForY by 2.
     * After the loop ends, return the array.
     * Example for better understanding:
     * Given array: [1,9,3,5,7,8] and target: [1,5,9,7,3,8]
     * Before first iteration: arr = [1,9,3,5,7,8], n = 3, yIndex = 3, placeForY = 1, nShift = 2
     * After first iteration: arr = [1,5,9,3,7,8] , n = 2, yIndex = 4, placeForY = 3, nShift = 1, yValue = 5
     * Before second iteration: arr = [1,5,9,7,3,8], n = 1, yIndex = 5, placeForY = 5, nShift = 0,  yValue = 7
     * nums = [1,5,9,7,3,8]
     */
    
//     int yIndex = n;
//     int nShift = yIndex - 1;
//     int placeForY = 1;
    
//     while (n != 1) {
//       int yValue = nums[yIndex];
      
//       // Variables for shifting
//       int from = yIndex - 1;
//       int to = yIndex;
//       int numberOfShift = nShift;
//       while (numberOfShift != 0) {
//         nums[to] = nums[from];
//         from--;
//         to--;
//         numberOfShift--;
//       }
//       nums[placeForY] = yValue;
//       placeForY +=2;
//       yIndex++;
//       nShift--;
//       n--;
//     }
//     return nums;
  }
}