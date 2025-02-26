class MetTargetSoluton {
  public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
    // Pretty easy problem; no explanation is needed
    int targetHourOrMore = 0;
    for (int hour: hours) {
      if (hour >= target) {
        targetHourOrMore += 1;
      }
    }
    return targetHourOrMore;
  }
}
