package effectivejava.chatp02.item01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 생성자 사용
class Color {
  private final int red;
  private final int green;
  private final int blue;

  public Color(int red, int green, int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  public int getRed() { return red; }
  public int getGreen() { return green; }
  public int getBlue() { return blue; }
}

// 정적 팩토리 메서드를 사용하는 ColorFactory 클래스
class ColorFactory {
  private final int red;
  private final int green;
  private final int blue;

  // private 생성자를 통해 외부에서 인스턴스 생성을 하지 못하도록 한다.
  private ColorFactory(int red, int green, int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  // 정적 팩토리 메서드로 특정 색상 객체 생성
  public static ColorFactory createWhite() {
    return new ColorFactory(255, 255, 255);
  }

  public static ColorFactory createBlack() {
    return new ColorFactory(0, 0, 0);
  }

  public int getRed() { return red; }
  public int getGreen() { return green; }
  public int getBlue() { return blue; }
}


public class ColorTest {

  @Test
  public void publicConstructor() {
    // public 생성자를 사용하는 경우
    Color whiteColor = new Color(255, 255, 255);
    Color blackColor = new Color(0, 0, 0);

    assertEquals(255, whiteColor.getRed());
    assertEquals(0, blackColor.getRed());
  }

  @Test
  public void testStaticFactoryMethodUsage() {
    // 정적 팩토리 메서드를 사용하는 경우
    ColorFactory whiteColor = ColorFactory.createWhite();
    ColorFactory blackColor = ColorFactory.createBlack();

    assertEquals(255, whiteColor.getRed());
    assertEquals(0, blackColor.getRed());
  }
}
