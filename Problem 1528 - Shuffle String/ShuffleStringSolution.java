class ShuffleStringSolution {
  public String restoreString(String s, int[] indices) {
    //Creating an array which will sort things right
    char [] charOrdered = new char [indices.length];
      
    //Now loop through the indices and rearrange array
    for (int i = 0; i< charOrdered.length; i++){
      charOrdered[indices[i]] = s.charAt(i);
    }
      
    return new String(charOrdered);
  }
}