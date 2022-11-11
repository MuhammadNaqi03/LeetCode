class ReverseVowelsSolution {
  public String reverseVowels(String s) {
    /**
     * Approach 1: Using hashset and stack
     * First, we will check the length of the string. If it's less than 2, just return the string.
     * Then, we will create a set containing all the vowels and convert the string to a character array.
     * Afterwards, we will traverse the character array and insert all the vowels into a stack.
     * Then, if the arraylist size is less than 2, we will send the string.
     * Otherwise, we will just traverse the character array and whenever we encounter a vowel,
     * we replace that with the popped vowel from stack (as stack follows LIFO)
     * Lastly, return the character array as string.
     */
    
    // if (s.length() < 2) {
    //   return s;
    // }
 
    // HashSet <Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    // Stack <Character> vowelStack = new Stack<>();
    // char [] charArray = s.toCharArray();
    // for (char ch: charArray) {
    //   if (vowelSet.contains(ch)) {
    //     vowelStack.push(ch);
    //   }
    // }
 
    // if (vowelStack.size() < 2) {
    //   return s;
    // }
 
    // for (int i = 0; i < charArray.length; i++) {
    //   if (vowelSet.contains(charArray[i])) {
    //     charArray[i] = vowelStack.pop();
    //   }
    // }
    // return new String(charArray); 






    /**
     * Approach 2: Two pointers
     * We need to return if the string size is less than 2 and
     * make a character array of the given string like the first approach.
     * We also need to have a set to keep track of the vowel encounter.
     * But in this time, we will have two pointers pointing at the
     * very beginning (say, firstPointer) and end (say, secondPointer) of the character array.
     * We will traverse till the secondPointer's value is greater than the first one.
     * We will move both pointers if they don't point at vowels.
     * Whenever both pointers point at vowels we will swap them.
     * Finally, after traversing we will convert the character array to string and return.
     */
 
    if (s.length() < 2) {
      return s;
    }
 
    HashSet <Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    char [] charArray = s.toCharArray();
    int firstPointer = 0;
    int secondPointer = charArray.length - 1;
 
    while (firstPointer < secondPointer) {
      if (vowelSet.contains(charArray[firstPointer]) && vowelSet.contains(charArray[secondPointer])) {
        char temp = charArray[firstPointer];
        charArray[firstPointer] = charArray[secondPointer];
        charArray[secondPointer] = temp;
        firstPointer++;
        secondPointer--;
      } else {
        if (!vowelSet.contains(charArray[firstPointer])) {
          firstPointer++;
        }
        if (!vowelSet.contains(charArray[secondPointer])) {
          secondPointer--;
        }
      }
    }
 
    return new String(charArray);







    /**
     * Approach 3:
     * This approach is the same as the second one but we will use Stringbuilder
     * instead of converting the string to a character array.
     */
 
    // if (s.length() < 2) {
    //   return s;
    // }
 
    // HashSet <Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    // StringBuilder sb = new StringBuilder(s);
    // int firstPointer = 0;
    // int secondPointer = s.length() - 1;
 
    // while (firstPointer < secondPointer) {
    //   if (vowelSet.contains(sb.charAt(firstPointer)) && vowelSet.contains(sb.charAt(secondPointer))) {
    //     char temp = sb.charAt(firstPointer);
    //     sb.setCharAt(firstPointer, sb.charAt(secondPointer));
    //     sb.setCharAt(secondPointer, temp);
    //     firstPointer++;
    //     secondPointer--;
    //   } else {
    //     if (!vowelSet.contains(sb.charAt(firstPointer))) {
    //       firstPointer++;
    //     }
    //     if (!vowelSet.contains(sb.charAt(secondPointer))) {
    //       secondPointer--;
    //     }
    //   }
    // }
    // return sb.toString();
  }
}