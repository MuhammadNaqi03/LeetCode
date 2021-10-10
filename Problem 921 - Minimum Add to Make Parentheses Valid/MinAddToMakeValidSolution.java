class MinAddToMakeValidSolution {
  public int minAddToMakeValid(String s) {
    Stack <Character> stack = new Stack();
    int count = 0;
    for (char paranth: s.toCharArray()){
      if (paranth == '('){
        stack.push(paranth);
      }
      else {
        if (stack.isEmpty()){
          count++;
        }
        else{
          stack.pop(); 
        }
                  
      }
    }
    return stack.size() + count;
  }  
}