package effectivejava.chatp02.item03;

public class StaticFieldSingleton {
  public static final StaticFieldSingleton INSTANCE = new StaticFieldSingleton();

  private StaticFieldSingleton() {}

  public void doSomething() {
    System.out.println("this is StaticFieldSingleton");
  }
}
