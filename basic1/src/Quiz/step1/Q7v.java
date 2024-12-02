package Quiz.step1;
//static메서드와 메서드의 차이점
class Foo{
    static void alpha(){/*more code here*/}
    void beta(){/*more code here*/}
}
public class Q7v {
    public static void main(String[] args) {

    }
}

/*****************************************************************
Which two are true? (Choose two.)              (B, C)
A. Foo.beta() is a valid invocation of beta().
    //Foo.beta()는 beta()에서 유효한 호출이다.
    // X : beta()는 인스턴스 메서드이므로 Foo 클래스의 인스턴스를 생성한 후에만 호출
B. Foo.alpha() is a valid invocation of alpha().
    //Foo.alpha()는 alpha()메서드의 유효한 호출이다.
    //O
C. Method beta() can directly call method alpha().
    //beta()메서드는 alpha()메서드를 직접 부를수 있다.
    //O
D. Method alpha() can directly call method beta().
    //X
    //lpha()는 인스턴스 메서드 beta()를 직접 호출할 수 없다
    //static이 메서드에 사용되었을 경우 인스턴스의 생성없이 메서드를 사용할 수 있다.
    B번 처럼 alpha()메서드를 인스턴스 생성없이 클래스에서 바로 불러 사용할 수 있다.
 ********************************************************************/