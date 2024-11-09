package effectivejava.chatp02.item06;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

public class CreatePatternImprovedTest {
  private static final int ITERATIONS = 1_000_000;
  private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
  private static final String TEST_EMAIL = "test@example.com";

  // 미리 컴파일된 Pattern 객체 재사용
  private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

  @Test
  public void createPatternWithCaching() {
    long startTime = System.nanoTime();

    for (int i = 0; i < ITERATIONS; i++) {
      EMAIL_PATTERN.matcher(TEST_EMAIL).matches(); // 캐싱된 Pattern 객체 사용
    }

    long endTime = System.nanoTime();
    long duration = (endTime - startTime);

    System.out.println("Pattern 객체 재사용 소요 시간: " + duration + " ns");
  }
}
