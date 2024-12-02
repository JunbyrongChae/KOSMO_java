package classes.day6;
class Parent2 {
    Parent2(){
        System.out.println("Parent2");
    }
}

class Child2 extends Parent2 {
    Child2(String str){
        System.out.println("Child2");
    }
}

public class PC2 {

    public static void main(String[] args) {
        Child2 c2 = new Child2("fu");
    }
}


/*******************************************************************
 자손클래스의 생성자가 호출될 때 먼저 부모클래스의 생성자가 먼저 호출 됩니다.
 디폴트 생성자는 파라미터를 따로 정해주지 않아도 자동으로 제공됨.
 파라미터가 있는 생성자를 호출하더라도 부모의 생성자가 먼저 호출됨.
 *******************************************************************/