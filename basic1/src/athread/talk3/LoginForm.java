package athread.talk3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class LoginForm extends JFrame implements ActionListener, FocusListener {
    //선언부
    String imgPath = "C:\\workspace_java\\basic1\\src\\image\\talk\\";
    //JPanel에 쓰일 이미지 아이콘
    ImageIcon img = new ImageIcon(imgPath + "main.png");

    JLabel jl_id = new JLabel("아이디");
    JLabel jl_pw = new JLabel("비밀번호");
    JTextField jtf_id = new JTextField("아이디를 입력하세요.",20);
    JPasswordField jpf_pw = new JPasswordField("",20);
    Font font = new Font("야놀자 야체 Bold", Font.BOLD, 27);
    JButton btn_login = new JButton(new ImageIcon(imgPath + "login.png"));
    JButton btn_join = new JButton(new ImageIcon(imgPath + "confirm.png"));
    JButton btn_exit = new JButton(new ImageIcon(imgPath + "exit.png"));
    TalkDao tDao = new TalkDao();
    String nickName = null;

    //생성자
    public LoginForm() {
        System.out.println("LoginForm 디폴트 생성자");
        initDisplay();
    }

    class Mypanel extends JPanel {

        public void paintComponent(Graphics g) {
            g.drawImage(img.getImage(), 0, 0, null);
            //(0,0)위치에 임미지패널 위치
            setOpaque(false);//패널의 배경을 투명하게 설정(true)
            //super는 상위 클래스를 가르키는 수정자입니다.
            super.paintComponent(g);
            //이미지 처리는 개발자가 호출만 할 수 있고 내부적으로 처리됨
        }
    }
    //화면처리부
    public void initDisplay() {
        setContentPane(new Mypanel());
        btn_login.addActionListener(this);
        btn_join.addActionListener(this);
        btn_exit.addActionListener(this);
        jtf_id.addFocusListener(this);
        this.setLayout(null);
        //로그인 버튼 라인추가
        btn_login.setBounds(45, 300, 120, 40);
        this.add(btn_login);
        //회원가입 버튼 라인추가
        btn_join.setBounds(175, 300, 120, 40);
        this.add(btn_join);
        //아이디라벨
        jl_id.setBounds(45, 190, 80, 40);
        jl_id.setFont(font);
        this.add(jl_id);
        jtf_id.setBounds(110, 190, 185, 40);
        this.add(jtf_id);
        //비밀번호라벨
        jl_pw.setBounds(35, 240, 80, 40);
        jl_pw.setFont(font);
        this.add(jl_pw);
        jpf_pw.setBounds(110, 240, 185, 40);
        this.add(jpf_pw);

        btn_exit.setBounds(0, 0, 30, 30);
        btn_exit.addActionListener(this);
        btn_exit.setBackground(Color.RED);
        this.add(btn_exit);

        this.setTitle("Log-in");
        this.setSize(350, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    //메인메소드
    public static void main(String[] args) {
        //오늘은 메인메소드 내에서 initDisplay를 호출하지 않고
        //생성자 안에서 호출합니다. 따라서 인스턴스 변수가 필요없다.
        new LoginForm();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == btn_login) {
            if("".equals(jtf_id.getText()) || "".equals(jpf_pw.getText())) {
                JOptionPane.showConfirmDialog(
                        this,
                        "아이디와 비밀번호를 확인하세요.",
                        "Information",
                        JOptionPane.INFORMATION_MESSAGE
                );
                return;
            }
            try {
                String mem_id = jtf_id.getText();
                String mem_pw = jpf_pw.getText();
                String mem_nick = tDao.login(mem_id, mem_pw);
                if("비밀번호가 맞지 않습니다.".equals(mem_nick)) {
                    JOptionPane.showConfirmDialog(
                            this,
                            "비밀번호가 맞지 않습니다.",
                            "Information",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    jpf_pw.setText("");
                } else if("아이디가 존재하지 않습니다.".equals(mem_nick)) {
                    JOptionPane.showConfirmDialog(
                            this,
                            "아이디가 존재하지 않습니다.",
                            "Information",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    jpf_pw.setText("");
                    return;
                } else {
                    nickName = mem_nick;
                    System.out.println("서버 대화명"+nickName);
                    this.setVisible(false);
                    jtf_id.setText("");
                    jpf_pw.setText("");
                    //로그인 성공시 파라미터로 LoginForm주소번지를 넘겨서
                    //멤버변수들을 사용할 수 있도록 조치
                    //@TO_DO-this추가한 생성자 추가할 것
                    TalkClient tc = new TalkClient(this);
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        } else if (obj==btn_join) {
            System.out.println("회원가입 양식 호출");
            new MemberShipForm();
        }
        if (obj == btn_exit) {
            System.exit(0);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource()==jtf_id) {
            jtf_id.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }
}
