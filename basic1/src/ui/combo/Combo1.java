package ui.combo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Combo1 extends JFrame implements ItemListener {
    JPanel jp_north = new JPanel();
    JComboBox jcb1 = null;
    JComboBox jcb2 = new JComboBox();
    JComboBox jcb3 = new JComboBox(new String[]{"전체","서울","경기","부산"});
    JTextArea jta = new JTextArea();
    JScrollPane jsp = new JScrollPane();
    public Combo1() {
        jcb1 = new JComboBox();
        jcb1.addItem("돈까스");
        jcb1.addItem("떡볶이");
        jcb1.addItem("김밥");
        jcb1.addItem("라면");
        initDisplay();
    }
    public void initDisplay() {
        //인스턴스화
        jcb3 = new JComboBox(new String[]{"전체","서울","경기","부산"});
        jta = new JTextArea();
        jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //기본 프레임 설정
        this.setTitle("ComboBox");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //ItemListener
        jcb1.addItemListener(this);
        jcb3.addItemListener(this);

        //JTextArea 설정
        jta.setLineWrap(true);
        jta.setWrapStyleWord(true);
        jta.setEditable(false);

        //요소 삽입
        jp_north.setLayout(new GridLayout(3, 1));
        jp_north.add(jcb1);
        jp_north.add(jcb2);
        jp_north.add(jcb3);
        this.add("North", jp_north);
        this.add("Center", jsp);

        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Combo1();
    }
    //ItemListener가 정의하는 추상 메서드를 오버라이딩 하고 있어서
    //Combo1은 ItemListener 수현체 클래스라고 한다.
    //jcb1.addItemListener(this);
    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getSource();
        if(source == jcb3) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                String item = (String)jcb3.getSelectedItem();
                jta.append("선택한 아이템은 1-"+item+"입니다.\n");
            }
        } else if (source == jcb1) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                String item = (String)jcb1.getSelectedItem();
                jta.append("선택한 아이템은 3-"+item+"입니다.\n");
            }
        }
    }
}
