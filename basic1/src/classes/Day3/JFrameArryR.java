package classes.Day3;

import javax.swing.*;
import java.awt.*;

public class JFrameArryR extends JFrame {
    JButton[] btns = new JButton[3];
    String[] btnsName = {"button1","button2","button3"};
    public void initDisplay() {

        this.setLayout(new GridLayout(3,1));

        btns[0] = new JButton(btnsName[0]);
        btns[1] = new JButton(btnsName[1]);
        btns[2] = new JButton(btnsName[2]);

        this.add(btns[0]);
        this.add(btns[1]);
        this.add(btns[2]);


        this.setSize(500,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        JFrameArryR ja = new JFrameArryR();
        ja.initDisplay();
    }
}
