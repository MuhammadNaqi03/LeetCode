class DefangingAnIPSolution {
  public String defangIPaddr(String address) {
    // We can't use address.split(".") because . is 
    // a special character
    String [] st = address.split("[.]");
    int counter = 0;
    String output = "";
    for (String s: st){
      output += s;
      counter +=1;
      if (counter != st.length){
        output +="[.]";
      }
    }
      
    return output;
  }
}