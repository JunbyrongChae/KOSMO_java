package day3.variable;

import javax.swing.*;
import java.awt.*;

public class JFrame1 {
    public static void main(String[] args) {
        //JFrame은 UI를 담당하는 클래스라서 UI에 대한 JVM이 정의한 내용을 갖고있다.
        JFrame frame = new JFrame();//괄호 앞 대문자가 있을경우 메소드가 아닌 생성자라고 한다.
        //원시형변수 = 값출력
        //참조형변수 = 주소번지 출력

        /*
        // 창의 제목 설정
        frame.setTitle("JFrame1");

        // 창의 크기 설정 (가로 400, 세로 300)
        frame.setSize(400, 300);

        // 레이아웃 설정 (FlowLayout으로 설정)
        frame.setLayout(new FlowLayout());

        // 창을 닫을 때 프로그램이 종료되도록 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 창을 화면에 표시
        frame.setVisible(true);
         */

        System.out.println(frame);//frame변수는 참조형 변수
        System.out.println(frame.toString());
    }/////// end of main
}/////////// end of JFrame1
