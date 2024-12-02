package Quiz;

import javax.swing.*;

public class JFrame1 extends JFrame {
    JFrame jf = new JFrame();
    JFrame1(){
        initDisplay();
    }
    public void initDisplay() {
        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        System.out.println(this);
        System.out.println(jf);
    }
    public static void main(String[] args) {
        new JFrame1();
    }
}
