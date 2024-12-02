package day7.variable;

import javax.swing.*;

public class JFrame1 {
    JFrame frame = null;
    public void initDisplay(){
        frame = new JFrame();//독립적이라 낮은 결합도를 갖게되어 문제발생 요소가 줄어든다.
        frame.setLayout(null);
        frame.setSize(400,500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        JFrame1 f1 = new JFrame1();
        //f1.frame = new JFrame // 가독성도 낮지만 높은 결합도로 문제생길 위험요소가 늘어난다.
        f1.initDisplay();
    }
}
