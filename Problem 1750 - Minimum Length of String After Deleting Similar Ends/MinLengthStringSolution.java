class MinLengthStringSolution {
  public int minimumLength(String s) {
    /**
     * Approach: Two Pointers
     * We will be using two pointers to solve this problem,
     * where one pointer will point to the beginning of the array and the other one to the end.
     * But first, we will return 1 if the string length is equal to 1, as there is nothing to remove.
     * Then, until the first pointer becomes less than the second one,
     * we will check if the first and last pointers point to the same character.
     * If not, we can safely break the loop, as there's nothing to be removed.
     * If the pointers point to the same character,
     * then we will update both the first and second pointers until they become equal.
     *
     * Afterwards, we have to handle three cases:
     * First, the first pointer becomes greater than the second pointer.
     * This means the pointer gets updated because all the characters could be removed.
     * Second, both pointers values are the same. This means that the character that they are pointing to
     * can either be removed orthe only character left after removing all characters.
     * To check that, we need to check the current character with the first pointer's next character or
     * the second pointer's previous character (the string with length 1 is handled,
     * so the checking won't give the invalid index error).
     * And lastly, in other cases, we just need to calculate the distance between the first and second pointers.
     */

    if (s.length() == 1) {
      return 1;
    }

    char[] charArray = s.toCharArray();
    int firstPointer = 0;
    int secondPointer = s.length() - 1;

    while (firstPointer < secondPointer) {
      if (charArray[firstPointer] != charArray[secondPointer]) {
        break;
      }

      char currChar = charArray[firstPointer];
      while ((charArray[firstPointer] == currChar ||
              charArray[secondPointer] == currChar) &&
             firstPointer <= secondPointer) {
        if (charArray[firstPointer] == currChar) {
          firstPointer++;
        }
        if (charArray[secondPointer] == currChar) {
          secondPointer--;
        }
      }
    }

    if (firstPointer > secondPointer) {
      return 0;
    } else if (firstPointer == secondPointer) {
      return charArray[firstPointer] == charArray[firstPointer + 1] ? 0 : 1;
    } else {
      return secondPointer - firstPointer + 1;
    }
  }
}
