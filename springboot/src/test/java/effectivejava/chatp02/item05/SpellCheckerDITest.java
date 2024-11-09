package effectivejava.chatp02.item05;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// 테스트용 Mock Dictionary
class MockDictionary implements Dictionary {
  @Override
  public boolean contains(String word) {
    return "hello".equals(word);
  }
}

public class SpellCheckerDITest {

  @Test
  public void testIsValid() {
    SpellCheckerDI spellChecker = new SpellCheckerDI(new MockDictionary());
    assertTrue(spellChecker.isValid("hello"));
    assertFalse(spellChecker.isValid("world"));
  }
}
