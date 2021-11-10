class ContainsDuplicateSolution {
  public boolean containsDuplicate(int[] nums) {
    /*
    * Simple Problem Just put them in set. 
    * If the set contains the element return true.
    * We don't need to check if the array is empty as stated:
    * 1 <= nums.length <= 105
    */
    HashSet <Integer> set = new HashSet<>();
    for (int i : nums) {
      if (set.contains(i)) return true;
      set.add(i);
    }
    return false;
  }
}