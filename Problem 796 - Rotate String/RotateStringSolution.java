class RotateStringSolution {
  public boolean rotateString(String A, String B) {
    //the rotation must be a substring of A+A 
    //So just check if it's a substring or not
    return A.length() == B.length() && (A+A).contains(B);
  }
}