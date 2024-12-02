package classes.day1;

import javax.swing.*;

public class Frame3 {
    //멤버변수
    JFrame frame;

    //생성자
    public Frame3(){
        frame = new JFrame();
        initDisplay();
    }

    public Frame3(String title){
        frame = new JFrame(title);
        initDisplay();
    }

    //initDisplay
    public void initDisplay(){
        frame.setTitle("JFrame3");
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Frame3 f3 = new Frame3();
    }
}
