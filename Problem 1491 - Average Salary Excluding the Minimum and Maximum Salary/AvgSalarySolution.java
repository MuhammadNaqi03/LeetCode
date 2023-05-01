class AvgSalarySolution {
  public double average(int[] salary) {
    /**
     * Approach:
     * We can find the minimum and maximum salary along with the total salary on the go,
     * as the constraint says: 'All the integers of salary are unique.'
     * Afterwards, we can just remove the minimum and maximum salaries from the total salary
     * and divide that by the length of the array - 2.
     * The array will always have at least 3 elements as per constraint: '3 <= salary.length <= 100'.
     */

    int min = salary[0];
    int max = salary[0];
    int totalSalary = 0;
    for (int individualSalary: salary) {
      if (min < individualSalary) {
        min = individualSalary;
      }
      if (max > individualSalary) {
        max = individualSalary;
      }
      totalSalary += individualSalary;
    }
    return ((double)(totalSalary - min - max) / (salary.length - 2));
  }
}
