package day6.variable;

import javax.swing.*;

public class KiTalk {
    //선언부
    JFrame frame = new JFrame();
    String insertId=null;
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
        //frame.setLayout();
        frame.setTitle(insertId+"의 KiTalk");
        frame.setSize(450,550);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //메인 생략 가능-KiLogin에서 호출할거니까.
    public static void main(String[] args) {
    }
}
