class PivotPartitionSolution {
  public int[] pivotArray(int[] nums, int pivot) {
    /**
     * Approach:
     * We will save the greater and lesser values within two arraylists and count how many numbers are equal to pivot.
     * Then put the lesser numbers first, the pivot(s) afterwards, and lastly the greater numbers as asked.
     */

    int pivotCount = 0;
    ArrayList <Integer> greaterNumbers = new ArrayList<>();
    ArrayList <Integer> lesserNumbers = new ArrayList<>();

    for (int num: nums) {
      if (num == pivot) {
        pivotCount += 1;
      } else if (num > pivot) {
        greaterNumbers.add(num);
      } else {
        lesserNumbers.add(num);
      }
    }

    int partitionedArr [] = new int [nums.length];
    int index = 0;

    while (index < lesserNumbers.size()) {
      partitionedArr[index] = lesserNumbers.get(index++);
    }

    while(pivotCount > 0) {
      partitionedArr[index++] = pivot;
      pivotCount--;
    }

    for (int i = 0; i < greaterNumbers.size(); i++) {
      partitionedArr[index++] = greaterNumbers.get(i);
    }

    return partitionedArr;  
  }
}
