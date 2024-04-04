class MaxDepthSolution {
  public int maxDepth(String s) {
    /**
     * Approach:
     * One of the constraints states, 'It is guaranteed that parentheses expression s is a VPS'.
     * So, we can find the maximum depth of the VPS by tracking the opening and closing parenthesis.
     */

    int currOpenParenthesis = 0;
    int maxDepth = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        currOpenParenthesis += 1;
        maxDepth = currOpenParenthesis > maxDepth ? currOpenParenthesis : maxDepth;
      } else if (s.charAt(i) == ')') {
        currOpenParenthesis -= 1;
      }
    }

    return maxDepth;
  }
}
