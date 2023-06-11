class NextGreatLetterSolution {
  public char nextGreatestLetter(char[] letters, char target) {
    /**
     * Approach 1: Linear search
     * The array is sorted in ascending order.
     * Thus, we can perform a linear search and find the first character that is greater than the given target.
     * If there is no greater character in the array,
     * the last element of the array will be smaller or equal to the given target.
     * We can check that before doing the linear search.
     */

    // if (letters[letters.length - 1] <= target ) {
    //   return letters[0];
    // }

    // for (char currChar: letters) {
    //   if (currChar > target) {
    //     return currChar;
    //   }
    // }
    // return letters[0];






    /**
     * Approach 2: Binary Search
     * The array is sorted already, so we can perform a binary search as well.
     * But first, we can check if the last character in the array is less than or equal to the target
     * or if the first character is greater than the target.
     * In both cases, we can just return the first element of the array.
     * Then, just like in a typical binary search, we will have our left index at index 0,
     * our right index at the last index of the array, and the mid index at the midpoint of the left and right.
     * Our plan is to place the strictly greater character at the right index.
     * So, we will update the left index if the target is greater or equal to the mid index character
     * and move the left index to one index right to the mid index.
     * Otherwise, we will update the right index and give it the value of the mid index.
     * Thus, at the end of the loop, the right index can point to the strictly greater character that we are looking for.
     * The array can contain duplicates, so if we find the right and left become equal at any point,
     * that means the in-between characters (if there are any) are duplicates,
     * so we can just return the character pointed by the left or right index.
     */

    if (letters[0] > target || letters[letters.length - 1] <= target ) {
      return letters[0];
    }

    int left = 0;
    int right = letters.length - 1;

    while (left < right) {
      int mid = (left + right) / 2;
      if (letters[right] == letters[left]) {
        return letters[right];  
      }

      if (letters[mid] <= target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return letters[right];
  }
}
