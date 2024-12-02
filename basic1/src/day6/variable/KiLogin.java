package day6.variable;

import Talk.step1.KiSignIn;
import Talk.step1.KiTalk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//로그인 화면
//로그인 먼저 해야 대화 가능
//이벤트 소스를 지원하는 인터페이스 이름 : ActionListener
//기능을 아직 결정 할 수 없어서 즉 구현하는게 어떤 디바이스냐에 따라서
//다르게 구현 되야하니까 결정불가.
//actionPerformed는 추상메소드로 ActionListener에
public class KiLogin implements ActionListener {
    String insertId=null;
    //선언부
    JFrame frame = new JFrame();
    JButton button = new JButton("로그인");
    JButton button2 = new JButton("회원가입");
    JTextField textField = new JTextField(30);
    JTextField textField2 = new JTextField(30);
    JLabel label = new JLabel();
    JLabel label2 = new JLabel();

    //디폴트 생성자는 생략할 수 있지만 굳이 여기서 구현하여
    //외부에서 initDisplay()호출되도록 한다.
    //생성자는 반환타입이 없다. 있다면 메소드
    public KiLogin(){
        //initDisplay();
    }

    //화면 메소드 선언
    public void initDisplay(){
        //이벤트 소스(button)와 이벤트 핸들러(ActionListener구현한) 클래스 연결해준다.
        frame.setLayout(null);
        button.addActionListener(this);
        button2.addActionListener(this);

        label.setText("Insert your ID");
        label.setForeground(Color.BLACK);
        label2.setText("Insert your Password");
        label2.setForeground(Color.BLACK);

        textField.setSize(150, 20);

        label.setBounds(35,105,300,30);
        textField.setBounds(155,110,150,20);
        label2.setBounds(20,145,300,30);
        textField2.setBounds(155,150,150,20);
        button.setBounds(175,210,100,30);
        button2.setBounds(60,210,100,30);

        frame.add(label);   // JLabel을 추가
        frame.add(textField);  // JTextField를 추가
        frame.add(label2);   // JLabel을 추가
        frame.add(textField2);  // JTextField를 추가
        frame.add(button);  // JButton을 추가
        frame.add(button2);  // JButton을 추가

        textField.addActionListener(this);
        textField2.addActionListener(this);

        frame.setVisible(true);
        frame.setTitle("KiTalk Log-in");
        frame.setSize(350,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //메인
    public static void main(String[] args) {
        KiLogin ki = new KiLogin();
        ki.initDisplay();

    }//////////////// end of main
    //actionPerformed는 callback메소드 입니다.
    //개발자가 호출하는 메소드 아님
    //이벤트소스가 이벤트발생을 감지하면 자동 호출
    //JVM이 이벤트가 감지 됐을 때 개발자를 대신해서 호출
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        Object source = e.getSource(); //주소 가져온다
        //System.out.printf("%s,%s",command,source.toString());

        if ("로그인".equals(command)) {
            insertId = textField.getText();

            if(insertId.isEmpty()){
                JOptionPane.showMessageDialog(frame,"아이디를 입력하세요.");
                textField.requestFocus();
            }
            //if문에서 return을 만나면 값을 반환하는게 아니라 중단
            //actionPerformed메소드 영역을 빠져나간다.
            else {
                System.out.println("사용자가 입력한 아이디 : "+textField.getText());
                String insertId = textField.getText();
                textField.setText("");
                Talk.step1.KiTalk kt = new KiTalk(insertId);//변수 적극적 사용
                kt.talkDisplay();
                frame.dispose();
            }
        }else if("회원가입".equals(command)){
            Talk.step1.KiSignIn ksi = new KiSignIn();
            ksi.signInDisplay();
            frame.dispose();
        }
    }
}//////////////////// end of KiLogin
