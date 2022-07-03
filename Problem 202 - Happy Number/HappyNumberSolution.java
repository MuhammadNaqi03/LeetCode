class HappyNumberSolution {
  public boolean isHappy(int n) {
    /**
    * Approach:
    * We will try to find cycle in the sequence.
    * For that, we will run a loop until the sum of the square root of the digits become 1.
    * And within the loop, we will add all the numbers that we'll encounter.
    * If we find the same number again that indicates that we have a cycle.
    * If we have a cycle that means we will just go over and over the same direction and
    * the sum of the square root of the digits will never be 1.
    * Thus, we can say it's not a happy number and return false.
    * Otherwise, if the number becomes 1, we will return true.
    * As per constraint: 1 <= n <= 231 - 1, the number will always be greater or equal to one.
    * Thus we don't need to tackle cases where number could be 0 or negative.
    */
    
    HashSet <Integer> loopFinder = new HashSet<>();
    while (n != 1) {
      if (loopFinder.contains(n)) {
        return false;
      }
      
      loopFinder.add(n);
      int squaredSum = 0;
      while (n > 0) {
        int remainder = n%10;
        squaredSum = squaredSum + remainder*remainder;
        n = n/10;
      }
      n = squaredSum;
    }
    return true;
  }
}
