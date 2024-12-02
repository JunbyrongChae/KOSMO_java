package Talk1.step1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//키위톡 로그인 화면 입니다.
//로그인을 먼저 해야 대화를 할 수 있어요.
//이벤트 소스를 지원하는 인터페이스 이름이 있다. - > ActionListener
//기능을 아직 결정할 수 없어서 즉 구현하는것은 어떤 디바이스인가에
//따라서 다르게 구현되어야 하니까 결정할 수  없다.
//actionPerformed는 추상메소드 로 정의되어 있다. 어디에 ActionListener에
public class KiwiLogin implements ActionListener {
    //선언부
    //이 변수에 담긴 닉네임을 KiwiTalk1클래스에 넘겨서 재사용합니다.
    String nickName = null;
    JFrame frame = new JFrame();
    //JPanel 속지의 배치를 동서남북중앙으로 배치해주는 BorderLayout설정함
    //setLayout()메소드가 있음
    JPanel jp_north = new JPanel();
    //JLabel은 JPanel에 West에 붙이고, JTextField는 JPanel의 Center붙임
    JLabel jlb_nickName = new JLabel("닉네임");
    JTextField jtf_nickName = new JTextField("");//North
    JPanel jp_south = new JPanel();
    JButton jbtn_login = new JButton("Login");//South
    JButton jbtn_join = new JButton("회원가입");//Center
    //디폴트 생성자는 생략할 수 있지만 굳이 여기서는 구현하여
    //외부에서 initDisplay()호출되도록 해 본다.
    //생성자는 반환타입이 없다. 반환타입이 있다면 메소드이다.
    public KiwiLogin() {
        //initDisplay();
    }
    //화면그리기 메소드 선언
    public void initDisplay(){
        jp_north.setLayout(new BorderLayout());
        jp_south.setLayout(new GridLayout(1,2));
        jp_north.add("West", jlb_nickName);
        jp_north.add("Center", jtf_nickName);
        jp_south.add(jbtn_login);
        jp_south.add(jbtn_join);
        //이벤트 소스(jbtn_login)와 이벤트 핸들러(ActionListener구현한) 클래스
        //연결해준다.
        jbtn_login.addActionListener(this);
        jtf_nickName.addActionListener(this);
        frame.add("North", jp_north);
        frame.add("South", jp_south);
        frame.setTitle("키위톡 로그인");
        frame.setSize(300, 500);
        frame.setVisible(true);
    }
    //메인 메소드
    public static void main(String[] args) {
        KiwiLogin login = new KiwiLogin();
        login.initDisplay();
    }//////// end of main
    //actionPerformed는 callback 메소드 입니다.
    //개발자가 호출하는 메소드가 아닙니다.
    //그럼 언제 호출되죠? 이벤트소스가 이벤트 발생을 느끼면 자동으로 호출해줌
    //누가 JVM이 언제 이벤트가 감지 되었을 때 개발자를 대신해서 호출해줄께
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        Object source = e.getSource();
        //로그인 버튼이 눌렸을 때 그 때 인터셉트 하여서
        //사용자가 JTextField에 입력했는지 여부를 체크
        //없으면 그 이상 진행되지 않도록 한다.
        nickName = jtf_nickName.getText();//이벤트가 발동하면 그 때담음
        //System.out.printf("%s, %s \n",command, source.toString());
        if("Login".equals(command)) {
            System.out.println(source == jbtn_login);//true, false
            System.out.println(source.equals(jbtn_login));//true, false
            if(nickName.equals("")){
                JOptionPane.showMessageDialog(frame, "닉네임을 입력하세요");
                jtf_nickName.requestFocus();
                //actionPerformed메소드 영역을 빠져 나간다.
                return;//if문에서 return을 만나면 값을 반환하는게 아니라 중단
            }
        }else if(jtf_nickName == source){
            System.out.println("사용자가 입력한 닉네임: "+jtf_nickName.getText());
            String nickName = jtf_nickName.getText();
            jtf_nickName.setText("");
            KiwiTalk kt = new KiwiTalk(nickName);
            kt.initDisplay();
            frame.dispose();
        }else if("회원가입".equals(command)){
        //}else if(command.equals("회원가입")){

        }
    }
}/////////  end of KiwiLogin
