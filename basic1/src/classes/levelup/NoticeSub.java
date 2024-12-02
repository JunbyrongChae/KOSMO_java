package classes.levelup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.YES_NO_OPTION;

public class NoticeSub extends JFrame implements ActionListener {
    JPanel panelS = new JPanel();
    JPanel panelC = new JPanel();
    JButton btn_save = new JButton("저장");
    JButton btn_close = new JButton("닫기");


    public NoticeSub(){

    }///////// end of NoticeSub 생성자

    public void initDisplay(){
        this.setLayout(new BorderLayout());
        this.setSize(400,500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        this.add(panelC,BorderLayout.CENTER);
        panelC.setBackground(new Color(227, 179, 64));

        this.add(panelS,BorderLayout.SOUTH);
        panelS.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        panelS.add(btn_save);
        panelS.add(btn_close);

        btn_save.addActionListener(this);
        btn_close.addActionListener(this);


    }///////// end of initDisplay

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton)e.getSource();
        if (btn==btn_save){
        JOptionPane.showConfirmDialog(this,"저장하시겠습니까?","저장",JOptionPane.YES_NO_OPTION);
        this.dispose();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }else if(btn==btn_close){
            JOptionPane.showConfirmDialog(this,"종료하시겠습니까?","종료",JOptionPane.YES_NO_OPTION);
            this.dispose();
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }

    }
}///////////// end of NoticeSub class
