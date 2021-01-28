class CountPrimesSolution {
  public int countPrimes(int n) {
    //making a boolean array saying all numbers are prime
    boolean [] isPrime = new boolean[n];
    for (int i=2; i<n; i++)
      isPrime[i] = true;

    //finding the prime using Sieve of Eratosthenes
    for (int i = 2; i*i < n; i++){
      if (isPrime[i]==true){
        for (int j = i*i; j <n; j+=i){
          isPrime[j] = false; 
        }
      }
    }
        
    int primeCount = 0;
    for(int i = 0; i <n; i++){
      if(isPrime[i]==true){
        primeCount +=1;
      }
    }
    return primeCount; 
  }
}