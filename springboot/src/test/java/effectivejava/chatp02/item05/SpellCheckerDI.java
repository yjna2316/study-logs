package effectivejava.chatp02.item05;

public class SpellCheckerDI {
  private final Dictionary dictionary;

  public SpellCheckerDI(Dictionary dictionary) {
    this.dictionary = dictionary;
  }

  public boolean isValid(String word) {
    return dictionary.contains(word);
  }
}
