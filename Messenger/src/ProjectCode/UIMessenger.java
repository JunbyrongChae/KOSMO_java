package ProjectCode;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

//닉네임 입력창 UI
class LoginApp extends JFrame {
    public String nickname = "???????";
    JPanel jp_login = new JPanel(null);
    JTextField jtf_id = new JTextField(){
        @Override
        public void setBorder(Border border) {
        }
    };
    JPasswordField jpf_pw = new JPasswordField(){
        @Override
        public void setBorder(Border border) {
        }
    };
    JLabel jlb_join = new JLabel();
    JLabel jlb_infomissing = new JLabel();
    Font font = new Font("맑은 고딕",Font.PLAIN,12);
    JButton jbtn_login = new JButton("로그인");
    String img_path = "src\\image\\profile\\";
    ImageIcon img_logo = new ImageIcon(img_path + "default_profile.png");
    JButton jbtn_main = new JButton(img_logo);
    public LoginApp() {
        initDisplay();
    }
    public void initDisplay() {
        this.setTitle("Login");
        jbtn_main.setBorderPainted(false);//테두리 삭제
        jbtn_main.setContentAreaFilled(false);//배경삭제
        jbtn_main.setFocusPainted(false);//포커스 테두리 삭제

        jbtn_login.setBackground(new Color(65,65,65));
        jbtn_login.setForeground(Color.WHITE);
        jbtn_login.setBorderPainted(false);
        jbtn_login.setFocusPainted(false);

        jbtn_main.setBorderPainted(false);
        jbtn_main.setBackground(new Color(253,220,81));
        jp_login.setBackground(new Color(253,220,81));
        jbtn_main.setBounds(60,35,270,250);
        jtf_id.setBounds(60,300,270,35);
        jpf_pw.setBounds(60,340,270,35);
        jpf_pw.setEchoChar('●');
        jbtn_login.setBounds(60,400,270,45);

        jlb_infomissing.setText("<HTML><U>ID/PW 분실</U></HTML>");
        jlb_infomissing.setForeground(Color.BLACK);
        jlb_infomissing.setFont(font);
        jlb_infomissing.setBounds(280,500,200,20);
        jlb_join.setText("<HTML><U>회원가입</U></HTML>");
        jlb_join.setForeground(Color.BLACK);
        jlb_join.setFont(font);
        jlb_join.setBounds(30,500,150,20);

        jp_login.add(jtf_id);
        jp_login.add(jpf_pw);
        jp_login.add(jbtn_main);
        jp_login.add(jbtn_login);
        jp_login.add(jlb_infomissing);
        jp_login.add(jlb_join);

        this.setContentPane(jp_login);
        this.setSize(400, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(false);
    }
    JButton getLoginButton() {return jbtn_login;}
    JLabel getJoinLabel() {return jlb_join;}
    JLabel getInfoMissingLabel() {return jlb_infomissing;}
    JTextField getIdField() {return jtf_id;}
    JPasswordField getPwField() {return jpf_pw;}

    public void setActionListener(UICustomActionListener actionListener) {
        jbtn_login.setActionCommand("login");
        jbtn_login.addActionListener(actionListener);
        jtf_id.setActionCommand("login");
        jtf_id.addActionListener(actionListener);
        jpf_pw.setActionCommand("login");
        jpf_pw.addActionListener(actionListener);
    }
}
class JoinView extends JDialog {
    TalkDao tDao = new TalkDao();
    boolean isIdCheck = false; //회원가입 전에 아이디중복검사 실행 여부 - 중복아니면 true로 변경하여 가입 가능하게 반영
    JPanel jp_join = new JPanel(null); //회원가입 도화지
    JLabel jlb_name = new JLabel("이름");
    JLabel jlb_id = new JLabel("아이디");
    JLabel jlb_pw = new JLabel("비밀번호");
    JLabel jlb_pw2 = new JLabel("비밀번호확인");
    JLabel jlb_birth = new JLabel("생년월일");
    JLabel jlb_phone = new JLabel("전화번호");
    JLabel jlb_nickName = new JLabel("닉네임");
    JLabel jlb_idAvble = new JLabel("사용가능한 아이디 입니다.");
    JLabel jlb_idNotAvble = new JLabel("중복된 아이디 입니다.");
    JLabel jlb_title = new JLabel("회원가입"); //회원가입 , title 라벨
    JTextField jtf_name = new JTextField(); //이름
    JTextField jtf_id = new JTextField(); //아이디
    JPasswordField jpf_pw = new JPasswordField(); //비밀번호
    JPasswordField jpf_pw2 = new JPasswordField(); //비밀번호 확인
    JTextField jtf_birth = new JTextField(); //생년월일
    JTextField jtf_phone = new JTextField(); //폰번호
    JTextField jtf_nickName = new JTextField(); //닉네임
    JButton jbtn_idconfirm = new JButton("중복검사"); //로그인 버튼
    JButton jbtn_join = new JButton("회원가입"); //회원가입 버튼
    Font f_join = new Font("맑은 고딕", Font.PLAIN, 25);
    Font f_label = new Font("맑은 고딕", Font.PLAIN, 12);

