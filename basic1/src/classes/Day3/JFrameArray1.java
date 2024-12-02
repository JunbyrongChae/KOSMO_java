package classes.Day3;

import javax.swing.*;

public class JFrameArray1 extends JFrame {
    JButton[] btns = new JButton[3];
    public void initDisplay() {

        btns[0] = new JButton("North");
        btns[1] = new JButton("Center");
        btns[2] = new JButton("South");

        this.add("North",btns[0]);
        this.add("Center",btns[1]);
        this.add("South",btns[2]);

        this.setSize(500,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
    JFrameArray1 ja = new JFrameArray1();
    ja.initDisplay();
    }
}
