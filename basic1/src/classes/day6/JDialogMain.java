package classes.day6;

import javax.swing.*;
import java.awt.*;

public class JDialogMain extends JDialog {
    Jframemain jfm = null;
    JPanel jp_center = new JPanel();
    JPanel jp_south = new JPanel();
    JButton jb_save = new JButton("저장");
    JButton jb_close = new JButton("닫기");
    JLabel jlb_name = new JLabel("이 름");
    ButtonGroup bg = new ButtonGroup();
    JRadioButton jrb_male = new JRadioButton("남 자", true);
    JRadioButton jrb_female = new JRadioButton("여 자", false);
    JTextField jtf_name = new JTextField(20);
    JLabel jlb_gender = new JLabel("성 별");

    JDialogMain(Jframemain jfm) {
        this.jfm = jfm;
        initDisplay();
    }
    public String getSelectedGender() {
        if (jrb_male.isSelected()) {
            return "남 자";
        } else if (jrb_female.isSelected()) {
            return "여 자";
        } else {
            return null;
        }
    }

    public String getName() {
        return jtf_name.getText();
    }

    public void setName(String gender) {
        jtf_name.setText(gender);
    }
//부모창에서 사용자의 요청에 따라 화면이 켜지고 타이틀도 바뀌고 setvisable도 바뀌고, setSize도 바뀌고 JTextField도 상세보기일때는 읽기만(비활성화)
    //입력과 수정일때는 활성화 시켜주어야 한다.
    //아래 메서드는 Jframemain에서 호출한다.
    public void set(String title, boolean isView, boolean editable) {
        setEditable(editable);
        this.setTitle(title);
        this.setVisible(isView);

    }
    public void setEditable(boolean editable) {
        jtf_name.setEditable(editable);//true-입력,수정 false-비활성화(읽기전용)
    }
    public void initDisplay() {
        jp_center.setLayout(null);
        jlb_name.setBounds(20, 20, 100, 20);
        jtf_name.setBounds(120, 20, 100, 20);
        jp_center.add(jlb_name);
        jp_center.add(jtf_name);
        jlb_gender.setBounds(20, 50, 100, 20);
        jp_center.add(jlb_gender);
        bg.add(jrb_male);
        bg.add(jrb_female);
        jrb_male.setBounds(120, 50, 100, 20);
        jrb_female.setBounds(220, 50, 100, 20);
        jp_center.add(jrb_male);
        jp_center.add(jrb_female);
        jp_center.setBackground(new Color(158,217,203));
        jp_center.setBorder(BorderFactory.createEtchedBorder());
        jp_south.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        jb_save.setBackground(new Color(19,99,57));
        jb_save.setForeground(new Color(212,212,212));
        jb_close.setBackground(new Color(54,54,54));
        jb_close.setForeground(new Color(212,212,212));
        jp_south.add(jb_save);
        jp_south.add(jb_close);
        jp_south.setBackground(new Color(142,186,195));
        jp_south.setBorder(BorderFactory.createEtchedBorder());
        this.add("Center", jp_center);
        this.add("South", jp_south);

        this.setTitle("입력|수정|상세보기");
        this.setSize(500, 400);
        this.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JDialogMain(null);
    }
}
