class PivotPartitionSolution {
  public int[] pivotArray(int[] nums, int pivot) {
    /**
     * Approach:
     * We will save the greater and lesser values within two arraylists and count how many numbers are equal to pivot.
     * Then put the lesser numbers first, the pivot(s) afterwards, and lastly the greater numbers as asked.
     */

    // int pivotCount = 0;
    // ArrayList <Integer> greaterNumbers = new ArrayList<>();
    // ArrayList <Integer> lesserNumbers = new ArrayList<>();

    // for (int num: nums) {
    //   if (num == pivot) {
    //     pivotCount += 1;
    //   } else if (num > pivot) {
    //     greaterNumbers.add(num);
    //   } else {
    //     lesserNumbers.add(num);
    //   }
    // }

    // int partitionedArr [] = new int [nums.length];
    // int index = 0;

    // while (index < lesserNumbers.size()) {
    //   partitionedArr[index] = lesserNumbers.get(index++);
    // }

    // while(pivotCount > 0) {
    //   partitionedArr[index++] = pivot;
    //   pivotCount--;
    // }

    // for (int i = 0; i < greaterNumbers.size(); i++) {
    //   partitionedArr[index++] = greaterNumbers.get(i);
    // }

    // return partitionedArr;




    /**
     * Instead of storing the numbers into different lists,
     * we can count the lesser and pivot numbers and use them as indices.
     * For example, the lesser numbers will start at 0.
     * The pivot number will start from where the lesser numbers end,
     * and the greater numbers will start from where the pivot numbers end.
     */
    
    int lesserNumberCount = 0;
    int pivotNumberCount = 0;

    for (int num: nums) {
      if (num < pivot) {
        lesserNumberCount += 1;
      } else if (num == pivot) {
        pivotNumberCount += 1;
      }
    }

    int lesserNumberIndex = 0;
    int pivotNumberIndex = lesserNumberCount;
    int greaterNumberIndex = lesserNumberCount + pivotNumberCount;
    int partitionedArr [] = new int [nums.length];

    for (int num: nums) {
      if (num < pivot) {
        partitionedArr[lesserNumberIndex++] = num;
      } else if (num == pivot) {
        partitionedArr[pivotNumberIndex++] = num;
      } else {
        partitionedArr[greaterNumberIndex++] = num;
      }
    }

    return partitionedArr; 
  }
}
