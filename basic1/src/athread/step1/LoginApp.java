package athread.step1;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginApp extends JFrame implements ActionListener, MouseListener {
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
    KiwiClient kc = new KiwiClient(this);
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

        jbtn_login.addActionListener(this);
        jlb_join.addMouseListener(this);
        jlb_infomissing.addMouseListener(this);

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
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TalkDao tDao = new TalkDao();
        //로그인처리
        Object source = e.getSource();
        if (source == jbtn_login) {
            String id = jtf_id.getText();
            String pw = new String(jpf_pw.getPassword());

            // 로그인 검증 로직 추가
            if (id.isEmpty() || pw.isEmpty()) {
                JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 입력하세요.", "로그인 오류", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String result = tDao.login(id, pw);

            if (result != null && result.equals(id)) {
                // 로그인 성공 시
                JOptionPane.showMessageDialog(this, "로그인 성공!", "성공", JOptionPane.INFORMATION_MESSAGE);
                nickname = id; // 닉네임 설정
                System.out.println(id+"님 환영합니다.");
                // 로그인 성공 후 메인 화면으로 이동하거나 새로운 기능을 호출할 수 있음
                // 예를 들어, 메인 채팅 화면으로 이동하는 코드 추가
            } else {
                // 로그인 실패 시
                JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 잘못되었습니다.", "로그인 실패", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new LoginApp();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == jlb_join){
            JoinView jv = new JoinView();
            jv.setVisible(true);
        } else if (e.getSource()==jlb_infomissing) {
            FindIdPwView fiv = new FindIdPwView();
            fiv.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
