package athread.step1;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindIdPwView extends JDialog implements ActionListener {
    TalkDao tDao = new TalkDao();
    String find_id = null;
    String find_pw = null;
    String updat_pw = null;
    //JPanel jp_cardbox      = new JPanel();
    JPanel jp_idmiss      = new JPanel(); //1.첫 화면 도화지
    JPanel jp_idfind      = new JPanel(); //2.아이디 찾기 성공했을 시 도화지
    JPanel jp_pwmiss      = new JPanel(); //3.비밀번호찾기 탭 눌렀을 때 도화지
    JPanel jp_pwfind      = new JPanel(); //4.비밀번호찾기 성공했을 시 도화지
    JPanel jp_north      = new JPanel();
    JLabel jlb_idfind     = new JLabel();//2번 도화지에 붙이는 JLabel
    JLabel jlb_name      = new JLabel("이름"); //1번 도화지에 붙는 JLabel
    JLabel jlb_phone      = new JLabel("전화번호"); //1번 도화지에 붙는 JLabel
    JLabel jlb_id          = new JLabel("아이디"); //3번 도화지에 붙는 JLabel
    JLabel jlb_name2     = new JLabel("이름"); //3번 도화지에 붙는 JLabel
    JLabel jlb_pwupdate   = new JLabel("비밀번호");
    JLabel jlb_pwupdate2  = new JLabel("비밀번호확인");
    JButton jbtn_pwupdate = new JButton("비밀번호 변경");//3번 도화지에 붙이는 비밀번호 찾기 버튼 (성공시 4번 도화지로 전환)
    JButton jbtn_pwsearch = new JButton("비밀번호 찾기");//3번 도화지에 붙이는 비밀번호 찾기 버튼 (성공시 4번 도화지로 전환)
    JButton jbtn_gotopwmiss = new JButton("비밀번호찾기"); // 2번 도화지에 붙는 비밀번호 찾기 버튼(성공지 3번도화지로 전환)
    JButton jbtn_idsearch = new JButton("아이디찾기");//아이디 찾기 검색버튼 (성공지 2번도화지로 전환)
    JButton jbtn_idmiss   = new JButton("아이디찾기");//아이디 찾기 상단메뉴(JPanel-1번도화지 전환용)
    JButton jbtn_pwmiss   = new JButton("비밀번호찾기"); //비밀번호 찾기 상단메뉴(JPanel-3번도화지 전환용)
    JPasswordField jtf_pwupdate2 = new JPasswordField() {
        @Override
        public void setBorder(Border border) {
        }
    };
    JPasswordField jtf_pwupdate = new JPasswordField() {
        @Override
        public void setBorder(Border border) {
        }
    };
    JTextField jtf_name   = new JTextField() {
        @Override
        public void setBorder(Border border) {
        }
    };
    JTextField jtf_phone  = new JTextField() {
        @Override
        public void setBorder(Border border) {
        }
    };
    JTextField jtf_name2 = new JTextField() {
        @Override
        public void setBorder(Border border) {
        }
    };
    JTextField jtf_id = new JTextField() {
        @Override
        public void setBorder(Border border) {
        }
    };
    FindIdPwView infomiss  = null;
    Font f = new Font("맑은 고딕", Font.PLAIN,13);

    public FindIdPwView() {
        initDisplay();
    }

    public void initDisplay() {
        jbtn_idmiss.addActionListener(this);
        jbtn_pwmiss.addActionListener(this);
        jbtn_pwsearch.addActionListener(this);
        jbtn_gotopwmiss.addActionListener(this);
        jbtn_idsearch.addActionListener(this);
        jbtn_pwupdate.addActionListener(this);
        //상단 메뉴바의 도화지에 버튼 두 개 붙이기+버튼정의
        jbtn_pwmiss.setBorderPainted(false);
        jbtn_pwmiss.setBackground(Color.white);
        jbtn_pwmiss.setFont(f);
        jbtn_idmiss.setBorderPainted(false);
        jbtn_idmiss.setBackground(new Color(253,220,81));
        jbtn_idmiss.setFont(f);
        jp_north.add(jbtn_idmiss);
        jp_north.add(jbtn_pwmiss);

        //상단 메뉴바를 위한 도화지 붙이기
        jp_north.setLayout(new GridLayout());
        this.add("North",jp_north);

        //4번도화지에 컨텐츠 정의
        jlb_pwupdate.setBounds(40,78,80,40);
        jlb_pwupdate.setFont(f);
        jlb_pwupdate2.setBounds(15,128,80,40);
        jlb_pwupdate2.setFont(f);
        jtf_pwupdate.setBounds(100,78,250,40);
        jtf_pwupdate2.setBounds(100,128,250,40);
        jbtn_pwupdate.setBorderPainted(false);
        jbtn_pwupdate.setForeground(Color.WHITE);
        jbtn_pwupdate.setBackground(new Color(64,64,64));
        jbtn_pwupdate.setBounds(100, 193, 180, 40);
        jp_pwfind.add(jlb_pwupdate);
        jp_pwfind.add(jlb_pwupdate2);
        jp_pwfind.add(jtf_pwupdate);
        jp_pwfind.add(jtf_pwupdate2);
        jp_pwfind.add(jbtn_pwupdate);
        jp_pwfind.setLayout(new BorderLayout());

        //3번 도화지에 컨텐츠 정의
        jbtn_pwsearch.setBorderPainted(false);
        jbtn_pwsearch.setForeground(Color.WHITE);
        jbtn_pwsearch.setBackground(new Color(64,64,64));
        jbtn_pwsearch.setBounds(100, 193, 180, 40);
        jbtn_pwsearch.setFont(f);
        jp_pwmiss.add(jbtn_pwsearch);
        jlb_id.setBounds(45,128,80,40);
        jlb_id.setFont(f);
        jlb_name2.setBounds(52,78,80,40);
        jlb_name2.setFont(f);
        jp_pwmiss.add(jlb_name2);
        jp_pwmiss.add(jlb_id);
        jtf_name2.setBounds(100,78,250,40);
        jtf_id.setBounds(100,128,250,40);
        jp_pwmiss.add(jtf_id);
        jp_pwmiss.add(jtf_name2);
        jp_pwmiss.setLayout(new BorderLayout());

        //2번 도화지에 컨텐츠 정의
        jbtn_gotopwmiss.setBorderPainted(false);
        jbtn_gotopwmiss.setForeground(Color.WHITE);
        jbtn_gotopwmiss.setBackground(new Color(64,64,64));
        jbtn_gotopwmiss.setBounds(90,180,200,35);
        jlb_idfind.setBounds(95,90,300,35);
        jlb_idfind.setFont(new Font("맑은 고딕",Font.BOLD,13));
        jp_idfind.add(jbtn_gotopwmiss);
        jp_idfind.add(jlb_idfind);
        jp_idfind.setLayout(new BorderLayout());

        //1번 도화지에 컨텐츠 정의
        jlb_name.setBounds(50,50,40,40);
        jlb_name.setFont(f);
        jlb_phone.setBounds(30,100,80,40);
        jlb_phone.setFont(f);
        jp_idmiss.add(jlb_name);
        jp_idmiss.add(jlb_phone);
        jtf_name.setBounds(100,50,250,40);
        jtf_phone.setBounds(100,100,250,40);
        jp_idmiss.add(jtf_phone);
        jp_idmiss.add(jtf_name);
        jbtn_idsearch.setBorderPainted(false);
        jbtn_idsearch.setForeground(Color.WHITE);
        jbtn_idsearch.setBackground(new Color(64,64,64));
        jbtn_idsearch.setBounds(100, 165, 180, 40);
        jbtn_idsearch.setFont(f);
        jp_idmiss.add(jbtn_idsearch);
        jp_idmiss.setLayout(new BorderLayout());


        //jdl_infomiss.add("Center",jp_cardbox);
        //JDialog, 메인 프레임 정의
        jp_pwfind.setSize(400,300);
        jp_pwmiss.setSize(400,300);
        jp_idfind.setSize(400,300);
        jp_idmiss.setSize(400,300);
        this.add("Center",jp_pwfind);//4번도화지 orange
        this.add("Center",jp_pwmiss);//3번도화지 orange
        this.add("Center",jp_idfind);//2번도화지 gray
        this.add("Center",jp_idmiss);//1번도화지
        jp_pwfind.setVisible(false);
        jp_pwmiss.setVisible(false);
        jp_idfind.setVisible(false);
        jp_idmiss.setVisible(true);
        this.setTitle("아이디/비밀번호 찾기");
        this.setSize(400, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ///action
        jtf_id.setText("");
        jtf_name.setText("");
        jtf_name2.setText("");
        jtf_phone.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == jbtn_idmiss){
            jp_pwfind.setVisible(false);
            jp_pwmiss.setVisible(false);
            jp_idfind.setVisible(true);
            jp_idmiss.setVisible(false);
            jbtn_pwmiss.setBackground(Color.WHITE);
            jbtn_idmiss.setBackground(new Color(253,220,81));
        } else if (obj==jbtn_pwmiss) {
            jp_pwfind.setVisible(false);
            jp_pwmiss.setVisible(true);
            jp_idfind.setVisible(false);
            jp_idmiss.setVisible(false);
            jbtn_idmiss.setBackground(Color.WHITE);
            jbtn_pwmiss.setBackground(new Color(253,220,81));
        } else if (obj ==jbtn_gotopwmiss) {
            jp_pwfind.setVisible(false);
            jp_pwmiss.setVisible(true);
            jp_idfind.setVisible(false);
            jp_idmiss.setVisible(false);
            jbtn_idmiss.setBackground(Color.WHITE);
            jbtn_pwmiss.setBackground(new Color(253,220,81));
        } else if (obj ==jbtn_idsearch) {
            find_id = tDao.idFind(jtf_name.getText(),jtf_phone.getText());
            if (jtf_name.getText().equals("") || jtf_phone.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "아이디와 전화번호를 입력하세요.", "error", JOptionPane.ERROR_MESSAGE);
            }else if(find_id != null) {
                jp_pwfind.setVisible(false);
                jp_pwmiss.setVisible(false);
                jp_idfind.setVisible(true);
                jp_idmiss.setVisible(false);
                jlb_idfind.setText("회원님 아이디는 : "+find_id+"입니다.");
                jtf_id.setText(find_id);
            } else if(find_id == null) {
                JOptionPane.showMessageDialog(this, "아이디가 존재하지 않습니다.", "error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (obj ==jbtn_pwsearch) {
            find_pw = tDao.pwFind(jtf_name2.getText(),jtf_id.getText());
            if (jtf_id.getText().equals("") || jtf_name2.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "아이디와 이름을 입력하세요.", "error", JOptionPane.ERROR_MESSAGE);
            }else if(find_pw != null) {
                jp_pwfind.setVisible(true);
                jp_pwmiss.setVisible(false);
                jp_idfind.setVisible(false);
                jp_idmiss.setVisible(false);
                System.out.println("회원님 비밀번호는 : "+find_pw+"입니다.");
            } else if(find_pw == null) {
                JOptionPane.showMessageDialog(this, "비밀번호가 존재하지 않습니다.", "error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (obj == jbtn_pwupdate) {
            if (jtf_pwupdate.getText().equals("") || jtf_pwupdate2.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "변경할 비밀번호를 입력하세요", "error", JOptionPane.ERROR_MESSAGE);
            } else if (!jtf_pwupdate.getText().equals(jtf_pwupdate2.getText())) {
                JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.", "error", JOptionPane.ERROR_MESSAGE);
            } else {
                updat_pw = tDao.pwUpdate(jtf_id.getText(), jtf_pwupdate.getText());
                if (updat_pw != null) {
                    JOptionPane.showMessageDialog(this, "비밀번호가 성공적으로 변경되었습니다.", "success", JOptionPane.INFORMATION_MESSAGE);
                    // 비밀번호 변경 후 화면 초기화
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "비밀번호 변경에 실패했습니다.", "error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public static void main(String[] args) {
        new FindIdPwView();
    }
}
