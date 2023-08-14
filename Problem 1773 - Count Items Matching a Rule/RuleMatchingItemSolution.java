class RuleMatchingItemSolution {
  public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
    /**
     * Two of the given constraints are:
     * 'ruleKey is equal to either "type", "color", or "name".'
     * 'All strings consist only of lowercase letters.'
     * So, we can initialize a variable to track which index of the lists needs to be considered.
     * The initial value of the variable could be set to 0,
     * and if the ruleKey starts with 'c', we can change the value to 1,
     * and if it starts with 'n', we can change the value to 2.
     * Next, for every list, we will get the value that needs to be checked and
     * check that with the given ruleValue and count the matching item(s).
     */
    
    int indexToConsider = 0;
    if (ruleKey.charAt(0) == 'c') {
      indexToConsider = 1;
    } else if (ruleKey.charAt(0) == 'n') {
      indexToConsider = 2;
    }

    int itemsMatchingRule = 0;
    for (List item: items) {
      if (item.get(indexToConsider).equals(ruleValue)) {
        itemsMatchingRule += 1;
      }
    }

    return itemsMatchingRule;
  }
}
