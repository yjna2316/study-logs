package effectivejava.chatp02.item06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

public class CreateStringTest {

  @Test
  public void createStringWithNew() {
    String str1 = new String("hello");
    String str2 = new String("hello");

    assertNotSame(str1, str2, "new String()을 사용하여 불필요하게 객체가 생성됨");
  }

  @Test
  public void createStringWithLiteral() {
    String str1 = "hello"; // String Pool에 저장된 "hello" 참조
    String str2 = "hello"; // 같은 "hello" 참조

    assertSame(str1, str2, "리터럴을 사용해 String Pool의 객체를 재사용한다");
  }
}
