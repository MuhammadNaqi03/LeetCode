class PangramSolution {
  public boolean checkIfPangram(String sentence) {
    /**
     * Approach :
     * As the sentence contains only lowercase English letters,
     * We will first check if the length of the string is less than 26 or not.
     * Afterwards, we will create an array of size 26 and
     * populate the corresponding indices based on the letters ASCII values that we meet.
     * We have to deduct 97 from the ASCII values as the ASCII value of 'a' is 97.
     * Then, we will traverse the array again to find out if any of the indices has value 0.
     * Which indicates that the corresponding letter didn't appear in the sentence.
     * We will return false in that case, true will be returned otherwise.
     */
 
    if (sentence.length() < 26) {
      return false;
    }
 
    int [] letterFreqs = new int[26];
    char [] charArr = sentence.toCharArray();
 
    for (int i = 0; i < charArr.length; i++) {
      int charVal = charArr[i] - 97;
      letterFreqs[charVal]++;
    }
 
    for (int letterFreq: letterFreqs) {
      if (letterFreq == 0) {
        return false;
      }
    }
    return true;   
  }
}