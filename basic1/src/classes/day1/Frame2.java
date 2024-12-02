package classes.day1;

import javax.swing.*;

public class Frame2 {
    //멤버변수
    JFrame frame;

    //생성자
    public Frame2(){//파라미터가 빈 생성자는 디폴트 생성자
        //디폴트 없는경우 JVM이 대신 주입해줌
        //파라미터가진 생성자가 하나라도 있다면 제공안됨
        //선언과 생성을 분리한다(굳이...)
        frame = new JFrame("JFrame2");
        //setTitle아니어도 설정 가능
        ///같은 이름 생성자 여러개 생성가능 (오버로딩)
        ///파라 갯수 다르거나 꼬는 타입이 다르면 다른생성자로 인지함
        initDisplay();
    }
    public Frame2(String title){
        //생성자 호출시 파라로 복사된 문자열이 생성자 호출할 때 전달됨
        frame = new JFrame(title);
        initDisplay();
    }

    //initDisplay
    public void initDisplay(){
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Frame2 f2 = new Frame2();
        Frame2 f22 = new Frame2("JFrame22");
    }

    //여러개의 생성자가 있을 때 각각의 생성자를 호출해 보기

}///////////// end of class
