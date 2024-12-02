package day6.variable;

import javax.swing.*;
import java.awt.event.ActionListener;

public class KiSimulation {
    public static void main(String[] args) {
        KiLogin kl = new KiLogin();
        kl.frame.setTitle("외부에서 작성됨");
        kl.frame.setSize(500,500);
        kl.frame.setVisible(true);
        //ActionListener kl = new KiLogin();
        kl.initDisplay(); //자손클래스에 구현된 동일한 메소드가 부모타입에 없어서
        kl.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
