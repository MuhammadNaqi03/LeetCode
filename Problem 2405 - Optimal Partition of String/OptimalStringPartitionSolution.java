class OptimalStringPartitionSolution {
  public int partitionString(String s) {
    /**
     * Approach: Two Pointers
     * At first, the first pointer will point to the first character,
     * and the second pointer will point to the next one.
     * We will check if the substring between the two pointers has the next character or not.
     * If it doesn't have the next character, we will simply increase the substring (increment the second pointer).
     * Otherwise, we will update the first pointer to the second pointer,
     * and the second pointer will point to the next character.
     */

    int numOfSubString = 1; // The count starts at 1, as the loop will terminate at the last substring
    int firstPointer = 0;
    int secondPointer = 1;

    while (secondPointer < s.length()) {
      if (s.substring(firstPointer, secondPointer).contains(s.substring(secondPointer, secondPointer + 1))) {
        firstPointer = secondPointer;
        numOfSubString += 1;
      }
      secondPointer += 1;
    }

    return numOfSubString;
  }
}
