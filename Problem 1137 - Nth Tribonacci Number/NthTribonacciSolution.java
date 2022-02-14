class NthTribonacciSolution {
  public int tribonacci(int n) {
    // We don't need to put condition for negative values of n as constraint is 0 <= n <= 37

    /** Approach 1: Naive approach
    * Will work for lower values but will get Time Limit Exceeded for larger values.
    * Got Time Limit Exceeded for n = 35
    */
    // if (n < 2 ) return n;
    // if ( n == 2) return 1;
    // return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    
    
    
    
    
    /** Approach 2: Using DP
    * Using the top-down (memoization) approach
    */
    // int memo [] = new int [n + 1];
    // return helperMethod(n, memo);
    
    
    
    
    
    /** Approach 3: Using DP
    * Using the bottom-up (tabulation) approach
    */
    if (n < 2) return n;
    else if (n == 2) return 1;
    
    int memo [] = new int [n + 1];
    memo[0] = 0;
    memo[1] = 1;
    memo[2] = 1;
    
    for (int i = 3; i <= n; i++) {
      memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
    }
    return memo[n];
    
    
    
    
    
    /** Approach 4: Using DP
    * Using the bottom-up (tabulation) approach
    * Not using array
    */
//       if (n < 2) return n;
//       else if (n == 2) return 1;
    
//       int a = 0;
//       int b = 1;
//       int c = 1;
//       int d = 0;
    
//       for (int i = 3; i <= n; i++) {
//         d = a + b + c;
//         a = b;
//         b = c;
//         c = d;
//       }
//       return d;
    
  }

//     public int helperMethod(int n, int memo []) {
//       if (n < 2) return n;
//       else if (n == 2) return 1;
    
//       if (memo[n] == 0) {
//         memo[n] = helperMethod(n - 1, memo) + helperMethod(n - 2, memo) + helperMethod(n - 3, memo);
//       }
//       return memo[n];
  // }
}