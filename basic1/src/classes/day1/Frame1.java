package classes.day1;
//#대주제-인스턴스화 설득
import javax.swing.*;

//생성자 활용해보기
//생성자에서 사용자정의 메소드 호출하기
//메인메소드에서 사용자정의메소드 호출하기
///다른점,더 유용한가?
///메인메소드 없이 initDisplay는 어디서 호출?
public class Frame1 {//생성자에서 메소드 호출하기
    //멤버변수
    JFrame frame;

    //생성자
    public Frame1(){ //선언과 생성을 분리한다(굳이...)
        // initDisplay();-여기 입력하면 null상태라 안됨
        frame = new JFrame("JFrame1");//setTitle안해도 됨
        initDisplay();
    }

    //initDisplay
    public void initDisplay(){
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /*
    public void initDisplay(boolean isView){
        frame.setSize(500,500);
        frame.setVisible(isView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     */
    //38-39-15-17-18
    public static void main(String[] args) {
        Frame1 f1 = new Frame1();
    }/////////////// end of main
}/////////////////// end of class
