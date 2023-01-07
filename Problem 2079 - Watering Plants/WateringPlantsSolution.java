class WateringPlantsSolution {
  public int wateringPlants(int[] plants, int capacity) {
    /**
     * In this problem, we first check if we have the amount of water that the current plant needs
     * and afterwards we proceed. Else, we go back to the river.
     * So we need to track three things here - 
     * The distance between the river and the current plant (say, distanceFromRiver),
     * The current capacity of the watering can (say, currCapacity) and,
     * The total minimum distance (say, totalStep) to water all the plants (which needs to be returned).
     * So, if the water need of current plant is less the currCapacity, we will just
     * increment the distanceFromRiver, totalStep by 1 and
     * subtract the current plant's water need from the currCapacity.
     * Otherwise, we have to go back to the river and then come back before the current plant and 
     * proceed to the current plant to water the plant.
     * So we will add 1 and the double of the distanceFromRiver with totalStep.
     * As we proceed, the distanceFromRiver river will be updated by 1.
     * And the currCapacity will be updated with the capacity given and 
     * then that will be subtracted by the water need of the current plant.
     */

    int distanceFromRiver = 0;
    int totalStep = 0;
    int currCapacity = capacity;

    for (int i = 0; i < plants.length; i++) {
      if (currCapacity < plants[i]) {
        totalStep += distanceFromRiver * 2 + 1;
        currCapacity = capacity - plants[i];
      } else {
        totalStep += 1;
        currCapacity -= plants[i];
      }
      distanceFromRiver += 1;
    }
    return totalStep;
  }
}
