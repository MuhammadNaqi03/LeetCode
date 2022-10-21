class MinIndexSumSolution {
  public String[] findRestaurant(String[] list1, String[] list2) {
    /**
     * Approach: Using HashMap
     * Firstly, we have put all the elements of one list and their indices as key value pairs in a hashmap.
     * Afterwards, we will traverse the other list and find out the restaurant(s) with least index sum.
     * We don't need to check for empty lists and consider cases where we can't find any match as per constraints:
     * You could assume there always exists an answer.
     * 1 <= list1.length, list2.length <= 1000.
     * Also no node will contain empty strings or gibberish strings as per constraints:
     * 1 <= list1[i].length, list2[i].length <= 30
     * list1[i] and list2[i] consist of spaces ' ' and English letters.
     */
 
    HashMap <String, Integer> restaurants = new HashMap<>();
 
    for (int i = 0; i < list1.length; i++) {
      restaurants.put(list1[i], i);
    }
 
    ArrayList <String> restaurantList = new ArrayList<>();
    int indexSum = 2000;  // 1 <= list1.length, list2.length <= 1000.
 
    for (int i = 0; i < list2.length; i++) {
      if (restaurants.containsKey(list2[i])) {
        int currIndexSum = restaurants.get(list2[i]) + i;
        if (currIndexSum == indexSum) {
          // Means that multiple restaurants with same index sum are found.So add them all.
          restaurantList.add(list2[i]);
        } else if (currIndexSum < indexSum) {
          // Means that a lower index sum is found. So empty the arraylist if it has any elements.
          // Then put the new one into it.
          if (restaurantList.size() != 0) {
            restaurantList.clear();
          }
          indexSum = currIndexSum;
          restaurantList.add(list2[i]);
        }
      }
    }
 
    return restaurantList.toArray(new String[restaurantList.size()]);
  }
}