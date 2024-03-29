class ParkingSystemSolution {
  int [] carSpots = new int [3];
  public ParkingSystem(int big, int medium, int small) {
    carSpots = new int []{big, medium, small};
  }
    
  public boolean addCar(int carType) {
    return (carSpots[carType - 1]-- > 0);
  }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
