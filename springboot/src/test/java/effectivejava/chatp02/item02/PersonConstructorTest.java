package effectivejava.chatp02.item02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Person {
  private final String name;  // 필수
  private final int age;      // 필수
  private final String address;
  private final String phone;
  private final String email;

  // 매개변수가 많은 생성자
  public Person(String name, int age, String address, String phone, String email) {
    this.name = name;
    this.age = age;
    this.address = address;
    this.phone = phone;
    this.email = email;
  }

  // getter 메서드
  public String getName() { return name; }
  public int getAge() { return age; }
  public String getAddress() { return address; }
  public String getPhone() { return phone; }
  public String getEmail() { return email; }
}

public class PersonConstructorTest {

  @Test
  public void createPersonWithConstructor() {
    // 매개변수가 많아 실수하기 쉬움
    Person person = new Person("Alice", 30, "123 Main St", "123-456-7890", "alice@example.com");

    assertEquals("Alice", person.getName());
    assertEquals(30, person.getAge());
    assertEquals("123 Main St", person.getAddress());
    assertEquals("123-456-7890", person.getPhone());
    assertEquals("alice@example.com", person.getEmail());
  }
}
