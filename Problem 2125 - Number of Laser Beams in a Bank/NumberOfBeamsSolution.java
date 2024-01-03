class NumberOfBeamsSolution {
  public int numberOfBeams(String[] bank) {
    /**
     * Approach:
     * For each floor, the number of laser beams would be the multiplication
     * of the current floor's security devices and the previous floor's security devices.
     * So, we just need to find the number of security devices on each floor to find the total number of laser beams.
     */

    int totalLaserBeams = 0;
    int prevSecurityDevices = 0;
    int currSecurityDevices = 0;

    for (String floor: bank) {
      for (int i = 0; i < floor.length(); i++) {
        if (floor.charAt(i) == '1') {
          currSecurityDevices += 1;
        }
      }

      if (prevSecurityDevices != 0 && currSecurityDevices != 0) {
        totalLaserBeams = totalLaserBeams + prevSecurityDevices * currSecurityDevices;
      }

      if (currSecurityDevices != 0) {
        prevSecurityDevices = currSecurityDevices;
        currSecurityDevices = 0;
      }
    }

    return totalLaserBeams;
  }
}
