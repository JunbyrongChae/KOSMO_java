package athread.step1;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
@AllArgsConstructor
public class JoinView extends JDialog implements ActionListener {
    TalkDao tDao = new TalkDao();
    boolean isIdCheck = false; //회원가입 전에 아이디중복검사 실행 여부 - 중복아니면 true로 변경하여 가입 가능하게 반영
    JPanel	   jp_join 		  = new JPanel(null); //회원가입 도화지
    JLabel 	   jlb_name 	  = new JLabel("이름");
    JLabel 	   jlb_id 		  = new JLabel("아이디");
    JLabel 	   jlb_pw 		  = new JLabel("비밀번호");
    JLabel 	   jlb_pw2 		  = new JLabel("비밀번호확인");
    JLabel     jlb_birth 	  = new JLabel("생년월일");
    JLabel 	   jlb_phone 	  = new JLabel("전화번호");
    JLabel 	   jlb_nickName	  = new JLabel("닉네임");
    JLabel 	   jlb_idAvble	  = new JLabel("사용가능한 아이디 입니다.");
    JLabel 	   jlb_idNotAvble = new JLabel("중복된 아이디 입니다.");
    JLabel 	   jlb_title 	  = new JLabel("회원가입");//회원가입 , title 라벨
    JTextField jtf_name 	  = new JTextField(); //이름
    JTextField jtf_id 		  = new JTextField(); //아이디
    JPasswordField jtf_pw     = new JPasswordField(); //비밀번호
    JPasswordField jtf_pw2 	  = new JPasswordField(); //비밀번호 확인
    JTextField jtf_birth 	  = new JTextField(); //생년월일
    JTextField jtf_phone	  = new JTextField(); //폰번호
    JTextField jtf_nickName	  = new JTextField(); //닉네임
    JButton    jbtn_idconfirm = new JButton("중복검사"); //로그인 버튼
    JButton    jbtn_join 	  = new JButton("회원가입");//회원가입 버튼
    Font       f_join 		  = new Font("맑은 고딕",Font.PLAIN,25);
    Font	   f_label        = new Font("맑은 고딕",Font.PLAIN,12);

    public JoinView() {initDisplay();}

