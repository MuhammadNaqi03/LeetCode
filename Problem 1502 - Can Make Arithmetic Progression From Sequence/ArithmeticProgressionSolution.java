class ArithmeticProgressionSolution {
  public boolean canMakeArithmeticProgression(int[] arr) {
    /**
     * Approach 1: Sorting
     * The approach is very easy; all we have to do is sort the array
     * and find the difference between two successive numbers.
     * If the numeric distance between the numbers is be the same,
     * then the numbers can make arithmetic progression.
     */

    // Arrays.sort(arr);
    // int diff = arr[0] - arr[1];
    // for (int i = 1; i < arr.length - 1; i++) {
    //   if (arr[i] - arr[i + 1] != diff) {
    //     return false;
    //   }
    // }
    // return true;






    /**
     * Approach: Using formula
     * We need to find out if any number has duplicates.
     * The arithmetic progression is not possible if the series has duplicates,
     * unless all the numbers in the series are the same.
     * We also need to use a formula for this approach: min - max / length - 1
     * If we subtract the minimum from the maximum and divide that by the number of elements minus 1
     * (as we are finding the difference between two numbers),
     * then we can find the common difference between the numbers for arithmetic progression.
     * If the result doesn't give a whole number,
     * we can say that the sequence cannot make an arithmetic progression. 
     * We need to check if each of the two elements' numerical difference is the value obtained
     * by the formula or if it's a multiple of that value.
     * If that's false for any two numbers, we can say that the sequence will not
     * form an arithmetic progression; otherwise, it will.
     */

    int min = arr[0];
    int max = arr[0];
    ArrayList<Integer> dupChecker = new ArrayList<>();
    boolean containsDuplicate = false;
    for (int num: arr) {
      if (num < min) {
        min = num;
      } else if (num > max) {
        max = num;        
      }

      if (!containsDuplicate) {
        if (dupChecker.contains(num)) {
          containsDuplicate = true;
        } else {
          dupChecker.add(num);
        }
      }
    }

    // All the numbers are the same
    if (min == max) {
      return true;
    }

    if (containsDuplicate) {
      return false;
    }

    if ((max - min) % (arr.length - 1) != 0) {
      return false;
    }

    int diff = (max - min) / (arr.length - 1);
    for (int i = 0; i < arr.length - 1; i++) {
      int currDiff = arr[i] - arr[i + 1];
      if (currDiff == 0 || currDiff % diff != 0) {
        return false;
      }
    }
    return true;
  }
}
