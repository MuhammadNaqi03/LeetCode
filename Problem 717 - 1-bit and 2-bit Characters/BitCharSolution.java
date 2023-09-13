class BitCharSolution {
  public boolean isOneBitCharacter(int[] bits) {
    /**
     * Approach:
     * According to the given problem statement, the 1-bit character can only be represented by 0.
     * So, we can come to the following conclusions:
     * 1. If the length of the 'bits' array is 1, that can only have a 1-bit character.
     * 2. If the array length is 2 and the first bit is 1, that means it has to be a 2-bit character.
     * And for other cases, we will run a loop until the last bit.
     * For every 1 in the 'bits' array, we will increment the loop counter by 2,
     * and for 0, we will increment that by 1.
     * We will check periodically if the counter reaches the 2nd last index and the bit in it is 1.
     * In that case, the last character has to be a 2-bit character.
     * Otherwise, it would be a 1-bit character.
     */
    if (bits.length == 1) {
      return true;
    }

    if (bits.length == 2 && bits[0] == 1) {
      return false;
    }

    int counter = 0;
    while (counter < bits.length - 1) {
      counter = bits[counter] == 0
        ? counter + 1
        : counter + 2;

      if (counter == bits.length - 2 && bits[counter] == 1) {
        return false;
      }
    }

    return true;
  }
}
