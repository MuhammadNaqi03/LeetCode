class JewelsNStonesSolution {
  public int numJewelsInStones(String jewels, String stones) {
    /**
     * Approach 1: Using extra space
     * The approach is pretty simple: 
     * just put the characters of 'jewels' into a Hashset (Other data structures could also be used).
     * Then, check which characters are in the Hashset for the 'stones' string.
     * We don't need to worry about invalid characters as per the constraint:
     * 'jewels and stones consist of only English letters.'
     */
    // Set <Character> jewelsSet = new HashSet<>();
    // for (int i = 0; i < jewels.length(); i++) {
    //   jewelsSet.add(jewels.charAt(i));
    // }

    // int jewelsCount = 0;
    // for (int i = 0; i < stones.length(); i++) {
    //   if (jewelsSet.contains(stones.charAt(i))) {
    //     jewelsCount++;
    //   }
    // }
    // return jewelsCount++;






    /**
     * Approach 2: Constant space
     * This constraint, 'jewels and stones consist of only English letters' made things easy for us.
     * We only need to think about 52 characters (for upper-case and lower-case letters).
     * We just need to transform the characters' values so that we can fit them as array (of size 52) indices.
     * To do that, we can deduct 97 (the ASCII value of 'a') from the ASCII value of the character.
     * If the value becomes less than 0, it means that the character is an upper-case one
     * (The ASCII value of 'A' is 65 and 'Z' is 90).
     * We can tweak the value so that we can assign 'A' or 'a' to the 0th index and the other to the 26th index
     * (I put the upper-case letters from 0 to 25 index and lower-case ones from 26 to 51 index).
     * Afterwards, for every character we find in 'jewels', we'll increment the corresponding index of the array.
     * And for 'stones' we'll see if the corresponding index of the character is greater than 0
     * (or equals to 1 as per the constraint: 'All the characters of jewels are unique'),
     * and update the value of 'jewels' in the 'stones' accordingly.
     */
    char [] jewelsCounterArr = new char [52];
    for (int i = 0; i < jewels.length(); i++) {
      int transformedValue = getTransformedValue(jewels.charAt(i));
      jewelsCounterArr[transformedValue]++;
    }

    int jewelsCount = 0;
    for (int i = 0; i < stones.length(); i++) {
      int transformedValue = getTransformedValue(stones.charAt(i));
      if (jewelsCounterArr[transformedValue] > 0) {
        jewelsCount++;
      }
    }
    return jewelsCount++;
  }

  public int getTransformedValue (char ch) {
    int transformedValue = ch - 97 < 0  
      ? ch - 65
      : ch - 97 + 26;
    return transformedValue;
  }
}