class DestinationCitySolution {
  public String destCity(List<List<String>> paths) {
    /**
     * Approach:
     * First, we will add the cities in the first indices in a set, as they are not destination cities.
     * Later, we will check the cities in the second indices,
     * and the one that is not in the set will be the destination city.
     */

    HashSet <String>  notDestinationCity = new HashSet<>();
    for (int i = 0; i < paths.size(); i++) {
      notDestinationCity.add(paths.get(i).get(0));
    }

    for (int i = 0; i < paths.size(); i++) {
      if (!notDestinationCity.contains(paths.get(i).get(1))) {
        return paths.get(i).get(1);
      }
    }

    return "";
  }
}
