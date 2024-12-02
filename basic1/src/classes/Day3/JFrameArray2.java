package classes.Day3;

import javax.swing.*;
import java.awt.*;

public class JFrameArray2 extends JFrame {
    JButton[] btns = new JButton[3];
    String[] btnsName = {"North", "Center", "South"};
    public void initDisplay() {
        this.setLayout(new GridLayout(3,1));

        for (int i = 0; i < btns.length; i++) {
           btns[i] = new JButton(btnsName[i]);
           this.add(btns[i]);
        }

        this.setSize(500,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
    JFrameArray2 ja = new JFrameArray2();
    ja.initDisplay();
    }
}
