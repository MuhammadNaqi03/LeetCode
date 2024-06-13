class MinMovesToSeatSolution {
  public int minMovesToSeat(int[] seats, int[] students) {
    /**
     * Approach: Sorting
     * To make the number of moves minimal,
     * we need to find the minimum differences between the array elements.
     * To do that, we will sort both the arrays and
     * find the differences between each element in the same index.
     */

    Arrays.sort(seats);
    Arrays.sort(students);

    int minMove = 0;
    for (int i = 0; i < seats.length; i++) {
      minMove += Math.abs(seats[i] - students[i]);
    }

    return minMove;
  }
}
