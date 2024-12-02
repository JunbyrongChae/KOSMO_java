package classes.day6;
/*
인스턴스화에서 선언부와 생성부의 이름이 다른 경우에대해 알아본다.
1. 부모에는 없는데 자손에는 있는 메소드를 추가. method_n()
2. 테스트 시나리오
    -Parent p1 = new Parent(); - 기본형
    -Parent p2 = new Child(); - 부모타입과 생성자 이름이 다른 경우 (다형성이 가능함)
    -자바의 특징 : 재사용성, 이식성

Q. p1.method_n(); ( O / X ) //X
   p2.method_n(); ( O / X ) //X
-point! : 부모타입에는 없는 메소드를 과연 자손타입에서 호출 할 수 있나?
          자손 타입으로 부모에도 있는 메소드를 호출하면 과연 어떤 메소드가 호출 될까?

 */
class Parent4 {
    void method(){
        System.out.println("parent4method");
    }
}

class Child4 extends Parent4 {
    void method(){
        System.out.println("Child4method");
    }
    void method_n(){
        System.out.println("Child4method_**n**");
    }

}

public class PC4 {
    public static void main(String[] args) {
        Parent4 p1 = new Parent4();
        // p1.method_n(); - 부모타입으로 선언된 변수로 자손클래스의 메소드호출은 불가능
        Child4 c = new Child4();
        c.method_n();
        //상속 받을 때 자손클래스를 상속 받는 것이 더 누릴 수 있는 변수와 메소드가 많다
        Parent4 p2 = new Child4();
        p2.method();
        //p1.method_n(); - 실제로 생성된 클래스는 Child4이지만 타입이 부모타입이면 자손에 선언된 메소드는 호출 불가.
        //p2.method_n(); - 선언부 타입과 생성부 타입이 다른 경우 다형성을 누릴 수 있다.
        //객체생성시 주의사항 - 사이드이펙트(Spring같은 프레임워크에서는 대신 해줌)를 피하는 코드작성

        //API에 대한 활용 능력을 키운다.

    }
}


/*******************************************************************
 - 자손클래스의 생성자가 호출될 때 먼저 부모클래스의 생성자가 먼저 호출 됩니다.
 - 디폴트 생성자는 파라미터를 따로 정해주지 않아도 자동으로 제공됨.
 - 파라미터가 있는 생성자를 호출하더라도 부모의 생성자가 먼저 호출됨.

 - 부모클래스에 파라미터생성자가 있어도 디폴트생성자가 출력됨

 - 오버라이딩시에도 new Child3가 선언 되어 Child3의 메소드가 호출됨
    => 자바에서는 생성부의 이름으로 객체가 생성되므로 parent가 Parent3타입이라도 자손의 메소드가 호출
    => 이 때 부모의 메소드는 쉐도우메소드가 됨.

 -
 *******************************************************************/