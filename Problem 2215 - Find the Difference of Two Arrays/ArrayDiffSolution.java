class ArrayDiffSolution {
  public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    /**
     * Approach:
     * Put the integers of the two arrays inside two different sets
     * (arraylist can be used as well, but exclude the duplicates).
     * Then loop again through the arrays and compare the numbers
     * with the set of numbers created before.
     */

    HashSet <Integer> nums1Set = new HashSet<>();
    HashSet <Integer> nums2Set = new HashSet<>();
    List <Integer> nums1List = new ArrayList<>();
    List <Integer> nums2List = new ArrayList<>();

    for (int num: nums1) {
      nums1Set.add(num);
    }

    for (int num: nums2) {
      nums2Set.add(num);
      if (!nums1Set.contains(num)) {
        nums1Set.add(num); // Prevents repeative numbers from getting inserted twice
        nums2List.add(num);
      }
    }

    for (int num: nums1) {
      if (!nums2Set.contains(num)) {
        nums2Set.add(num); // Prevents repeative numbers from getting inserted twice
        nums1List.add(num);
      }
    }

    return new ArrayList<>(){{
      add(nums1List);
      add(nums2List);
    }};
  }
}
