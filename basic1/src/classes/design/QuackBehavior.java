package classes.design;
//인터페이스가 갖는 메소드는 모두 추상메서드이다.
//그러나 추상클래스는 일반메서드도 있고 추상메서드도 있다.
//그래서 abstract 생략 할 수 없다.
//인터페이스가 추상클래스보다 더 추상적이다. - 생성자도 못갖는다.
//인터페이스는 반드시 구현체 클래스를 갖는다. - 기능처리 위해.
public interface QuackBehavior {
    public void quack();
}
