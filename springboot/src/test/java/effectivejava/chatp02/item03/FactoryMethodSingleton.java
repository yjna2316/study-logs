package effectivejava.chatp02.item03;

public class FactoryMethodSingleton {

  // 클래스가 로드될 때 인스턴스를 생성하여, 그 이후에는 동일한 인스턴스를 반환하도록 한다.
  private static final FactoryMethodSingleton INSTANCE = new FactoryMethodSingleton();

  // private 생성자, 외부에서 직접 인스턴스를 생성하지 못하도록 차단
  private FactoryMethodSingleton() {}

  // public static 메서드를 통해 어디서든 접근 가능
  public static FactoryMethodSingleton getInstance() {
    return INSTANCE;
  }

  public void doSomething() {
    System.out.println("this is FactoryMethodSingleton");
  }
}
