package classes.levelup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoticeSubUI extends JFrame implements ActionListener {
    JPanel jp_south = new JPanel();
    JPanel jp_center = new JPanel();
    JButton btn_save = new JButton("저장");
    JButton btn_close = new JButton("닫기");


    public NoticeSubUI() {
    } ////////// end of NoticeSub 생성자

    public void initDisplay() {
        this.setLayout(new BorderLayout());
        this.setSize(400, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        this.add(jp_center, BorderLayout.CENTER);
        jp_center.setBackground(new Color(227, 179, 64));

        this.add(jp_south, BorderLayout.SOUTH);
        jp_south.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        jp_south.add(btn_save);
        jp_south.add(btn_close);

        btn_save.addActionListener(this);
        btn_close.addActionListener(this);
    } ////////// end of initDisplay

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        if (btn == btn_save) {
            int result = JOptionPane.showConfirmDialog(//버튼에 따라 정수값이 저장
                this,
                "저장하시겠습니까?",
                "저장",
                JOptionPane.YES_NO_OPTION
            );

            if (result == JOptionPane.YES_OPTION) {//정수값이 0일때
                // 즉 Yes를 선택했을 때 실행할 코드 작성
                System.out.println("저장되었습니다."); // 실제 저장 로직 대신 간단한 출력문 사용
                this.dispose();
            }
        } else if (btn == btn_close) {
            int result = JOptionPane.showConfirmDialog(
                this,
                "종료하시겠습니까?",
                "종료",
                JOptionPane.YES_NO_OPTION
            );

            if (result == JOptionPane.YES_OPTION) {
                // Yes를 선택했을 때 실행할 코드 작성
                System.out.println("종료되었습니다."); // 실제 종료 로직 대신 간단한 출력문 사용
                this.dispose();
            }
        }
    }
} ///////////// end of NoticeSub class