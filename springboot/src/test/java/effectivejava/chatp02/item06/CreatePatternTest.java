package effectivejava.chatp02.item06;

import org.junit.jupiter.api.Test;

public class CreatePatternTest {

  private static final int ITERATIONS = 1_000_000;
  private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
  private static final String TEST_EMAIL = "test@example.com";

  @Test
  public void createPattern() {
    long startTime = System.nanoTime();

    for (int i = 0; i < ITERATIONS; i++) {
      TEST_EMAIL.matches(EMAIL_REGEX); // match 메소드 내부적으로 매번 새로운 Pattern 객체를 생성한다.
    }

    long endTime = System.nanoTime();
    long duration = (endTime - startTime);

    System.out.println("Pattern 객체 반복생성 소요 시간: " + duration + " ns");
  }
}