    public JoinView() {
        initDisplay();
    }

    void initDisplay() {
        jbtn_idconfirm.setFocusPainted(false);
        // 타이틀 부분
        ImageIcon bookIcon = new ImageIcon("./image/title.png");
        this.setIconImage(bookIcon.getImage());
        this.setTitle("회원가입");
        // 정보입력 부분
        jp_join.add(jtf_name); //이름
        jp_join.add(jlb_name);
        jtf_name.setBounds(95, 100, 180, 35);
        jlb_name.setBounds(57, 100, 200, 35);
        jlb_name.setFont(f_label);
        jp_join.add(jtf_id); //아이디
        jp_join.add(jlb_id);
        jtf_id.setBounds(95, 145, 180, 35);
        jlb_id.setBounds(45, 145, 200, 35);
        jlb_id.setFont(f_label);
        jp_join.add(jlb_idAvble); //아이디 중복검사 결과
        jlb_idAvble.setVisible(false);
        jp_join.add(jlb_idNotAvble);
        jlb_idAvble.setBounds(95, 180, 180, 35);
        jlb_idNotAvble.setBounds(95, 180, 200, 35);
        jlb_idNotAvble.setVisible(false);
        jp_join.add(jpf_pw); //비밀번호
        jp_join.add(jlb_pw);
        jpf_pw.setBounds(95, 210, 180, 35);
        jlb_pw.setBounds(35, 210, 200, 35);
        jlb_pw.setFont(f_label);
        jp_join.add(jpf_pw2); //비밀번호확인
        jp_join.add(jlb_pw2);
        jpf_pw2.setBounds(95, 255, 180, 35);
        jlb_pw2.setBounds(10, 255, 200, 35);
        jlb_pw2.setFont(f_label);
        jp_join.add(jtf_birth); //생년월일
        jp_join.add(jlb_birth);
        jtf_birth.setBounds(95, 300, 180, 35);
        jlb_birth.setBounds(35, 300, 200, 35);
        jlb_birth.setFont(f_label);
        jp_join.add(jtf_phone); //전화번호
        jp_join.add(jlb_phone);
        jtf_phone.setBounds(95, 345, 180, 35);
        jlb_phone.setBounds(35, 345, 200, 35);
        jlb_phone.setFont(f_label);
        jp_join.add(jtf_nickName); //닉네임
        jp_join.add(jlb_nickName);
        jtf_nickName.setBounds(95, 390, 180, 35);
        jlb_nickName.setBounds(45, 390, 200, 35);

        jbtn_idconfirm.setBorderPainted(false); //아이디 중복검사 버튼 외곽 라인 없애기
        jbtn_idconfirm.setForeground(Color.WHITE); //아이디 중복검사 버튼 텍스트 색깔 (흰색)
        jbtn_idconfirm.setBackground(new Color(64, 64, 64)); //아이디 중복검사 버튼 색깔 넣기 (갈색)
        jbtn_idconfirm.setBounds(285, 145, 90, 35);
        jbtn_join.setBounds(42, 450, 300, 45);
        jbtn_join.setBackground(new Color(64, 64, 64));
        jbtn_join.setForeground(Color.white);
        jbtn_join.setBorderPainted(false); // 테두리 없애기
        jbtn_join.setFocusPainted(false); // 포커스 테두리 없애기
        jlb_title.setFont(f_join); //회원가입 라벨 붙이기
        jlb_title.setBounds(20, 30, 125, 45);
        jp_join.add(jlb_title); //회원가입 라벨 왼쪽 상단에 붙이기
        jp_join.add(jbtn_join); //회원가입 버튼
        jp_join.add(jbtn_idconfirm); //아이디 중복검사 버튼
        jp_join.setBackground(new Color(253, 220, 81)); //도화지 색깔 노란색
        // JDialog, 회원가입 메인창 정의
        this.setContentPane(jp_join);
        this.setSize(400, 600);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null); //창 가운데서 띄우기
        this.setVisible(false);
    }
    JTextField getIdField() {return jtf_id;}
    JPasswordField getPwField() {return jpf_pw;}
    JPasswordField getPw2Field() {return jpf_pw2;}
    JTextField getNameField() {return jtf_name;}
    JTextField getBirthField() {return jtf_birth;}
    JTextField getPhoneField() {return jtf_phone;}
    JTextField getNickNameField() {return jtf_nickName;}

