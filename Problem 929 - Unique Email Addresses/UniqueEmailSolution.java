class UniqueEmailSolution {
  public int numUniqueEmails(String[] emails) {
    /**
     * Approach 1:
     * Thanks to the constraints, we don't need to check some cases like:
     * empty email addresses, email addresses with no local name or domain name,
     * invalid local or domain names, and emails starting with the ‘+’ character.
     * Also, the constraint: 1 <= emails[i].length <= 100 should be updated to
     * 7 <= emails[i].length <= 100 (according to other constraints)
     * Anyways, first we will find out the position of '@' symbol in every email
     * to break down the local name and domain name.
     * Then, we will find out if '+' present in the local name
     * and remove any subsequent letter until @ along with the '+' sign.
     * Afterwards, we will remove the '.'s from the local name.
     * We will save the modified email addresses to a set thus only unique addresses get inserted.
     * Afterwards, we will just return the size of the set.
     */
    
    Set <String> uniqueEmailSet = new HashSet<>();
    for (String email: emails) {
      int localNameEnd = email.indexOf("@");
      String localName = email.substring(0, localNameEnd);

      int plusSignIndex = email.indexOf("+");
      if (plusSignIndex != -1 && plusSignIndex < localNameEnd) {
        localName = localName.substring(0, plusSignIndex);
      }
      String uniqueEmail = localName.replaceAll("\\.", "") + email.substring(localNameEnd);
      uniqueEmailSet.add(uniqueEmail);
    }
    return uniqueEmailSet.size();




    /**
     * Approach 2: Using a bit more regex
     * Will replace both '.'s and the part after the '+' sign, along with the '+' itself
     * from the local name, with one regex expression.
     */
    // Set <String> uniqueEmailSet = new HashSet<>();
    // for (String email: emails) {
    //   int localNameEnd = email.indexOf("@");
    //   String localName = email.substring(0, localNameEnd);

    //   String uniqueEmail = localName.replaceAll("\\.|\\+.+", "") + email.substring(localNameEnd);
    //   uniqueEmailSet.add(uniqueEmail);
    // }
    // return uniqueEmailSet.size();
  }
}