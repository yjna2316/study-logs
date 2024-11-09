package effectivejava.chatp02.item06;

import org.junit.jupiter.api.Test;

public class CreateAutoboxingTest {

  @Test
  public void autoboxingInLoop() {
    Long sum = 0L; // Long 객체 사용 (오토박싱 발생)

    long startTime = System.nanoTime();
    for (long i = 0; i < 1_000_000; i++) {
      sum += i;
    }
    long endTime = System.nanoTime();

    System.out.println("오토박싱 소요시간: " + (endTime - startTime) + " ns");
  }

  @Test
  public void primitiveInLoop() {
    long sum = 0L; // Long 객체 사용 (오토박싱 발생)

    long startTime = System.nanoTime();
    for (long i = 0; i < 1_000_000; i++) {
      sum += i;
    }
    long endTime = System.nanoTime();

    System.out.println("기본타입 소요시간: " + (endTime - startTime) + " ns");
  }
}
