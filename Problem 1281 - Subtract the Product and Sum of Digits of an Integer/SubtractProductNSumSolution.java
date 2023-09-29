class SubtractProductNSumSolution {
  public int subtractProductAndSum(int n) {
    int product = 1; // 1 <= n <= 10^5
    int sum = 0;
    int currDigit = 0;

    while (n > 0 ) {
      currDigit = n % 10;
      n /= 10;
      if (product != 0) {
        product *= currDigit;
      }
      sum += currDigit;
    }

    return product - sum;
  }
}
