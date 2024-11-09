package effectivejava.chatp02.item03;

public enum EnumSingleton {
  INSTANCE;

  public void doSomething() {
    System.out.println("this is EnumSingleton");
  }
}
