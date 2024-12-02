package Talk1.step1;

import javax.swing.*;

public class KiwiTalk {
    //선언부
    String nickName=null;
    JFrame frame = new JFrame();
    public KiwiTalk(){}
    public KiwiTalk(String nickName){//nickName=apple
        System.out.println(nickName);//지변 - apple
        this.nickName = nickName;//kiwi
        System.out.println(this.nickName);//멤버변수 -null
    }
    //화면 처리부
    public void initDisplay(){
        System.out.println("Kiwi Talk1의 initDisplay호출 성공");
        frame.setTitle(nickName+"님의 대화창");//멤버변수 - kiwi
        frame.setSize(700, 400);
        frame.setVisible(true);
    }
    //메인메소드는 없어도 괜찮아 - 왜냐면 KiwiLogin에서
    //로그인 버튼을 누르면 그 때 화면 처리부 메소드 호출할거야
}
