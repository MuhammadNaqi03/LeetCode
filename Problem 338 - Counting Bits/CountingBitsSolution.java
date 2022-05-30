class CountingBitsSolution {
  public int[] countBits(int n) {
    /**
     * First Approach: Using Brian Kernighan's algorithm.
     * We will create an array with n+1 size (as for n = 3, we have 0, 1, 2, and 3 indices).
     * Then, we will loop from 0 to the number and for every number we will apply Brian Kernighan's algorithm
     * and fill up the corresponding indices with the number of 1 found.
     * Time complexity : O(nlogn)   (n for first loop, logn for Brian Kernighan's algorithm)
     */

    // int [] setBitsPerNum = new int [n+1];
    // for (int i = 0; i <= n; i++) {
    //   int setBits = 0;
    //   int currentNum = i;
    //   while ( currentNum != 0) {
    //     currentNum = currentNum & (currentNum - 1);
    //     setBits++;
    //   }
    //   setBitsPerNum[i] = setBits;
    // }
    // return setBitsPerNum;
    
    
    
    
    
    /**
     * Second Approach: Using DP.
     * First check if the number is 0 (Constraint: )
     * Same as the previous approach our array will be of size n+1.
     * Our base case is 0 and 1. Fill up first two indices with 0 and 1. (arr[0] = 0, arr[1] = 1)
     * Now let's consider that every number is i.
     * 2 --> 0010 (1 set bit) --> arr[1] --> arr[2/2] --> arr[i/2]
     * 3 --> 0011 (2 set bits) --> arr[1] + 1 --> arr[3/2] + 1 --> arr[i/2] + 1
     * 4 --> 0100 (1 set bit) --> arr[2] --> arr[4/2] --> arr[i/2]
     * 5 --> 0101 (2 set bits) --> arr[2] + 1 --> arr[5/2] + 1 --> arr[i/2] + 1
     * 6 --> 0110 (2 set bits) --> arr[3] --> arr[6/2] --> arr[i/2]
     * 7 --> 0111 (3 set bits) --> arr[3] + 1 --> arr[7/2] + 1 --> arr[i/2] + 1
     * 8 --> 1000 (1 set bit) --> arr[4] --> arr[8/2] --> arr[i/2]
     * 9 --> 1001 (2 set bits) --> arr[4] + 1 --> arr[8/2] + 1 --> arr[i/2] + 1
     * So we can make a formula from this:
     * If i is even, the number of bits will be arr[i/2]
     * If i is odd, the number of bits will be arr[i/2] + 1
     * Time complexity: O(n)
     */
    
    if (n == 0) return new int []{0};
    int [] setBitsPerNum = new int [n+1];
    setBitsPerNum[0] = 0;
    setBitsPerNum[1] = 1;

    for (int i = 2; i <= n; i++) {
      setBitsPerNum[i] = i % 2 == 0 ? setBitsPerNum[i/2] : setBitsPerNum[i/2] + 1;
    }
    return setBitsPerNum;
  }
}