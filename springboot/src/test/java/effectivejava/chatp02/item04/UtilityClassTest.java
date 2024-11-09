package effectivejava.chatp02.item04;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class UtilityClassTest {

  @Test
  public void instanceCreationAllowed() {
    // 의도치 않게 인스턴스 생성
    UtilityClass utilityInstance = new UtilityClass();

    // 정적 메소드 사용 - 인스턴스를 통해 사용하게 됨
    int result = utilityInstance.add(5, 10);

    assertEquals(15, result);
  }

  @Test
  public void instanceCreationNotAllowed() {
    // 의도하지 않은 인스턴스화 시도 시 컴파일 에러 발생
    // UtilityClassPrivateConstructor utilityInstance = new UtilityClassPrivateConstructor();

    int result = UtilityClassPrivateConstructor.add(5, 10);
    assertEquals(15, result);
  }


  @Test
  public void testPrivateConstructor() {
    // 리플렉션을 통해 private 생성자에 접근
    Constructor<UtilityClassPrivateConstructor> constructor = null;

    try {
      constructor = UtilityClassPrivateConstructor.class.getDeclaredConstructor();
      constructor.setAccessible(true);

      // private 생성자를 통한 인스턴스 생성 시도
      assertThrows(InvocationTargetException.class, constructor::newInstance);

    } catch (Exception e) {
      fail("Unexpected exception occurred: " + e.getMessage());
    }
  }
}