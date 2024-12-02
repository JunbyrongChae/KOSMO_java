package day2;
//java.lang패키지만 import문을 생략 가능
//나머지 패키지는 import문을 사용하기.(추천)
import javax.swing.JFrame;

import javax.swing.*;

//1단계 - main메소드 안에서만 코딩 전개.
//2단계 - main메소드 안에 코딩을 가급적 줄여나가기.
public class JFrame1 {
    public static void main(String[] args) {
        //java.lang패키지 안에 있느느 클래스는 JVM이 찾을 수 잇음
        //        //그러나 그 밖에 클래스는 패키지이름을 추가해 줘야 함.
        //        //클래스의 구성요소는 변수선언과 메소드 선언이 가능합니다.
        //이미JVM이 구현해 놓은 많은 클래스가 있어요
        //클래스를 호출할 수 있다.
        JFrame jFrame = new JFrame();
        String title = "전자계산기";
        title = "KakaoTalk";//재정의
        //재정의를 할 수 있다.
        //변수 -(조건문,반복문)- 배열(닽은 타입만 담을 수 있다-장애) - (List, Map, Set)자료구조(여러개 기억, 다른타입도 기억)
        //->Session, Cookie(웹,앱,하이브리드-공유, 유지-시간조절 가능, 상태값 관리)
        //변수에 한번에 하나만 기억 - 변수 장애
        jFrame.setTitle(title);
        jFrame.setSize(500,300);
        jFrame.setVisible(true);//true이면 화면에 보여줘, false면 메모리에는 로딩되지만 보여주지마.
    }
}
/*
코드의 양은 늘어나더라도 코드의 복잡도는 늘지 않게.
반복되는 코드는 줄여서 개선하기.
 */