    public void setActionListener(UICustomActionListener actionListener) {
        jbtn_join.setActionCommand("sign_up");
        jbtn_join.addActionListener(actionListener);
        jbtn_idconfirm.setActionCommand("idconfirm");
        jbtn_idconfirm.addActionListener(actionListener);
    }

}
//채팅메인화면 UI
public class UIMessenger extends JFrame {
    JTextField msg_insert;
    JTextArea msg_display;
    JButton send_button;
    JButton create_room;
    DefaultListModel<String> listModel_room = new DefaultListModel<>();
    JList<String> list_room = new JList<>(listModel_room);
    JScrollPane msgScrollPane = new JScrollPane(msg_display);
    JScrollPane roomScrollPane = new JScrollPane(list_room);
    JLabel room_Label;
    Font font = new Font("netmarble Medium", Font.PLAIN, 15);
    String imagePath = "src\\image\\";


    public UIMessenger() {
        setSize(715, 535);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        //크기고정
        setResizable(false);

        msg_insert = new JTextField();
        msg_display = new JTextArea();
        send_button = new JButton(new ImageIcon(imagePath + "sendB.png"));
        create_room = new JButton(new ImageIcon(imagePath + "create_roomB.png"));
        msgScrollPane = new JScrollPane(msg_display);
        roomScrollPane = new JScrollPane(list_room);
        room_Label = new JLabel("   채팅방 목록");
        //수정불가
        msg_display.setEditable(false);
        //폰트설정
        send_button.setFont(font);
        msg_insert.setFont(font);
        msg_display.setFont(font);
        list_room.setFont(font);
        room_Label.setFont(font);
        //배경색
        msg_display.setBackground(new Color(225, 227, 255));
        list_room.setBackground(new Color(183, 255, 249, 255));
        send_button.setBackground(new Color(183, 183, 183, 255));
        room_Label.setBackground(new Color(255, 183, 183, 255));
        //스크롤
        msgScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        roomScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        //위치
        msgScrollPane.setBounds(1, 0, 530, 457);
        room_Label.setBounds(530, 0, 172, 40);
        roomScrollPane.setBounds(530, 40, 172, 417);
        msg_insert.setBounds(1, 457, 445, 40);
        send_button.setBounds(445, 457, 85, 40);
        create_room.setBounds(530, 457, 172, 40);
        //요소삽입
        add(msg_insert);
        add(send_button);
        add(create_room);
        add(msgScrollPane);
        add(roomScrollPane);
        add(room_Label);
    }

    public JTextField getMsgInsertField() {return msg_insert;}
    public JTextArea getMsgDisplay() {return msg_display;}

    public void setActionListener(UICustomActionListener actionListener) {
        send_button.setActionCommand("send_message");
        send_button.addActionListener(actionListener);
        create_room.setActionCommand("create_room");
        create_room.addActionListener(actionListener);
        msg_insert.setActionCommand("send_message");
        msg_insert.addActionListener(actionListener);
        list_room.addMouseListener(actionListener);
    }


    // 메세지를 창에 업데이트
    public void displayMsg(String inMsg) {
        msg_display.append(" " + inMsg + "\n");
        msg_display.setCaretPosition(msg_display.getDocument().getLength());
    }

    // 그룹 목록 List 업데이트
    public void updateRoomList(String[] rooms) {
        listModel_room.clear();
        for (String room : rooms) {
            listModel_room.addElement(room);
        }
    }
    public JList<String> getEnterRoom() {return list_room;}
}