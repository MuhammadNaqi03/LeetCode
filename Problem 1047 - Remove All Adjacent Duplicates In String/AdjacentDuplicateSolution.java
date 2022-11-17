class AdjacentDuplicateSolution {
  public String removeDuplicates(String s) {
    /**
     * Approach 1: Two pointers
     * At first, we have to check if the string has one or no character.
     * At that scenario, we will just return the string.
     * Else, we will use two pointers to point out adjacent characters (say, firsPointer and secondPointer).
     * We will have a variable to track down the current length (say, currLength)
     * of the string after duplicate removal.
     * We will use StringBuilder class for its flexibility.
     * As long as the second pointer becomes less than currLength we will run a loop.
     * At each loop we will check if the pointers point to the same character.
     * If they don't, we will just increment both the pointers to point to the next set of characters.
     * But if both point to the same character, we will remove the characters and decrement the currLength by 2.
     * We also need to check if the firsPointer pointed to the 0th index or not.
     * If it doesn't point to the oth index, then we will decrement both the pointers,
     * as the in between duplicates are removed.
     * But if the firsPointer does point to 0th index, we need to do nothing
     * as they will point to appropriate characters after duplicate removal.
     * After the loop ends just return the StringBuilder object converting to a string.
     */

    // if (s.length() == 1) {
    //   return s;
    // }

    // StringBuilder sb = new StringBuilder(s);
    // int firstPointer = 0;
    // int secondPointer = 1;
    // int currLength = s.length();

    // while (secondPointer < currLength) {
    //   if (sb.charAt(firstPointer) == sb.charAt(secondPointer)) {
    //     sb.delete(firstPointer, secondPointer + 1);
    //     currLength = currLength - 2;
    //     if (firstPointer != 0) {
    //       firstPointer--;
    //       secondPointer--;
    //     }
    //   } else {
    //     firstPointer++;
    //     secondPointer++;
    //   }
    // }
    // return sb.toString();





    /**
     * Approach 2: Using Stack
     * As the name suggests, we need to have a stack first.
     * Then for every character we will check - 
     * if the stack is empty or
     * the top character of the stack doesn't match the current character of the string.
     * If so, we can push the current character to the stack.
     * Otherwise, it means we have duplicate adjacent characters and 
     * need to remove the character from the stack.
     * After checking every character of the string, 
     * then we convert the stored character(s) in the stack to a string and return that string.
     */
    
    Stack <Character> charStack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (charStack.isEmpty() || charStack.peek() != s.charAt(i)) {
        charStack.push(s.charAt(i));
      } else {
        charStack.pop();
      }
    }

    // Build string from the characters stored in the stack
    StringBuilder sb = new StringBuilder(charStack.size());
    while (!charStack.isEmpty()) {
      sb.append(charStack.pop());
    }

    // As Stack follows LIFO, reverse the current string
    return sb.reverse().toString();
  }
}