class GoodPairsSolution {
  public int numIdenticalPairs(int[] nums) {
    
    /**
     * Approach: Using n(n-1)/2 to find out unique pairs.
     * Firstly, we will store the numbers in a hashmap and count the frequency.
     * Then, based on the formula n(n-1)/2 we will find unique pairs for each frequency.
     * Add them up and return the total pairs.
     *
     * More about n(n-1)/2:
     * Say, we are going to count the total number of handshakes between people.
     * Person 1 meets person 2 and they shake hands. So the handshake count for both the person is 1.
     * If the party has n persons including person 1, then person 1 can do handshake with n - 1 people.
     * So, n person can do n(n-1) handshakes.
     * But, here we are counting each handshake on two people's perspective.
     * For example, person 1 and person 2 shakes hand with each other.
     * So, from their separate perspectives, the toatl handshake count is 2(2-1), 2.
     * But the actual handshake count is 1. So we have to divide n(n-1) by 2.
     * On the problem statement as well the uniqueness is achieved by, i < j.
     * If it was not the case, then we didn't need to divide by 2.
     * Still have confusion? This may help:
     * https://math.stackexchange.com/questions/2214839/exactly-how-does-the-equation-nn-1-2-determine-the-number-of-pairs-of-a-given
     */
    
    
    HashMap <Integer, Integer> map = new HashMap<>();
    int totalPairs = 0;
    for (int num: nums) {
      map.put(num, 1 + map.getOrDefault(num, 0));
    }
 
    for (int frequency: map.values()) {
      totalPairs += (frequency * (frequency - 1))/2;
    }
    return totalPairs;
  }
}