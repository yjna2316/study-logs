package effectivejava.chatp02.item01;

// Temperature 인터페이스
interface Temperature {
  double getValue();
}

// Celsius 클래스
class Celsius implements Temperature {
  private final double value;

  public Celsius(double value) {
    this.value = value;
  }

  @Override
  public double getValue() {
    return value;
  }
}

// Fahrenheit 클래스
class Fahrenheit implements Temperature {
  private final double value;

  public Fahrenheit(double value) {
    this.value = value;
  }

  @Override
  public double getValue() {
    return value;
  }
}

// TemperatureFactory 클래스 (정적 팩터리 메서드 사용)
class TemperatureFactory {
  private TemperatureFactory() {}

  public static Temperature createTemperature(String scale, double value) {
    if ("Celsius".equalsIgnoreCase(scale)) {
      return new Celsius(value);
    } else if ("Fahrenheit".equalsIgnoreCase(scale)) {
      return new Fahrenheit(value);
    } else {
      throw new IllegalArgumentException("Unknown temperature scale: " + scale);
    }
  }
}

