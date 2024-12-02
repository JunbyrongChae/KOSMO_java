package classes.levelup;

import javax.swing.*;
import java.awt.*;

public class NoticeSub2 {
    JFrame frame = new JFrame();
    JPanel panelS = new JPanel();
    JPanel panelC = new JPanel();
    JButton btn_save = new JButton("저장");
    JButton btn_close = new JButton("닫기");

    public NoticeSub2() {
        initDisplay();
    }

    public void initDisplay() {
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        frame.add(panelC, BorderLayout.CENTER);
        panelC.setBackground(new Color(227, 179, 64));

        frame.add(panelS, BorderLayout.SOUTH);
        panelS.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelS.add(btn_save);
        panelS.add(btn_close);
    }

    public static void main(String[] args) {
        NoticeSub2 noticeSub2 =new NoticeSub2();
        noticeSub2.initDisplay();
    }
}
