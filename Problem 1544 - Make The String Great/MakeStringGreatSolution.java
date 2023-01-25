class MakeStringGreatSolution {
  public String makeGood(String s) {
    /**
     * Approach: Using stack
     * First, we will return the actual string if the string has only one character.
     * If the string has more than one character,
     * we will create a stack to keep track of the characters.
     * If the stack is not empty, we will check the top of it with the current character,
     * and find out if the ASCII value difference of two characters is exactly 32.
     * (As, every uppercase letter has a value difference of 32 with the lower case counterpart)
     * If the value difference is 32, we will just pop the top element out of the stack.
     * Otherwise, we will push the current character.
     * After the loop ends, we will return the characters in the stack
     * in reverse order (as stack follows LIFO ) as a string.
     */


    if (s.length() == 1) {
      return s;
    }

    Stack <Character> charStack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (!charStack.isEmpty() && Math.abs(charStack.peek() - s.charAt(i)) == 32) {
        charStack.pop();
      } else {
        charStack.push(s.charAt(i));
      }
    }

    String greatString = "";
    while (!charStack.isEmpty()) {
      greatString = charStack.pop() + greatString;
    }
    return greatString;
  }
}
