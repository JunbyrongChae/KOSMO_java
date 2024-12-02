package classes.levelup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NoticeMain extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    JButton btn_ins = new JButton("입력");
    JButton btn_upd = new JButton("수정");
    JButton btn_det = new JButton("상세보기");
    JButton btn_del = new JButton("삭제");
    //NoticeSub ns = new NoticeSub();
    NoticeSubUI ns = new NoticeSubUI();

    public void initDisplay(){
        this.setTitle("공지사항-Main");
        this.setLayout(new BorderLayout());

        panel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        panel.add(btn_ins);
        panel.add(btn_upd);
        panel.add(btn_det);
        panel.add(btn_del);
        this.add("North",panel);

        this.setSize(600,500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn_ins.addActionListener(this);
        btn_upd.addActionListener(this);
        btn_det.addActionListener(this);
        btn_del.addActionListener(this);
        //콜백메소드의 파라미터 자리에 오는 클래스는 절대 개발자가 인스턴스하지 않습니다.
    }/////////////// end of initDisplay

    public static void main(String[] args) {
        NoticeMain nm = new NoticeMain();
        nm.initDisplay();
    }/////////////// end of main

    @Override
    public void actionPerformed(ActionEvent e) {
        //call-back메서드에서 e = new ActionEvent(); 안됨
        JButton btn = (JButton)e.getSource();
        //NoticeSub ns = new NoticeSub(); 버튼 누를 때 마다 인스턴스화
        if (btn==btn_ins){
            ns.setTitle("NoticeSub - "+btn.getText());
            ns.initDisplay();
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if (btn==btn_upd) {
            ns.setTitle("NoticeSub - "+btn.getText());
            ns.initDisplay();
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if (btn==btn_det) {
            ns.setTitle("NoticeSub - "+btn.getText());
            ns.initDisplay();
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if (btn==btn_del) {
            ns.setTitle("NoticeSub - "+btn.getText());
            ns.initDisplay();
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }/////////// end of if
    }/////////////// end of actionPerformed
}/////////////////// end of NoticeMain
