class DailyTemperaturesSolution {
  public int[] dailyTemperatures(int[] temperatures) {
    /**
     * Approach: Monotonic stack
     * To solve this problem, we will use the mono-decreasing stack approach.
     * To learn more about monotonic stack: 
     * https://liuzhenglaichn.gitbook.io/algorithm/monotonic-stack
     * Our goal is to find out the next greater temparature and the interval in between.
     * For that, we will traverse through the temparature array and will compare
     * the top of the stack value with the current value. 
     * To ensure the correct position for the result array,
     * we will save the index of the array and compare the values of corresponding index. 
     * If the current index value is greater than the stored index value,
     * we will fill up the corresponding resut array with current index - stored index
     * and will pop up the element from the stack. 
     * We will do that until the current value is greater than the stack's top value.
     * For every iteration we will push the current element's index.
     */

    Stack <Integer> stack = new Stack<>();
    int [] resultArr = new int [temperatures.length];
 
    for (int i = 0; i < temperatures.length; i++) {
      while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
        int index = stack.pop();
        resultArr[index] = i - index;
      }
      stack.push(i);
    }
 
    return resultArr;
  }
}