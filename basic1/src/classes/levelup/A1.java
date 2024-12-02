package classes.levelup;

import javax.swing.*;

public class A1 {
    public void methodA(JFrame frame){
        System.out.println("methodA");
        System.out.println(frame);
        frame.setTitle("JFrame1");
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        A1 a = new A1();
        JFrame frame = new JFrame();
        a.methodA(frame);

    }
}
