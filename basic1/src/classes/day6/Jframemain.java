package classes.day6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jframemain extends JFrame implements ActionListener {
    JDialogMain jdm = new JDialogMain(this);
    JButton btn_ins = new JButton("입 력");
    JButton btn_upd = new JButton("수 정");
    JButton btn_det = new JButton("상세보기");
    JPanel jp = new JPanel();
    public Jframemain() {
        initDisplay();
    }
    public void initDisplay(){
        jp.add(btn_ins);
        jp.add(btn_upd);
        jp.add(btn_det);
        this.add("North",jp);
        //액션리스너 추가
        btn_ins.addActionListener(this);
        btn_upd.addActionListener(this);
        btn_det.addActionListener(this);
        //기본설정
        this.setSize(500,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        jdm.jb_save.addActionListener(this);
        jdm.jb_close.addActionListener(this);
    }

    public static void main(String[] args) {
        new Jframemain();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        //입력버튼 누름
        if(obj == btn_ins){
            jdm.set(btn_ins.getText(), true, true);
        }
        //수정
        else if(obj == btn_upd){
            jdm.set(btn_upd.getText(), true, true);
        }
        //상세보기
        else if(obj == btn_det){
            jdm.set(btn_det.getText(), true, false);
        }
        //저장
        if(obj == jdm.jb_save){

        }
        //닫기
        else if (obj == jdm.jb_close){
            System.exit(0);
        }
    }
}
