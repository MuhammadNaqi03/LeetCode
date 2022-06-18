class MaxWordsSolution {
  public int mostWordsFound(String[] sentences) {
    /**
    * Approach 1: Using split method
    * We will iterate through the senetences and split them by space.
    * The number of words will be splitted array length.
    * Find the max number of words and return.
    * As the problem stated - "a single space with no leading or trailing spaces",
    * we don't need to bother about those cases.
    * And also:
    * 1 <= sentences.length <= 100
    * 1 <= sentences[i].length <= 100 
    * So, we don't need to think about empty array or string.
    */
    
    // int maxWord = 0;
    // int localMax = 0;
    // for (String sentence: sentences) {
    //   localMax = sentence.split("\s").length;
    //   if (localMax > maxWord) {
    //     maxWord = localMax;
    //   }
    // }
    // return maxWord;
    
    
    
    
    /**
    * Approach 2: Counting the spaces
    * Count the number of spaces and add 1 with it to get total word count.
    * To count the spaces, replace the spaces with no space
    * then deduct the length of it from actual sentence length.
    * Return the max.
    */
    
    int maxWord = 0;
    int localMax = 0;
    for (String sentence: sentences) {
      localMax = 1 + sentence.length() - sentence.replace(" ", "").length();
      if (localMax > maxWord) {
        maxWord = localMax;
      }
    }
    return maxWord;
  }
}