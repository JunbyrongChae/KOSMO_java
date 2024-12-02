package classes.day1;

import javax.swing.*;

class A extends JFrame {

}
class B {
    public String toString(){
        return "B class";
    }
}

public class AMain {
    public static void main(String[] args) {
        A a = new A();//JFrame상속 받음
        a.setVisible(true);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setSize(500,500);
        a.setTitle("JFrame");
        System.out.println(a);//UI클래스라서 toString()재정의됨 - 주소못봄
        B b = new B();//기본 Object클래스만 상속
        System.out.println(b);//@주소번지
    }

}
