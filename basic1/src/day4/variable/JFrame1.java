package day4.variable;

import javax.swing.*;
import java.awt.*;

public class JFrame1 {
    //선언부
    JFrame frame = null;
    JLabel label = null;
    //생성자
    public JFrame1(){
        //디폴트생성자.-파라미터가 없는 생성자.
        frame = new JFrame();
        label = new JLabel();
    }
    //화면처리부
    public void initDisplay(){
        frame.setTitle("윈도우가 제공하는 창");
        frame.setSize(500,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(label);
        label.setText("Center");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setForeground(Color.BLUE);
    }
    //메인메소드
    public static void main(String[] args) {
        JFrame1 jf = new JFrame1();//디폴트생성자 호출
        jf.initDisplay();

    }
}
