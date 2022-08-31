class GroupAnagramsSolution {
  public List<List<String>> groupAnagrams(String[] strs) {
    /**
     * Approach 1: Sorting the strings
     * First, we have to create a hashmap with key as string type and value as type arraylist.
     * Then, we will traverse the array and sort the strings.
     * After sorting, we will check if the sorted string is already in the map as key or not,
     * If the map has it as a key, we will just add the original string into the arraylist.
     * If the sorted string is not present as a key, then we will put it as a key and 
     * create an empty arraylist to put the original string into it afterwards.
     * We don't need to look for empty array as per constraint:
     * 1 <= strs.length <= 104
     * Also we don't need to worry about invalid characters as per constraint:
     * strs[i] consists of lowercase English letters.
     */
 
    HashMap<String, ArrayList<String>> sortedStringMap = new HashMap<>();
    for (String word: strs) {
      char [] charArr = word.toCharArray();
      Arrays.sort(charArr);
      String sortedString = new String(charArr);
      if (!sortedStringMap.containsKey(sortedString)) {
        // Creating an empty array list for the newly found key
        sortedStringMap.put(sortedString, new ArrayList<>());
      }
      sortedStringMap.get(sortedString).add(word);
    }
    return new ArrayList<>(sortedStringMap.values());
    
    
    
    
    
    
    /**
     * Approach 2: Using frequency as key
     * Similar to approach 1, but here we will generate word frequencies 
     * and use those as keys instead of sorting the string.
     */
 
//     HashMap<String, List<String>> sortedStringMap = new HashMap<>();
//     for(String word: strs) {
//       String letterFrequency = calculateFrequency(word);
//       if (!sortedStringMap.containsKey(letterFrequency)) {
//         sortedStringMap.put(letterFrequency, new ArrayList<>());
//       }
//       sortedStringMap.get(letterFrequency).add(word);
//     }
 
//     return new ArrayList<>(sortedStringMap.values());
  }
  
  
  
//   public String calculateFrequency (String word) {
//     int [] freqArr = new int [26]; // As, strs[i] consists of lowercase English letters
//     char [] letterArr = word.toCharArray();
 
//     // Populate the array responsible for calculating frequency
//     for (char letter: letterArr) {
//       freqArr[letter - 'a']++;
//     }
 
//     // Formulate the frequency string
//     StringBuilder frequencyString = new StringBuilder();
//     for (int i = 0; i < 26; i++) {
//       int currentChar = 'a';
//       frequencyString.append(currentChar);
//       frequencyString.append(freqArr[i]);
//       currentChar++;
//     }
//     return new String(frequencyString);
//   }
}