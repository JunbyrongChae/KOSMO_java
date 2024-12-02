package classes.day1;

import javax.swing.*;

public class FrameMain extends JFrame{
    //멤버변수
    JFrame frame;

    //생성자
    public FrameMain(){ //선언과 생성을 분리한다(굳이...)
        frame = new JFrame();}

    //initDisplay
    public void initDisplay(){
        frame.setTitle("JFrame3");
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //main안에 코딩 줄이기
    //main메소드는 클래스의 entry point이다.(static[] 제외)
    //항상 가장 먼저 호출
    //main thread라고도 함
    //개발자 직접 호출불가
    public static void main(String[] args) {

    }
}
