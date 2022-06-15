class ThreeSumSolution {
  public List<List<Integer>> threeSum(int[] nums) {
    /**
     * Approach: Two Pointers (Valid for k = any number)
     * First, we have to create a set to hold the lists. (say returnedSet)
     * We will use set thus there's no chance of duplicates.
     * Then, we have to check if the array size is less than 3.
     * We will return empty list in that case.
     * Afterwards, we have to sort the array.
     * Then we will have a loop and inside the loop, we will initialize firstNumber as nums[i].
     * Our goal is to find find three numbers such that their addition becomes k.
     * For the firstNumber, if it gets greater than k, then we will just break the loop.
     * Reason: As the array is sorted, the lower number will be assigned as firstNumber.
     * So, if it exceeds k, adding more number (later numbers are greater) will make it larger.
     * In order to find out the other two numbers, we will use two pointers approach.
     * The two pointers would be leftIndex = i + 1 and rightIndex = nums.length - 1.
     * Then, the two numbers would be leftNumber = nums[leftIndex] and rightNumber = nums[rigthIndex].
     * We will find out if firstNumber + leftNumber + rightNumber == k.
     * If it's less than k, then we will move the left pointer(increment by 1).
     * If it's more than k, then we will move the right pointer(decrement by 1).
     * If the addition becomes k then include the three numbers in a list and insert that list to the returnedSet.
     * And shift the left and right pointers to find out if any more matches can be found for firstNumber.
     * After the loop ends we will return the returnedSet as a list.
     */
    
    Set <List<Integer>> returnedSet = new HashSet<>();
    if (nums.length < 3) return new ArrayList<>(returnedSet);
    
    Arrays.sort(nums); 
 
    for (int i = 0; i < nums.length - 2; i++) { // As atleast 3 numbers needed we're looping till nums.length - 2
      int firstNumber = nums[i];
      if (nums[i] > 0) break; // Here, k = 0
      
      int leftIndex = i + 1;
      int rightIndex = nums.length - 1;

      
      while (leftIndex < rightIndex) {
        int leftNumber = nums[leftIndex];
        int rightNumber = nums[rightIndex];
        
        if (firstNumber + leftNumber + rightNumber == 0) { // Here, k = 0
          returnedSet.add(Arrays.asList(firstNumber, leftNumber, rightNumber));
          leftIndex = leftIndex + 1;
          rightIndex = rightIndex - 1;
        } else if (firstNumber + leftNumber + rightNumber < 0) {
          leftIndex = leftIndex + 1;
        } else {
          rightIndex = rightIndex - 1;
        }
      }
    }
    
    return new ArrayList<>(returnedSet);
  }
}
