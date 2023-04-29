class PrefixXorSolution {
  public int[] findArray(int[] pref) {
    /**
     * Approach:
     * The condition that needs to be satisfied is:
     * pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i],
     * So, pref[0] = arr[0]
     * pref[1] = arr[0] ^ arr[1]
     * pref[2] = arr[0] ^ arr[1] ^ arr[2] and so on.
     * We know that if we XOR two numbers, the same bits become 0 and different bits become 1.
     * So, to get the original number again,
     * all we need to do is XOR the number with the number prior to it.
     */

    int arr [] = new int [pref.length];
    arr[0] = pref[0]; // pref[0] = arr[0]
    for (int i = 1; i < pref.length; i++) {
      arr[i] = pref[i] ^ pref[i - 1];
    }
    return arr;
  }
}
