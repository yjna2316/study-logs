package effectivejava.chatp02.item02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonWithBuilder {
  private final String name;
  private final int age;
  private final String address;
  private final String phone;
  private final String email;

  private PersonWithBuilder(PersonBuilder builder) {
    this.name = builder.name;
    this.age = builder.age;
    this.address = builder.address;
    this.phone = builder.phone;
    this.email = builder.email;
  }

  public static class PersonBuilder {

    private final String name;    // 필수값
    private final int age;        // 필수값
    private String address = "";  // 기본값
    private String phone = "";    // 기본값
    private String email = "";    // 기본값

    public PersonBuilder(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public PersonBuilder address(String address) {
      this.address = address;
      return this;
    }

    public PersonBuilder phone(String phone) {
      this.phone = phone;
      return this;
    }

    public PersonBuilder email(String email) {
      this.email = email;
      return this;
    }

    public PersonWithBuilder build() {
      return new PersonWithBuilder(this);
    }
  }

  // getter 메서드
  public String getName() { return name; }
  public int getAge() { return age; }
  public String getAddress() { return address; }
  public String getPhone() { return phone; }
  public String getEmail() { return email; }
}

public class PersonBuilderTest {
  @Test
  public void createPersonWithBuilder() {
    PersonWithBuilder person = new PersonWithBuilder.PersonBuilder("Alice", 30)
      .address("123 Main St")
      .phone("123-456-7890")
      .email("alice@example.com")
      .build();

    assertEquals("Alice", person.getName());
    assertEquals(30, person.getAge());
    assertEquals("123 Main St", person.getAddress());
    assertEquals("123-456-7890", person.getPhone());
    assertEquals("alice@example.com", person.getEmail());
  }

  @Test
  public void createPersonWithRequiredFieldsOnly() {
    // 선택 매개변수 없이 필수 매개변수만으로 객체 생성
    PersonWithBuilder person = new PersonWithBuilder.PersonBuilder("Bob", 40).build();

    assertEquals("Bob", person.getName());
    assertEquals(40, person.getAge());
    assertEquals("", person.getAddress()); // 기본값
    assertEquals("", person.getPhone());   // 기본값
    assertEquals("", person.getEmail());   // 기본값
  }
}
