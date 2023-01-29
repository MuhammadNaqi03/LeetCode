class ConvertTemperatureSolution {
  public double[] convertTemperature(double celsius) {
    /**
     * Approach:
     * Just use the formulas. 
     */
    double kelvin = celsius + 273.15;
    double fahrenheit = (celsius * 1.8) + 32;
    return new double [] {kelvin, fahrenheit};
  }
}
