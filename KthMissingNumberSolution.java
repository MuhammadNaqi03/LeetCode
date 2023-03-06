class KthMissingNumberSolution {
  public int findKthPositive(int[] arr, int k) {
    /**
     * Approach:
     * The given array is 'strictly' increasing, which means we don't need to worry about duplicate values.
     * The number sequence will be from 1 to the highest number in the array
     * if the number of missing numbers (say, missingNumCount) is within the range of k.
     * Otherwise, the number sequence will continue until the highest number + the remaining number of missing numbers.
     * So, we'll start a loop from 1 until the highest number in the array.
     * If we find that the sequence doesn't contain a number from our count,
     * we'll increment the missingNumCount and return the current number in the sequence
     * if k and the missing number count become equal.
     * Otherwise, we'll increment the current pointer pointing at the index of the given array.
     * If we come out of the loop, it means that the value of k is higher than the missingNumCount.
     * So, we'll return the highest number + k - missingNumCount.
     */
    
    int currNum = 1;
    int highestNumInArr = arr[arr.length - 1 ];
    int currIndex = 0;
    int missingNumCount = 0;

    while (currNum <= highestNumInArr) {
      if (currNum != arr[currIndex]) {
        missingNumCount += 1;
        if (missingNumCount == k) {
          return currNum;
        }
      } else {
        currIndex += 1;
      }
      currNum += 1;
    }

    return highestNumInArr + k - missingNumCount;
  }
}
