class BackspaceStringSolution {
  public boolean backspaceCompare(String s, String t) {
    /**
     * Approach: Using Stack
     * We will have two stacks for putting the characters of the two strings.
     * Whenever we get '#' and the stack is not empty, we will pop a character.
     * Else, we will push the character. 
     * After traversing all the characters for the two strings, 
     * we will check if the characters within the two stacks are same or not.
     */  

    Stack <Character> sStack = insertChar(s);
    Stack <Character> tStack = insertChar(t);
    
    // Loop till both of the stacks have characters in them and find if any mismatch happens
    while (!sStack.isEmpty() && !tStack.isEmpty()) {
      if (sStack.pop() != tStack.pop()) {
        return false;
      }
    }

    // Both stacks need to be empty if both strings are backspace equal
    return (sStack.isEmpty() && tStack.isEmpty());
  }


  // Helper method for inserting characters into the stacks
  public Stack<Character> insertChar(String str) {
    Stack <Character> stack = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '#') {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else {
        stack.push(str.charAt(i));
      }
    }
    return stack;
  }
}
