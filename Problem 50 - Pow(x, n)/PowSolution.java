class PowSolution {
  public double myPow(double x, int n) {
    /**
     * First Approach: Naive
     * We know that we can get pow(x, n) by repeated multiplication/division of the number by itself.
     * Example: 2^3 = 8, 2 * 2 * 2.
     * In this approach, we will continue to loop and multiply/divide till the power(n) reaches to 1.
     * As any number power 1 is the number itself.
     * Time Complexity: O(n).
     * Time limit exceeded for x = 0.00001 and n = 2147483647
     */
 
    // double result = x;
    // while (n != 1) {
    //   if (n > 1) {
    //     result = result * x;
    //     n--;
    //   } else {
    //     result = result / x;
    //     n++;
    //   }
    // }
    // return result;
    
    
    
    
    
    /**
     * Second Approach: Binary exponentiation
     * Let's visualize the power as binary representation.
     * Example: 3^5 = 3^0101 = 3^1 * 3^4
     * We can write like this,
     * 3^1
     * (3^1)^2 = 3^2
     * (3^2)^2 = 3^4 and so on.
     * Its just like binary representation and we need to multiply/divide
     * when we only get the set bit of the power.
     * For more read: https://cp-algorithms.com/algebra/binary-exp.html
     *
     * So how should we approach?:
     * Firstly, we will assign 1 in a variable (say result) thus if the power is 0 we can return that.
     * Afterwards, we will find out if the power is negative or not.
     * We will make the power positive if it's negative (as negative numbers are stored as 2's complement)
     * and make x = 1/x.
     * Then, unless the power becomes 0 we will run a loop.
     * Within the loop we will find out if the power & 1 is equal 1 or not.
     * If it's 1, then we multiply result with x.
     * Also, we will multiply x with x and divide n by 2.
     * n becomes 0? We will return the result.
     * Time complexity: O(logn)
     */
 
    double result = 1;
    if (n < 0) {
      n = -n;
      x = 1/x;
    }
    
    while (n != 0) {
      result = (n & 1) == 1 ? result * x : result;
      x = x * x;
      n = n/2;
    }
    return result;
  }
}