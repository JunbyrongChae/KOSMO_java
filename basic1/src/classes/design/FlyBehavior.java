package classes.design;
//인터페이스 사용은 클래스 사이의 결합도를 낮추어주는 방법이다.
//fly()는 특정 클래스에 종속적이지 않다.
// = 기능을 결정 할 수 없다.
// 왜냐하면 어떤 클래스에 사용할 것인지 알 수 없으니까.
public interface FlyBehavior {
    //접근 제한자 있다. 리턴타입 있다. But! 바디없다.
    //선언만 있다. - 구현이 안되어있다. 미정이다. 결정되지 않았다.
    public abstract void fly();
}
