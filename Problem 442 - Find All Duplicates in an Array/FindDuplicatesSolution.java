class Solution {
  public List<Integer> findDuplicates(int[] nums) {
    /**
     * Approach: Modifying the original array
     * One of the constraints states that "Each element in nums appears once or twice". 
     * So, we can alter the sign of the numbers and get an idea from it
     * which numbers appear once and which ones appear twice.
     * The number inside the array will be in the range of the size of the array
     * (as per the constraint "1 <= nums[i] <= n"), so we can use those numbers as array indices.
     * We need to deduct 1 from the numbers to use them as array indices because the numbers in nums start from 1.
     * So, our idea is to run a loop and get the corresponding indices from the numbers.
     * Then, we will check if the number is already a negative,
     * which means the corresponding index has already appeared once before.
     * Afterwards, we will alter the sign of the number in that corresponding index. 
     */

    ArrayList <Integer> twiceAppearedList = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int corresPondingIndex = Math.abs(nums[i]) - 1;
      if (nums[corresPondingIndex] < 0) {
        twiceAppearedList.add(corresPondingIndex + 1);
      }
      nums[corresPondingIndex] = -nums[corresPondingIndex];
    }
    return twiceAppearedList;
  }
}
