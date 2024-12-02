package classes.day6;
class Parent3 {
    Parent3(){
        System.out.println("Parent3");
    }

    Parent3(String str){
        System.out.println("Parent3String");
    }
    void method(){
        System.out.println("parent3method");
    }
}

class Child3 extends Parent3 {
    Child3(String str){
        System.out.println("Child3String");
    }
    void method(){
        System.out.println("Child3method");
    }
}

public class PC3 {
    public static void main(String[] args) {
        Parent3 p1 = new Parent3();
        p1 = new Child3("P3");
        p1.method();
        Parent3 parent = new Child3("borring");
        parent.method();
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