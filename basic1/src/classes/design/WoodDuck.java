package classes.design;

public class WoodDuck extends Duck {
    public WoodDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("I'm WoodDuck");
    }
}
