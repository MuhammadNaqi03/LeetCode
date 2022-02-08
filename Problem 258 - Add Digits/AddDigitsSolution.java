class AddDigitsSolution {
  public int addDigits(int num) {
    /* Digital root: The obtained single digit number from successive addition of a positive integer's digits
     is called a digital root or repeated digital sum. */

    /** Approach 1: Naive approach
    * Loop until the given number becomes 0 by successive division of the number by it's base
    * Before the division, add the mod of the number with respect to the base and store them in another variable
    * Check if the added value is greater than 9 (more than a single digit) and the number becomes 0
    * If so, assign the sum value to the number again and reset the sum.
    * Else return the sum
    */
    
//       int sum = 0;
    
//       while (num > 0) {
//         sum += num % 10;
//         num /= 10;

//         if (num == 0 && sum > 9 ) {
//           num = sum;
//           sum = 0;
//         }
//       }
//       return sum;
    
    
    
    // We can also use recursion here. We don't need the if block in that case :
    // return sum > 9 ? addDigits(sum) : sum;
    
    
    
    
    
    /** Approach 2: Using mathematical formula
    * Using Congruence Formula, we can find out digital root of any number with any base.
    * Formula : 
    * if the number is 0 then the digital root will also be 0
    * Else, digital root = 1 + ((num - 1) mod (base - 1))
    * Example:
    * Digital root of 38 is : 3 + 8 --> 11 --> 1 + 1 --> 2
    * Using formula : 1 + ((38-1) mod (10-1)) --> 1 + (37 mod 9) --> 1 + 1 --> 2
    * For details: https://en.wikipedia.org/wiki/Digital_root
    */
    
    return num == 0 ?  0 : (1 + ((num -1) % 9));
    
    }
}