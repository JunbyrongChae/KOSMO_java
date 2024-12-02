package classes.design;
//구현체 클래스에 메서드 이름을 직접 모르더라도 해당 메서드를 호출할 수 있다.
//클래스간의 결합도를 낮추는 코드를 작성해 본다.
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak!Squeak!");
    }
}
