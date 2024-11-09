package effectivejava.chatp02.item01;

import org.junit.jupiter.api.Test;
import java.util.Locale;
import static org.junit.jupiter.api.Assertions.*;

// 생성자를 사용하는 Role 클래스
class Role {
  private final String role;

  public Role(String role) {
    this.role = role;
  }

  public String getRole() {
    return role;
  }
}

// 정적 팩토리 메서드를 사용하는 UserRole 클래스
class UserRole {
  private final String role;

  // 정적 인스턴스 캐싱
  private static final UserRole ADMIN = new UserRole("ADMIN");
  private static final UserRole USER = new UserRole("USER");

  private UserRole(String role) {
    this.role = role;
  }

  // 정적 팩토리 메서드
  public static UserRole of(String roleName) {
    switch (roleName.toUpperCase(Locale.getDefault())) {
      case "ADMIN":
        return ADMIN;
      case "USER":
        return USER;
      default:
        return new UserRole(roleName); // 새로운 역할은 새로운 인스턴스를 생성
    }
  }

  public String getRole() {
    return role;
  }
}

// 테스트 클래스
public class UserRoleTest {

  @Test
  public void testRoleConstructor() {
    // 생성자를 사용하는 경우 매번 새로운 객체를 반환함
    Role role1 = new Role("ADMIN");
    Role role2 = new Role("ADMIN");

    // 역할 이름은 동일
    assertEquals(role1.getRole(), role2.getRole());

    // 하지만 두 객체는 서로 다른 인스턴스임
    assertNotSame(role1, role2);
  }

  @Test
  public void testRoleStaticFactoryMethod() {
    // 정적 팩토리 메서드를 사용하는 경우 동일한 객체를 재사용함
    UserRole admin1 = UserRole.of("ADMIN");
    UserRole admin2 = UserRole.of("ADMIN");

    // 두 객체는 같은 인스턴스임
    assertSame(admin1, admin2);
  }
}
