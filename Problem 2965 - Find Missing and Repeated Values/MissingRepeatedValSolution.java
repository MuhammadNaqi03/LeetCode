class MissingRepeatedValSolution {
  public int[] findMissingAndRepeatedValues(int[][] grid) {
    /**
     * Approach:
     * First, we need to find the sum of the unique values of 1 to n^2 (where n
     * is the size of the n*n array). Then we need to maintain a hash set from
     * which we will find the duplicate number, and we will also get the sum of
     * the numbers in the array during the iteration. Afterward, from the
     * duplicate number, we will subtract the difference between the sum of
     * numbers of the array and the unique number sums, which will give us the
     * missing number.
     */

    int maxPossibleNum = grid.length * grid.length;
    int uniqueNumSum = (maxPossibleNum * (maxPossibleNum + 1)) / 2; // n(n+1)/2

    HashSet<Integer> frequencySet = new HashSet<>();
    int[] returnValues = new int[2];
    int obtainedSum = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        if (returnValues[0] == 0) {
          if (frequencySet.contains(grid[i][j])) {
            returnValues[0] = grid[i][j];
          } else {
            frequencySet.add(grid[i][j]);
          }
        }

        obtainedSum += grid[i][j];
      }
    }

    returnValues[1] = returnValues[0] - (obtainedSum - uniqueNumSum);
    return returnValues;
  }
}
