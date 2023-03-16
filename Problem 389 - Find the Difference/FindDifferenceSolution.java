class FindDifferenceSolution {
  public char findTheDifference(String s, String t) {
    /** 
     * Approach 1 (We can also make the solution work for multiple mismatched char with a bit tweak): 
     * First have to create an array with length 26 (as per constraint: s and t consist of lowercase English letters)
     * Will populate the index of the array by the appearance of characters of the string s.
     * We will calculate the index value by : (int)(s.charAt(i) - 97).
     * 97 is deducted here as the decimal value of 'a' is 97.
     * Thus will get an array which index 0 represents a, index 1 represents b and so on.
     * Then everytime we find a character we will update the corresponding index.
     * After the traversal of s we will do same traversal for t.
     * But now we will deduct value from the index of the corresponding character.
     * If we find any index that becomes negative, it means this is the mismatched char we are looking for.
     */
    
    // char diff = ' ';
    // int [] arr = new int [26];
    // for (int i = 0; i < s.length(); i++) {
    //   int charVal = (int)(s.charAt(i)) - 97;  // t.charAt(i) - 97 also works
    //   arr[charVal]++;
    // }
    
    // for (int i = 0; i < t.length(); i++) {
    //   int charVal = (int)(t.charAt(i)) - 97;
    //   arr[charVal]--;
    //   if (arr[charVal] < 0) {
    //     diff = (char)(charVal + 97); // diff = charVal + 97 gives loosy conversion error
    //     break;
    //   }
    // }
    
    // return diff;
    
    


    
    /** 
     * Approach 2 (Won't work for multiple mismatched chararacters): 
     * Add all the characters' integer value of s and t.
     * Find the difference and convert the value to char.
     */
    
    // int sSum = 0;
    // int tSum = 0;
    // for (int i = 0; i < s.length(); i++) {
    //   sSum += (int)(s.charAt(i));
    //   tSum += (int)(t.charAt(i));
    // }
    // tSum += (int)(t.charAt(t.length()-1));  // As : t.length == s.length + 1
    // return (char)(tSum - sSum);





    /**
     * Approach 3 (Won't work for multiple mismatched characters):
     * Only one character is extra in t.
     * Thus, we can use XOR such that all the same characters from s and t become 0, leaving the extra character.
     */
    
    int missingCharVal = t.charAt(t.length() - 1);

    for (int i = 0; i < s.length(); i++) {
      missingCharVal = missingCharVal ^ s.charAt(i) ^ t.charAt(i);
    }

    return (char)missingCharVal;
  }
}
