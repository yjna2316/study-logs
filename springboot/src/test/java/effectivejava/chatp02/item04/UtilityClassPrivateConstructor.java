package effectivejava.chatp02.item04;

public class UtilityClassPrivateConstructor {
  // 생성자가 외부에서 호출되지 못하도록 private으로 선언
  private UtilityClassPrivateConstructor() {
    // 예외를 던져 클래스 내부에서도 실수로 인스턴스화가 되지 않도록 한다.
    throw new AssertionError("UtilityClassPrivateConstructor class cannot be instantiated");
  }

  // 정적 메서드만 존재
  public static int add(int a, int b) {
    return a + b;
  }
}