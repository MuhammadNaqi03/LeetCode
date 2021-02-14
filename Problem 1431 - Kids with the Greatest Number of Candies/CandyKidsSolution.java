class CandyKidsSolution {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    int max = 0;
    for (int candyCount: candies){
      max = Math.max(candyCount,max);
    }
    //It's convenient using arraylist. Using array is also OK 
    ArrayList <Boolean> greatestCandies = new ArrayList<>(candies.length);
    for (int candyCount: candies){
      greatestCandies.add(candyCount+extraCandies >= max);
    }
    return greatestCandies;
  }
}