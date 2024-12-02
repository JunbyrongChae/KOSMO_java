package classes.day6;
class Child1 extends Parent1 {
    Child1(){
        System.out.println("Child1");
    }
}
class Parent1 {
    Parent1(){
        System.out.println("Parent1");
    }
}


public class PC1 {

    public static void main(String[] args) {
        //Parent1 p1 = new Parent1();
        Child1 c1 = new Child1();
        //Parent1 parent = new Child1();
    }
}


/*******************************************************************
자손클래스의 생성자가 호출될 때 먼저 부모클래스의 생성자가 먼저 호출 됩니다.

 ******************************************************************/