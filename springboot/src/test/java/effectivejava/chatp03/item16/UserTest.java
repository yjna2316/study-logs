package effectivejava.chatp03.item16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

  @Test
  void publicFieldModification() {

    // 잘못된 구현 - public 필드 접근
    User badUser = new User("Jay", 25);

    // 외부에서 필드를 직접 수정 가능
    badUser.age = -10;
    assertEquals(-10, badUser.age);
  }

  @Test
  void encapsulatedField() {
    UserEncapsuledField goodUser = new UserEncapsuledField("Sara", 25);

    assertEquals("Sara", goodUser.getName());
    assertEquals(25, goodUser.getAge());

    // age 필드를 직접 변경하려고 하면 컴파일 에러 발생
    // user.age = -10;
  }

  @Test
  void publicFieldInternalChange() {
    // 잘못된 구현 - public 필드가 내부 변경을 어렵게 만듦
    User badUser = new User("Jay", 25);

    // age 필드를 int 대신 다른 타입(double)으로 변경하고자 할때,
    // 외부 API와의 호환성 문제로 내부 구현을 변경하기 쉽지 않다
    assertTrue(badUser.age >= 0);
  }

  @Test
  void encapsulatedFieldInternalChange() {
    // 개선된 구현 - 내부 표현을 변경할 수 있는 유연성 제공
    UserEncapsuledField goodUser = new UserEncapsuledField("Sara", 25);

    // age 필드를 int 대신 다른 타입(double)으로 변경해도, getter 메소드 통해 노출하므로
    // 외부 API 변경 없이 내부 구현을 쉽게 바꿀 수 있다
    assertEquals(25, goodUser.getAge());
  }

  @Test
  void publicFieldCannotEnsureInvariant() {
    // 잘못된 구현 - public 필드는 불변식 보장이 어려움
    User badUser = new User("Jay", 25);

    // 외부에서 필드를 변경하여 불변식 보장 못함
    badUser.age = -1; // 불변식(age >= 0) 지키지 못함
    assertTrue(badUser.age < 0); // 불변식이 깨진 상태
  }

  @Test
  void encapsulatedFieldEnsuresInvariant() {
    // 개선된 구현 - 불변식을 보장할 수 있음
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      new UserEncapsuledField("Sara", -25);
    });
    assertEquals("Age cannot be negative", exception.getMessage());
  }

  @Test
  void publicFieldCannotDoSomethingOnAccess() {
    // 잘못된 구현 - 필드에 접근할 때 부수 작업 수행 불가
    User badUser = new User("Jay", 25);

    // 나이를 가져올 때 기록(log)하거나 계산 작업을 추가할 수 없음
    int age = badUser.age; // 단순히 필드만 접근
    assertEquals(25, age);
  }

  @Test
  void encapsulatedFieldCannotDoSomethingOnAccess() {
    // 개선된 구현 - getter 메서드에서 부수 작업 수행 가능
    UserEncapsuledField goodUser = new UserEncapsuledField("Sara", 25);

    // getter 메서드에서 로그를 남기거나 부수 작업 수행 가능 (메서드 내부에 추가 가능)
    int age = goodUser.getAge();
    assertEquals(25, age);
  }
}
