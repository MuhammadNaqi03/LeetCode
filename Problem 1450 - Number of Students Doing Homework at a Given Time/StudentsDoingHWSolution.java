class StudentsDoingHWSolution {
  public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
    /**
     * Approach:
     * To do the homework at the queryTime, the startTime has to be less than or equal to the queryTime,
     * and the endTime has to be greater than or equal to the queryTime.
     * We don't need to worry about invalid data as per the constraints:
     * 1 <= startTime[i] <= endTime[i] <= 1000
     * 1 <= queryTime <= 1000
     */

    int numberOfStudents = 0;
    for (int i = 0; i < startTime.length; i++) {
      if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
        numberOfStudents += 1;
      }
    }
    return numberOfStudents;  
  }
}