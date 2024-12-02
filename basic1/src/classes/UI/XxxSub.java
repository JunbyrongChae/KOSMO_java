package classes.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XxxSub extends JDialog implements ActionListener {
    XxxMain xxxMain = null;
    //선언부
    JPanel jp_south = new JPanel();
    JButton btn_save = new JButton("저장");
    JButton btn_close = new JButton("닫기");

    //생성자-리턴타입 있으면 생성자 아니라 메소드취급
    public XxxSub() {
    }

    public XxxSub(XxxMain xxxMain) {
        this.xxxMain = xxxMain;
        initDisplay();
    }

    //화면처리부
    public void initDisplay() {
        this.setSize(400, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        this.add("South", jp_south);
        jp_south.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        jp_south.add(btn_save);
        jp_south.add(btn_close);

    }

    //메인메소드 쓰면 안됨
    public static void main(String[] args) {
        new XxxSub();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        if (btn == btn_save) {
            int result = JOptionPane.showConfirmDialog(
                    this,
                    "저장하시겠습니까?",
                    "저장",
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                xxxMain.xxxList();
                System.out.println("저장");
                this.dispose();
            } else if(result == JOptionPane.NO_OPTION) {
                System.out.println("저장취소");
            }
        }else if(btn == btn_close) {
            int result = JOptionPane.showConfirmDialog(
                    this,
                    "종료하시겠습니까?",
                    "종료",
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                System.out.println("종료되었습니다.");
                this.dispose();
            } else {
                System.out.println("닫기취소");
            }
        }
        //공지사항 글을 작성 후 저장을 누르면 DB에 저장
        //현재 창은 닫고 부모창의 전체조회가 처리되도록 한다.
        //왜냐하면 ㅅ로운 글이 입력되었으니까 추가된 글까지 출력
    }


}
