class AlikeStringHalvesSolution {
  public boolean halvesAreAlike(String s) {
    /**
     * Approach: 
     * First, we need to find out the mid index of the string.
     * Then, we will create two variables to track the vowel for each half.
     * We will count the number of vowels in each halves by calling 
     * a method which will return true if the character is a vowel.
     * If the two halves value are the same we will return true otherwise false.
     */

    int stringMid = s.length()/2;
    int firstHalfVowel = 0;
    int secondHalfVowel = 0;

    for (int i = 0; i < stringMid; i++) {
      firstHalfVowel = isVowel(s.charAt(i))? firstHalfVowel + 1 : firstHalfVowel;
    }

    for (int i = stringMid; i < s.length(); i++) {
      secondHalfVowel = isVowel(s.charAt(i))? secondHalfVowel + 1 : secondHalfVowel;
    }   
    return firstHalfVowel == secondHalfVowel;
  }


  public boolean isVowel (char ch) {
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
           ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
  }
}