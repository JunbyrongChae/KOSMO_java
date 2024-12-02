package classes.UI.refresh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameMain extends JFrame implements ActionListener {
    JTextArea jta = new JTextArea();
    JButton refresh = new JButton("Refresh");
    public JFrameMain(){
        initDisplay();
    }

    public void initDisplay(){
        this.setLayout(new BorderLayout());
        this.add("Center",jta);
        this.add("South",refresh);
        refresh.addActionListener(this);

        this.setTitle("JFrameMain");
        this.setSize(350,600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JFrameMain();
        //인스턴스변수 선언 안하고 생성부만 작성
        //왜냐하면 initDisplay()메소드를 호출하려고 하는건데
        //생성자 안에서 호출하는 방법으로 진행해봄

    }
    @Override
    //메소드 앞에 언옵테이션(@)오버라이드를 붙인건 부모클래스나 인터페이스나 추상클래스가
    //정의한 메소드를 재정의한 경우
    //선언부 훼손불가
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand()+",\n"+e.getSource());
        Object obj = e.getSource();
        if(obj==refresh){
            System.out.println("Refresh버튼 클릭");
            //처음 그려진 화면에서 필요없는 컴포넌트 삭제시 사용.
            Container cont = this.getContentPane();
            if(jta!=null){
                cont.remove(jta);
                cont.remove(refresh);
            }
            JPanel1 jp1 = new JPanel1();
            this.add("Center",jp1);
            cont.revalidate();//새로 랜더링
        }
    }
}
