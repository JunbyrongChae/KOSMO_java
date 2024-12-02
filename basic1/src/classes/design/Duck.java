package classes.design;

public abstract class Duck {
    public FlyBehavior flyBehavior;
    public QuackBehavior quackBehavior;
    public Duck(){
        System.out.println("Duck constructor");
    }

    //왜 인스턴스변수를 두 번 연속해서 써야했나?
    //구현체 클래스인 MallardDuck, RubberDuck, WoodDuck은 fly()를 직접 호출하지 않도록 변경해 본다.
    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }
    public abstract void display();
    public void swimming(){
        System.out.println("I'm Floating");
    }
}

/***************

 #추상클래스 와 인터페이스
 - 둘 다 단독 인스턴스화 불가
 -

 ***************/