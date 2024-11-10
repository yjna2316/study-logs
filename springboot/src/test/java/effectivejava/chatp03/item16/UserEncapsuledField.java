package effectivejava.chatp03.item16;

public class UserEncapsuledField {
  private final String name;
  private final int age;

  public UserEncapsuledField(String name, int age) {
    this.name = name;
    if (age < 0) {
      throw new IllegalArgumentException("Age cannot be negative");
    }
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }
}
