package classes.design;

public class MallardDuck extends Duck{
    public MallardDuck() {
        //선언부 != 생성부
        //호출하는 메서드는 Fly()메서드로 동일
        //fly메서드를 모두 호둘 할 수 있지만 mallardDuck만 I'm Flying출력
        //어디타입으로 날고있는지 / 날지 못하는지 구별되는 걸까?
        //구현체클래스를 작성할 때 값이 결정됨
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();

    }
    @Override
    public void display() {
        System.out.println("I'm MallardDuck");
    }
}
