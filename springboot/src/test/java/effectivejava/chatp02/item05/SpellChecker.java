package effectivejava.chatp02.item05;

interface Dictionary {
  boolean contains(String word);
}

class KoreanDictionary implements Dictionary {

  @Override
  public boolean contains(String word) {
    return "안녕하세요".equals(word);
  }
}

public class SpellChecker {
  private static final Dictionary dictionary = new KoreanDictionary(); // 클래스 내부에서 의존 객체 직접 생성하여 사용

  public static boolean isValid(String word) {
    return dictionary.contains(word);
  }
}
