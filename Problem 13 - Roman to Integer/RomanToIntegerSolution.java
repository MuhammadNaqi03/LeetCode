class RomanToIntegerSolution {
  public int romanToInt(String s) {
    if (s.length() == 0)
      return 0;
      
    //Creating a hashmap that will store the char to interger
    HashMap <Character,Integer> romanMap = new HashMap <>();
    romanMap.put('I',1);
    romanMap.put('V',5);
    romanMap.put('X',10);
    romanMap.put('L',50);
    romanMap.put('C',100);
    romanMap.put('D',500);
    romanMap.put('M',1000);
      
    int roman = 0;
    // We will loop before the last element as the last one always 
    // gets to add
    for(int i =0; i<s.length()-1; i++){
      //checking if the previous one is lesser than the latter
      //need to substract that in that case
      if(romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i+1)) ){
        roman -= romanMap.get(s.charAt(i));
      }
      else{
        roman += romanMap.get(s.charAt(i));
      }
    }
    return roman + romanMap.get(s.charAt(s.length()-1));
  }
}