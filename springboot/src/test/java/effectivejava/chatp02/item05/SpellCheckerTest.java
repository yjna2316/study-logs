package effectivejava.chatp02.item05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpellCheckerTest {

  @Test
  public void spellCheck() {
    SpellChecker spellChecker = new SpellChecker();
    // "안녕하세요"라는 단어가 KoreanDictionary에 있는지 확인

    assertTrue(SpellChecker.isValid("안녕하세요"));

    // "안녕히가세요"라는 단어가 없으므로 false가 되어야 함
    assertFalse(SpellChecker.isValid("안녕히가세요"));
  }
}
