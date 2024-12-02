package classes.day1;
//인스턴스화 설득
import javax.swing.*;
//Frame4는 JFrame이다.
///상속은 클래스간에 결합도를 높이는 코드이므로 권장하지 않음.
    //독립적인 코드 작성하기 - 왜냐하면 간이테스트와 통합테스트가 가능하도록.
    //주문관리와 배송관리는 관계가 있다.
    //업무상 순서는 주문관리 후 배송관리
    //
//인터페이스나 추상클래스 중심의 코드를 전개하세요
public class Frame4 extends JFrame{
    public void initDisplay(){
        this.setTitle("JFrame3");
        this.setSize(500,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
