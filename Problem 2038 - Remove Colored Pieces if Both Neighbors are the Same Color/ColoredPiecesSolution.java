class ColoredPiecesSolution {
  public boolean winnerOfGame(String colors) {
    /**
     * The only way the players can remove a colored piece is if the adjacent pieces are of the same color.
     * So, we can count the same color adjacent pieces, and if Alice has more adjacent pieces,
     * that means she wins; otherwise, she does not (we don't consider a draw).
     * Also, if the length of “colors” is less than 3, Alice will always lose (as she starts first).
     * We don't need to handle invalid input as per the constraint:
     * "colors consists of only the letters 'A' and 'B'".
     */

    if (colors.length() < 3) {
      return false;
    }

    int alicePoint = 0;
    int bobPoint = 0;
    for (int i = 1; i < colors.length() - 1; i++) {
      if (colors.charAt(i) == 'A' && colors.charAt(i + 1) == 'A' && colors.charAt(i - 1) == 'A') {
        alicePoint++;
      } else if (colors.charAt(i) == 'B' && colors.charAt(i + 1) == 'B' && colors.charAt(i - 1) == 'B') {
        bobPoint++;
      }
    }

    return alicePoint > bobPoint;
  }
}
