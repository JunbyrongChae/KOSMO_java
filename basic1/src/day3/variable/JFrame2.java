package day3.variable;

import javax.swing.*;
import java.awt.*;

public class JFrame2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();//인스턴스화
        JLabel label = new JLabel("Login");
        Font f = new Font("궁서체",Font.BOLD,35);
        label.setForeground(Color.BLUE);
        label.setFont(f);
        //인스턴스화 하면 heep메모리에 상주
        //아래 정보를 호출
        frame.setSize(300,300);//int만 입력하는 타입
        frame.add("North",label);
        frame.setVisible(true);//창보이기(JFrame필수), false인경우-백그라운드 실행.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
