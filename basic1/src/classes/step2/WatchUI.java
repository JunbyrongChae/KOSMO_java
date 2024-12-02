package classes.step2;

import javax.swing.*;
import java.awt.*;

public class WatchUI extends JFrame {
    JLabel jlb_time = new JLabel("현재시간",JLabel.CENTER);
    Font font = new Font("온글잎 의청수 시우체",Font.BOLD,100);

    public WatchUI() {
        initDisplay();
    }
    public void initDisplay() {


        this.setSize(400,300);
        this.add(jlb_time);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        jlb_time.setFont(font);

        ///아래코드 리뷰하기
        //파라미터에 this와 다른클래스를 사용하는 경우 구분하기
        TimeClient1 tc = new TimeClient1(jlb_time);
        tc.start();
    }


    public static void main(String[] args) {
        new WatchUI();
    }
}