    public void initDisplay() {
        jbtn_idconfirm.setFocusPainted(false);
        jbtn_join.addActionListener(this);
        jbtn_idconfirm.addActionListener(this);
        //타이틀 부분
        ImageIcon bookIcon = new ImageIcon("./image/title.png");
        this.setIconImage(bookIcon.getImage());
        this.setTitle("회원가입 - [바나나톡]");
        //정보입력 부분
        jp_join.add(jtf_name);//이름
        jp_join.add(jlb_name);
        jtf_name.setBounds(95, 100, 180, 35);
        jlb_name.setBounds(57,100, 200, 35);
        jlb_name.setFont(f_label);
        jp_join.add(jtf_id);//아이디
        jp_join.add(jlb_id);
        jtf_id.setBounds(95, 145, 180, 35);
        jlb_id.setBounds(45, 145, 200, 35);
        jlb_id.setFont(f_label);
        jp_join.add(jlb_idAvble);//아이디 중복검사 결과
        jlb_idAvble.setVisible(false);
        jp_join.add(jlb_idNotAvble);
        jlb_idAvble.setBounds(95, 180, 180, 35);
        jlb_idNotAvble.setBounds(95, 180, 200, 35);
        jlb_idNotAvble.setVisible(false);
        jp_join.add(jtf_pw);//비밀번호
        jp_join.add(jlb_pw);
        jtf_pw.setBounds(95, 210, 180, 35);
        jlb_pw.setBounds(35, 210, 200, 35);
        jlb_pw.setFont(f_label);
        jp_join.add(jtf_pw2);//비밀번호확인
        jp_join.add(jlb_pw2);
        jtf_pw2.setBounds(95, 255, 180, 35);
        jlb_pw2.setBounds(10, 255, 200, 35);
        jlb_pw2.setFont(f_label);
        jp_join.add(jtf_birth);//생년월일
        jp_join.add(jlb_birth);
        jtf_birth.setBounds(95, 300, 180, 35);
        jlb_birth.setBounds(35, 300, 200, 35);
        jlb_birth.setFont(f_label);
        jp_join.add(jtf_phone);//전화번호
        jp_join.add(jlb_phone);
        jtf_phone.setBounds(95, 345, 180, 35);
        jlb_phone.setBounds(35, 345, 200, 35);
        jlb_phone.setFont(f_label);
        jp_join.add(jtf_nickName);//닉네임
        jp_join.add(jlb_nickName);
        jtf_nickName.setBounds(95, 390, 180, 35);
        jlb_nickName.setBounds(45, 390, 200, 35);

        jbtn_idconfirm.setBorderPainted(false); //아이디 중복검사 버튼 외곽 라인 없애기
        jbtn_idconfirm.setForeground(Color.WHITE); //아이디 중복검사 버튼 텍스트 색깔 (흰색)
        jbtn_idconfirm.setBackground(new Color(64,64,64)); //아이디 중복검사 버튼 색깔 넣기 (갈색)
        jbtn_idconfirm.setBounds(285, 145, 90, 35);
        jbtn_join.setBounds(42, 450, 300, 45);
        jbtn_join.setBackground(new Color(64,64,64));
        jbtn_join.setForeground(Color.white);
        jbtn_join.setBorderPainted(false); // 테두리 없애기
        jbtn_join.setFocusPainted(false); // 포커스 테두리 없애기
        jlb_title.setFont(f_join);//회원가입 라벨 붙이기
        jlb_title.setBounds(20,30,125,45);
        jp_join.add(jlb_title);//회원가입 라벨 왼쪽 상단에 붙이기
        jp_join.add(jbtn_join);//회원가입 버튼
        jp_join.add(jbtn_idconfirm);//아이디 중복검사 버튼
        jp_join.setBackground(new Color(253,220,81)); //도화지 색깔 노란색
        //JDialog, 회원가입 메인창 정의
        this.setContentPane(jp_join);
        this.setSize(400, 600);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);//창 가운데서 띄우기
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new JoinView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        String user_id = jtf_id.getText();
        String user_pw = new String(jtf_pw.getPassword());
        String name = jtf_name.getText();
        String user_pw2 = new String(jtf_pw2.getPassword());
        String birth = jtf_birth.getText();
        String phone = jtf_phone.getText();
        String nickName = jtf_nickName.getText();

        if (obj == jbtn_idconfirm) {
            System.out.println("아이디 중복검사");
            if (user_id.length() <= 0) {
                JOptionPane.showMessageDialog(this, "아이디를 입력하세요", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else if (user_id.length() > 3) {
                if (tDao.memIdCheck(user_id)) {
                    jlb_idAvble.setVisible(false);
                    jlb_idNotAvble.setVisible(true);
                    isIdCheck = false;
                } else {
                    jlb_idAvble.setVisible(true);
                    jlb_idNotAvble.setVisible(false);
                    isIdCheck = true;
                    System.out.println("사용 가능");
                }
            } else {
                jlb_idAvble.setVisible(false);
                jlb_idNotAvble.setVisible(true);
                isIdCheck = false;
                JOptionPane.showMessageDialog(this, "4자 이하의 아이디는 사용 불가입니다.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (obj == jbtn_join) {
            System.out.println("회원가입");
            if (isIdCheck) {
                if (!user_pw.equals(user_pw2)) {
                    JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.", "Info", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    System.out.println("비밀번호 확인 정상");
                    if (user_id.isEmpty() || user_pw.isEmpty() || name.isEmpty() || birth.isEmpty() || phone.isEmpty() || nickName.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "모든 정보를 입력했는지 확인해 주세요.", "Info", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JoinVO pjvo = new JoinVO(user_id, user_pw, nickName, name, birth, phone);
                        int result = tDao.memJoin(pjvo); // TalkDao를 통해 회원 정보 삽입

                        if (result == 1) {
                            JOptionPane.showMessageDialog(this, "회원가입이 완료되었습니다.", "Info", JOptionPane.INFORMATION_MESSAGE);
                            this.dispose(); // 회원가입 창 닫기
                        } else {
                            JOptionPane.showMessageDialog(this, "회원가입에 실패했습니다. 다시 시도해 주세요.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "아이디 중복검사를 진행하세요.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
