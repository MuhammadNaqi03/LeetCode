class MinStepAnagramSolution {
  public int minSteps(String s, String t) {
    /**
     * Approach: Using array for character count
     * As anagrams will have the same word frequency,
     * we will count their character frequency to calculate the steps needed.
     * First, we will create an array for counting character frequency.
     * The length of the array will be 26 as per constraint:
     * s and t consist of lowercase English letters only.
     * Then, we will first traverse the first string.
     * As the ASCII value of 'a' is 97, we will deduct 97 from the ASCII value of 
     * each character, thus 'a' represents 0, b represents 1, ... z represents 25.
     * Then, for every character, we will increment the value of 
     * the corresponding index the character represents.
     * Afterwards, we will traverse through the second string like the first one and 
     * now we will check if the corresponding index value is 0 or not.
     * If the value is 0, that means the character did not appear/appear less in the first string.
     * So we will increase our steps count.
     * Otherwise, we will decrement the value of the corresponding index of the array.
     * After traversing, we will return the steps count.
     * We don't need to check the two strings length as per constraints:
     * 1 <= s.length <= 5 * 104
     * s.length == t.length
     */
    int [] charCounterArr = new int [26];
    for (int i = 0; i < s.length(); i++) {
      int charValue = s.charAt(i) - 97;
      charCounterArr[charValue]++;
    }

    int stepsCount = 0;
    for (int i = 0; i < t.length(); i++) {
      int charValue = t.charAt(i) - 97;
      if (charCounterArr[charValue] == 0) {
        stepsCount++;
      } else {
        charCounterArr[charValue]--;
      }
    }
    return stepsCount;   
  }
}