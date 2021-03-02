class IsomorphicStringsSolution {
  public boolean isIsomorphic(String s, String t) {
    //Algo: Goal is to map the characters with same value
    //if they don't have the same value return false then
    if(s.length() == 0 || t.length() == 0)
      return false;
    if(s.length () != t.length())
      return false;
      
    HashMap <Character, Integer> sMap = new HashMap <Character, Integer>();
    HashMap <Character, Integer> tMap = new HashMap <Character, Integer>();
      
    //Map<Character, Integer> sMap = new HashMap<Character, Integer>();
    //Map<Character, Integer> tMap = new HashMap<Character, Integer>();
      
    for(int i = 0; i<s.length(); i++){
      int sVal = sMap.getOrDefault(s.charAt(i),-1);
      int tVal = tMap.getOrDefault(t.charAt(i),-1);
          
      if(sVal != tVal)
        return false;
          
      sMap.put(s.charAt(i),i);
      tMap.put(t.charAt(i),i);
    }
    return true;
  }
}