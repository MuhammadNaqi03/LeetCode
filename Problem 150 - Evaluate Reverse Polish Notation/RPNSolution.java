class RPNSolution {
  public int evalRPN(String[] tokens) {
    /**
     * Approach:
     * We will first create a set to hold the operators and
     * a stack to hold the operands and results.
     * For every token, when we encounter an operand we will push that to stack.
     * But if we find an operator, then we will pop two elements from the stack,
     * calculate based on the operands and then push the result into the stack.
     * Remember, as stack follows LIFO, we need to - 
     * substract the first popped operand from the second popped operand.
     * and divide the second popped operand by the first popped operand.
     * Then after all the token ends, we will be left with the result inside the stack.
     * We don't need to care about empty array as per constraint:
     * '1 <= tokens.length <= 104.'
     * Also, the token will be valid as per constraint:
     * 'tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].'
     * Moreover, we don't need to think about the validity of the RPN expression as stated:
     * 'It is guaranteed that the given RPN expression is always valid. 
     * That means the expression would always evaluate to a result, 
     * and there will not be any division by zero operation.'
     */

    HashSet <String> operator = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
    Stack <Integer> RPNStack = new Stack<>();

    for (String token: tokens) {
      if (!operator.contains(token)) {
        RPNStack.push(Integer.parseInt(token)); // Convert the string operand before putting it in the stack
      } else {
        int firstOperator = RPNStack.pop();
        int secondOperator = RPNStack.pop();
        switch (token) {
          case "+":
            RPNStack.push(secondOperator + firstOperator);
            break;
          case "-":
            RPNStack.push(secondOperator - firstOperator);
            break;
          case "*":
            RPNStack.push(secondOperator * firstOperator);
            break;
          case "/":
            RPNStack.push(secondOperator / firstOperator);
            break;
        }
      }
    }

    return RPNStack.pop();
  }
}