class WordsWithCharSolution {
  public List<Integer> findWordsContaining(String[] words, char x) {
    // Pretty easy problem; no explanation is needed
    ArrayList <Integer> list = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      if (words[i].indexOf(x) != -1) {
        list.add(i);
      }
    }

    return list;
  }
}
