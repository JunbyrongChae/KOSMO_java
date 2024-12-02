package basic.collection;

import javax.swing.*;

class P1 extends Object{
    JButton btn = new JButton("Click me");
    @Override
    public String toString(){
        return "P1";
    }
}
public class ToString1 {
    public static void main(String[] args) {
        P1 p1 = new P1();
        System.out.println(p1);
        System.out.println(p1.toString());
        System.out.println(p1.btn);
    }
}
