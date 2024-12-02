package Talk.step1;

import javax.swing.*;

public class KiTalk extends JFrame {
    //선언부
    String insertId=null;
    JButton sendbut = new JButton("Send");
    JButton exitbut = new JButton("X");
    JTextField msgField = new JTextField();
    JTextField chatField = new JTextField();

    public KiTalk(){}
    //디폴트 생성자는 선언이 안돼있으면 JVM이 대신 선언해줌
    public KiTalk(String insertId){
        System.out.println(insertId);//지변
        this.insertId = insertId;
        System.out.println(this.insertId);//멤버변수(깊복)
    }

    //화면처리부
    public void talkDisplay(){
        System.out.println("KiTalk의 talkDisplay호출 성공");
        //this.setLayout();
        this.setLayout(null);
        this.add(msgField);
        this.add(sendbut);
        this.add(exitbut);
        this.add(chatField);

        msgField.setBounds(0,500,400,50);
        sendbut.setBounds(400,500,50,50);
        chatField.setBounds(0,50,450,500);
        exitbut.setBounds(450,40,10,10);

        this.setTitle(insertId+"의 KiTalk");
        this.setSize(450,550);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //메인 생략 가능-KiLogin에서 호출할거니까.
    public static void main(String[] args) {
    }
}
