class FinalValueSolution {
  public int finalValueAfterOperations(String[] operations) {
    /**
     * Approach:
     * Operations will be valid as per constraint:
     * operations[i] will be either "++X", "X++", "--X", or "X--".
     * So, for both prefix and postfix operations, 
     * we have to check the character at 2nd position (1st index).
     * As, it will always show if it is an addition or subtraction operation.
     */

    int result = 0;
    for (String operation: operations) {
      result = operation.charAt(1) == '+' ? result + 1 : result - 1;
    }
    return result;  
  }
}
