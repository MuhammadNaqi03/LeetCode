class GoalParserSolution {
  public String interpret(String command) {
    /**
     * Approach:
     * The command will not have any invalid characters as per the constraint:
     * "command consists of "G", "()", and/or "(al)" in some order."
     * So, we don't need to worry about invalid character handling.
     * In our approach, we'll have a pointer to find out the current character of the command.
     * If the current character of the string is 'G', we'll add 'G' to our interpretation and increment the pointer by 1.
     * Otherwise, if we have '(' we'll check if the next character is 'a'.
     * That means the substring is "(al)" and we can add "al" to our interpretation.
     * Also, we'll increment the pointer by 4.
     * But if the next character is ')' we'll add 'o' to our interpretation and increment the pointer by 2. 
     */
    
    int pointer = 0;
    StringBuilder interpretationSb = new StringBuilder();
    while (pointer < command.length()) {
      if (command.charAt(pointer) == '(') {
        if (command.charAt(pointer + 1) == 'a') {
          interpretationSb.append("al");
          pointer += 4;
        } else { // The next character is ')'
          interpretationSb.append("o");
          pointer += 2;
        }
      } else {
        interpretationSb.append("G");
        pointer += 1;
      }
    } 
    return interpretationSb.toString();
  }
}
