class ValidParenthesesSolution {
  public boolean isValid(String s) {
    HashMap <Character,Character> map = new HashMap<>();
    map.put('(',')');
    map.put('{','}');
    map.put('[',']');
      
    //also putting them in reverse order to get value from key
    HashMap <Character,Character> mapReverse = new HashMap<>();
    mapReverse.put(')','(');
    mapReverse.put('}','{');
    mapReverse.put(']','[');
      
    Stack <Character> st = new Stack <>();
    char charArr [] = s.toCharArray();
      
    for(int i = 0; i<charArr.length; i++){
          
      //If it's an opening bracket put in stack
      if(map.containsKey(charArr[i])){
        st.push(charArr[i]);
      }
          
      //If there is no element already then return false
      else if (st.isEmpty()){
        return false;
      }
          
      //Checking statements for closing brackets
      else{
              
        //Check if it's something other than bracket
        if(!map.containsValue(charArr[i]))
          return false;
              
        char closingTag = charArr[i];
        //Get the opening bracket
        char openingTag = mapReverse.get(closingTag);
        //Pop the element
        char checker = st.pop();
        //If item not found then return false
        if(checker != openingTag)
          return false;
      }
    }
    return st.isEmpty();
  }
}