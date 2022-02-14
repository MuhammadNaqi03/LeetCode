class ClimbingStairsSolution {
  public int climbStairs(int n) {
    
    // We don't need to put condition for negative values of n as constraint is 1 <= n <= 45

    /** Approach 1: Naive approach
    * Will work for lower values but will get Time Limit Exceeded for larger values.
    * Got Time Limit Exceeded for n = 45 in LeetCode
    */
    // if ( n < 3) return n; 
    // return climbStairs(n - 1) + climbStairs(n - 2);
    
    
    
    
    /** Approach 2: Using DP
    * Using the top-down (memoization) approach
    */
    // int memo [] = new int [n+1];
    // return helperMethod(n, memo);
    
    
    
    
    /** Approach 3: Using DP
    * Using the bottom-up (tabulation) approach
    */
    if (n < 3) return n;
    int memo [] = new int [n+1];
    memo[0] = 0;
    memo[1] = 1;
    memo[2] = 2;
    for (int i = 3; i<=n; i++) {
      memo[i] = memo[i-1] + memo[i-2];
    } 
    return memo[n];
    
    
    
    
    /** Approach 4: Using DP
    * Using the bottom-up (tabulation) approach
    * Not using array
    */
    // if (n < 3) return n;
    // int a = 1;
    // int b = 2;
    // int c = 0;
    // for (int i = 3; i <= n; i++) {
    //   c = a + b;
    //   a = b;
    //   b = c;
    // }
    // return c;

  }

  // public int helperMethod(int n, int memo []) {
  //   if (n < 3) return n;
  //   if (memo[n] == 0) {
  //     memo[n] = helperMethod(n-1, memo) + helperMethod(n-2, memo);
  //   }
  //   return memo[n];
  // }
}