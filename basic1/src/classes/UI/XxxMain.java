package classes.UI;

import classes.levelup.NoticeMain;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class XxxMain extends JFrame implements ActionListener {
    XxxSub sub = new XxxSub();
    //선언부
    JPanel jp_north = new JPanel();
    JButton btn_ins = new JButton("입력");
    JButton btn_upd = new JButton("수정");
    JButton btn_det = new JButton("상세보기");
    JButton btn_del = new JButton("삭제");
    JButton btn_sel = new JButton("전체조회");
    JButton btn_exit = new JButton("종료");
    //테이블 그리기(번호 제목 작성자)
    String[] cols ={"번호","제목","작성자"};
    DefaultTableModel dtm = new DefaultTableModel(cols,50);
    JTable jtb = new JTable(dtm);//선그려주는 애, 데이터는 DefaultTableModel
    JScrollPane jsp = new JScrollPane(jtb);
    //생성자
    public XxxMain() {
        initDisplay();
    }
    //화면처리부
    public void initDisplay() {
        this.setSize(800,600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());
        this.add("North",jp_north);
        jp_north.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        jp_north.add(btn_ins);
        jp_north.add(btn_upd);
        jp_north.add(btn_det);
        jp_north.add(btn_del);
        jp_north.add(btn_sel);
        jp_north.add(btn_exit);

        this.add("Center",jsp);

        btn_ins.addActionListener(this);
        btn_upd.addActionListener(this);
        btn_det.addActionListener(this);
        btn_del.addActionListener(this);
        btn_sel.addActionListener(this);
        btn_exit.addActionListener(this);
    }
    //메인메소드
    public static void main(String[] args) {
        new XxxMain();
    }
    //공지사항 목록을 출력하기
    public void xxxList(){
        System.out.println("xxxList호출");
        Object[][] objs = { //2차배열
                {1,"공지사항1","admin1"},
                {2,"공지사항2","admin2"},
                {3,"공지사항3","admin3"},
                {4,"공지사항4","admin4"}
        };
        Container cont = this.getContentPane();
        if(jsp != null) {//null이 아니면 참조객체있다.
            cont.remove(jsp);
        }
        dtm = new DefaultTableModel(objs,cols);
        jtb = new JTable(dtm);
        jsp = new JScrollPane(jtb);
        this.add("Center",jsp);
        cont.revalidate();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object btn = e.getSource();
        JButton b = (JButton)btn;
        if(b == btn_ins) {
            sub.setTitle("XxxMain - "+btn.getClass());
            sub.initDisplay();
        } else if(b == btn_upd) {
            sub.setTitle("XxxMain - "+b.getText());
            sub.initDisplay();
        } else if(b == btn_det) {
            sub.setTitle("XxxMain - "+b.getText());
            sub.initDisplay();
        } else if(b == btn_del) {
            sub.setTitle("XxxMain - "+b.getText());
            sub.initDisplay();
        } else if(b == btn_sel) {
            sub.setTitle("XxxMain - "+b.getText());
            sub.initDisplay();
        } else if(b == btn_exit) {
            System.exit(0);
        }
    }
}
