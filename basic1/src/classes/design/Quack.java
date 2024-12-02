package classes.design;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {//MallardDuck
        System.out.println("Quack!Quack!");
    }
}
/****************
 메서드 오버로딩과 메서드 오버라이딩
 - 전제조건 : 같은이름일때(이름다르면 고려대상 아님)
 - 오버로딩 : 파라미터의 개수나 타입이 달라야 한다.
 - 오버라이딩 : 선언부가 같아야 한다.
 - 반드시 구현체 클래스 관계일때만 따진다.
   인터페이스 타입 변수명 = new 구현체 클래스();
    -> ex) flyBehavior = new FlyWithWings();
           flyBehavior = new FlyNoWay();
   추상클래스 타입 변수명 = new 구현체 클래스();
    -> ex) Duck myDuck = new MallardDuck();
           Duck myDuck = new RubberDuck();
           Duck myDuck = new WoodDuck();
 ******************/