package athread.talk3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberShipForm extends JFrame implements ActionListener {
    //선언부
    JPanel jp_center = new JPanel();
    JLabel jlb_id = new JLabel("아이디");
    JTextField jtf_id = new JTextField(10);
    JLabel jlb_pw = new JLabel("패스워드");
    JTextField jtf_pw = new JTextField(10);
    JLabel jlb_nickName = new JLabel("대화명");
    JTextField jtf_nickName = new JTextField(20);
    JLabel jlb_name = new JLabel("성명");
    JTextField jtf_name = new JTextField(30);
    JLabel jlb_gender = new JLabel("성별");
    String[] genderList = {"남자","여자"};
    JComboBox jcb_gender = new JComboBox(genderList);
    JLabel 		jlb_zipcode = new JLabel("우편번호");
    public JTextField 	jtf_zipcode = new JTextField(6);
    JLabel 		jlb_address = new JLabel("주소");
    public JTextField 	jtf_address = new JTextField(100);
    JButton     jbtn_zipcode = new JButton("우편번호찾기");
    JScrollPane jsp = null;
    JPanel jp_south = new JPanel();
    JButton jbtn_ins = new JButton("등록");
    JButton jbtn_close = new JButton("닫기");
    JTextArea termsTextArea;
    JCheckBox agreeCheckBox;


    ZipCodeSearchForm zcf = new ZipCodeSearchForm(this);
    MemberShipForm(){
        initDisplay();
    }
    //화면처리부
    public void initDisplay() {
        jbtn_zipcode.addActionListener(this);
        jp_center.setLayout(null);

        termsTextArea = new JTextArea(
                "수집하는 개인정보 항목 \n"+
                        "- 개인식별정보 : 성명, 생년월일, 주소, 전화번호, 휴대전화번호, 이메일 \n"+
                        "\n 개인정보의 수집 및 이용목적 \n " +
                        "- 지원자와의 의사소통 및 정보 전달 등에 이용: 성명, 주소, 전화번호, 휴대전화번호, 이메일 \n"+
                        " 단, 지원자의 기본적 인권 침해의 우려가 있는 민감한 개인정보(인종 및 민족, 사상 및 신조, 정치적 성향 및 범죄기록 등)는 수집하지 않습니다.\n\n"+
                        "개인정보의 보유 및 이용기간\n "+
                        "수집된 개인정보는 지원서 제출 후 가입기간 만료 시 또는 계정 삭제 요청 시까지 위 이용 목적을 위하여 보유‧이용됩니다. 또한 삭제 요청 시 지원자의 개인정보를 재생이 불가능한 방법으로 즉시 파기합니다.\n\n"+
                        "※ 귀하는 이에 대한 동의를 거부할 수 있으며, 다만, 동의가 없을 경우 회원가입진행이 불가능할 수 있음을 알려드립니다.\n\n"+
                        "「개인정보 보호법」등 관련 법규에 의거하여 상기 본인은 위와 같이 개인정보 수집 및 활용에 동의합니다."
        );
        termsTextArea.setLineWrap(true);
        termsTextArea.setWrapStyleWord(true);
        termsTextArea.setEditable(false); // 수정 불가로 설정
        JScrollPane termsScrollPane = new JScrollPane(termsTextArea);
        agreeCheckBox = new JCheckBox("개인정보 수집에 동의합니다.");

        jlb_id.setBounds(20, 20, 100, 20);
        jtf_id.setBounds(120, 20, 120, 20);
        jlb_pw.setBounds(20, 45, 100, 20);
        jtf_pw.setBounds(120, 45, 120, 20);
        jlb_nickName.setBounds(20, 70, 100, 20);
        jtf_nickName.setBounds(120, 70, 150, 20);
        jlb_name.setBounds(20, 95, 100, 20);
        jtf_name.setBounds(120, 95, 150, 20);
        jlb_gender.setBounds(20, 120, 100, 20);
        jcb_gender.setBounds(120, 120, 150, 20);
        jcb_gender.setFont(new Font("굴림",1,14));
        jlb_zipcode.setBounds(20, 145, 100, 20);
        jtf_zipcode.setBounds(120, 145, 100, 20);
        jbtn_zipcode.setBounds(230, 145, 120, 20);
        jlb_address.setBounds(20, 170, 100, 20);
        jtf_address.setBounds(120, 170, 250, 20);
        termsScrollPane.setBounds(20, 200, 350, 100);
        agreeCheckBox.setBounds(180, 300, 200, 30);


        jp_center.add(jlb_id);
        jp_center.add(jtf_id);
        jp_center.add(jlb_pw);
        jp_center.add(jtf_pw);
        jp_center.add(jlb_nickName);
        jp_center.add(jtf_nickName);
        jp_center.add(jlb_name);
        jp_center.add(jtf_name);
        jp_center.add(jlb_gender);
        jp_center.add(jcb_gender);
        jp_center.add(jlb_zipcode);
        jp_center.add(jtf_zipcode);
        jp_center.add(jbtn_zipcode);
        jp_center.add(jlb_address);
        jp_center.add(jtf_address);
        jp_center.add(termsScrollPane);
        jp_center.add(agreeCheckBox);


        jp_south.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jp_south.add(jbtn_ins);
        jp_south.add(jbtn_close);
        this.add("South",jp_south);
        jsp = new JScrollPane(jp_center);
        this.add("Center",jsp);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("회원가입");
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        jbtn_ins.addActionListener(this);
        jbtn_close.addActionListener(this);
    }
    public static void main(String[] args) {
        new MemberShipForm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        zcf = new ZipCodeSearchForm();
        if(source == jbtn_zipcode){
            zcf.initDisplay();
        }else if(source == jbtn_ins){
            System.out.println("등록");
        }else if(source == jbtn_close){
            System.exit(0);
        }
    }
}

