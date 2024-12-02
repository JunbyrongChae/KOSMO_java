package day9;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoticeMain extends JFrame implements ActionListener {
    //선언부-인스턴스화,this(NoticeMain과 JFrame도 포함)사용
    NoticeDialog nd = new NoticeDialog(this);

    //생성자 - 이 클래스의 main()이 있고 멤버에서 NoticeDialog를 인스턴스화 하므로
    //NoticeDialog생성자가 활용이된다.
    //NoticeMain에서 NoticeDialog클래스를 인스턴스화 하기 때문
    //양쪽 클래스 모두가 서로를 필요로 하더라도 순환구조가 아닌 한쪽에서만
    //인스턴스화를 하고 생성자 파라미터에 NoticeMain을 넣어서 원본이 전달되도록 한다.
    //NoticeDialog에서는 절대로 null로 초기화 항 뒤 생성자의 파라미터(this로 넘어온)로 받은 원본을 초기화 하여 사용해본다.(원본을 컨트롤)
    public NoticeMain() {    }
    //화면처리부
    public void initDisplay() {//웹어플리케이션이라면 html,ReactJS,Vue.JS,Angular.JS
        this.setSize(500,600);//브라우저 인터프리터역할(JVM)
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
