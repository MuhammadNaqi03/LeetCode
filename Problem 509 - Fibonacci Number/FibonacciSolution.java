class FibonacciSolution {
  public int fib(int n) {
    // We don't need to put condition for negative values of n as constraint is 0 <= n <= 30

    /** Approach 1: Naive approach
    * Will work for lower values but will get Time Limit Exceeded for larger values.
    */
    // if (n < 2) return n;
    // return fib(n - 1) + fib(n - 2);
    
    
    
    
    
    /** Approach 2: Using DP
    * Using the top-down (memoization) approach
    */
    // int [] memo = new int [n+1];
    // return helperMethod(n, memo);
    
    
    
    
    
    /** Approach 3: Using DP
    * Using the bottom-up (tabulation) approach
    */
    if (n < 2) return n;
    int [] memo = new int [n + 1];
    memo[0] = 0;
    memo[1] = 1;
    
    for (int i = 2; i <= n; i++) {
      memo[i] = memo[i - 1] + memo[i - 2];
    } 
    return memo[n];
    
    
    
    
    
    /** Approach 4: Using DP
    * Using the bottom-up (tabulation) approach
    * Not using array
    */
    // if (n < 2) return n;
    // int a = 0;
    // int b = 1;
    // int c = 0;
    // for (int i = 2; i <= n; i++) {
    //   c = a + b;
    //   a = b;
    //   b = c;
    // }
    // return c;
  }

  // public int helperMethod(int n, int [] memo) {
  //   if (n < 2) return n;
  //   if (memo[n] == 0) {
  //     memo[n] = helperMethod(n - 1, memo) + helperMethod(n - 2, memo);
  //   } 
  //   return memo[n];
  // }
}