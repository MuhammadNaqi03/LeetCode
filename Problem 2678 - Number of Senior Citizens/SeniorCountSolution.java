class SeniorCountSolution {
  public int countSeniors(String[] details) {
    /**
     * Approach:
     * We will extract the age part of the string
     * and then convert that to a number to check if it's greater than 60.
     * The constraint states that the ages of the passengers are denoted by two characters.
     * But the question is, what will happen to the passengers whose ages are more than 99?
     */

    int numOfSeniorCitizens = 0;
    for (String detail: details) {
      if (Integer.valueOf(detail.substring(11,13)) > 60) {
        numOfSeniorCitizens += 1;
      }
    }

    return numOfSeniorCitizens;
  }
}
