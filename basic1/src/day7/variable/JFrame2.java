package day7.variable;

import javax.swing.*;
class Jframe{}
//JFrame2클래스는 JFrame클래스를 상속받아서 만든 클래스다
//상속하면 코드를 줄일 수 있다.
public class JFrame2 extends JFrame{
    public void initDisplay(){
        this.setLayout(null);
        this.setSize(400,500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        JFrame2 f2 = new JFrame2();
        f2.initDisplay();
    }
}
