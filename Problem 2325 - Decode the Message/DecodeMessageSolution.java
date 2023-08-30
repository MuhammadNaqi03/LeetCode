class Solution {
  public String decodeMessage(String key, String message) {
    /**
     * Approach:
     * All we need to do in this problem is map the characters corresponding to the given key.
     * And then, while decoding, we will just get the mapped value of the given message.
     * The 'message' and 'key' will not contain invalid characters as per the constraints:
     * "key consists of lowercase English letters and ' '."
     * "message consists of lowercase English letters and ' '."
     * And all the letters will be mapped according to the given constraint:
     * "key contains every letter in the English alphabet ('a' to 'z') at least once."
     */

    int currAscii = 97; // ASCII value of 'a' is 97
    int [] keyMap = new int [26];

    // Build the mapped table
    for (int i = 0; i < key.length(); i++) {
      int currCharVal = key.charAt(i);
      if (currCharVal != 32 && keyMap[currCharVal - 97] == 0) { // ASCII value of space is 32
        keyMap[currCharVal - 97] = currAscii++;
      }
    }

    StringBuilder sb = new StringBuilder(message.length());
    // Decode the message
    for (int i = 0; i < message.length(); i++) {
      char currChar = message.charAt(i);
      if (currChar == ' ') {
        sb.append(' ');
      } else {
        char decodedChar = (char)keyMap[currChar - 97];
        sb.append(decodedChar);
      }
    }

    return sb.toString();
  }
}
