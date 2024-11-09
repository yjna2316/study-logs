package effectivejava.chatp02.item03;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class SingletonTest {

  @Test
  void testStaticFieldSingleton() {
    StaticFieldSingleton instance1 = StaticFieldSingleton.INSTANCE;
    StaticFieldSingleton instance2 = StaticFieldSingleton.INSTANCE;

    assertSame(instance1, instance2, "Both instances should be the same");
  }


  @Test
  void testFactoryMethodSingleton() {
    FactoryMethodSingleton instance1 = FactoryMethodSingleton.getInstance();
    FactoryMethodSingleton instance2 = FactoryMethodSingleton.getInstance();

    assertSame(instance1, instance2, "Both instances should be the same");
  }

  @Test
  void testSingletonInstanceIsSame() {
    EnumSingleton instance1 = EnumSingleton.INSTANCE;
    EnumSingleton instance2 = EnumSingleton.INSTANCE;

    // 두 인스턴스가 동일한지 확인합니다.
    assertSame(instance1, instance2, "Both instances should be the same");
  }
}