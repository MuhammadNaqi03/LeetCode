class LongestCommonPrefixSolution {
  public String longestCommonPrefix(String[] strs) {
    /*
    Algo: We will do horizontal scanning
    Means we will scan two at a time 
    then will scan the next one with the 
    remaining prefix
    */
      
    //first border case checking
    if(strs.length == 0)
        return "";
      
    // Taking the whole first string as a prefix
    String prefix = strs[0];
      
    /*
    Now will take the common part
    Will check if the whole string is a substring of prefix
    Will get -1 if it's not
    So we will decrease the prefix length
    If the prefix becomes none then we don't have any common part
    */
      
    for (int i = 1; i<strs.length; i++){
      //will loop untill the prefix becomes ""
      //s.indexOf("") == 0
      while(strs[i].indexOf(prefix)!=0){
        /*
        Decreasing the prefix length by 1
        As index starts from 0 if we put lenght -1 
        as the end index it will decrease the size by 
        1 every time
        */
        prefix = prefix.substring(0,prefix.length()-1);
              
        //Returns if the string becomes ""
        //Means s.substring(0,0)
        if(prefix == "")
          return prefix;
      }
    }
    return prefix;
  }
}