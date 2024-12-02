package ui.combo;

import com.util.DBconnectionMgr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
//클래스의 구성요소는 변수와 메소드
//생성자의 파라미터 자리도 사용자가 결정
//JcomboBox 객체 생성하기 - 초기화(객체의 특성) 해야 할 때
//JFrame jf = new JFrame(); jf.setTitle("타이틀제목");
//= JFrame jf = new JFrame("타이틀제목");
//생성자를 활용하여 초기화 하는 값이 오라클서버를 경유 한 뒤에 결정이 되야 한다면
//시간,타임라인 - 많이 코딩해봐야 함.
//선언부와 생성부를 분리하여 처리하는 코딩연습
//화면처리(렌더링)시점과 객체가 생성되는 시점 사이에 간격이 있다는 것
//JComboBox 생성자 자리에 들어갈 String[]을 결정하고, 결정된 값이 실제 콤보박스에 출력되도록 처리하기
//생성자로 처리하기, addItemAt()으로 처리
//클래스와 클래스사이의 관계 처리하기 -> 생성자에대한 활용 능력을 키우기 -> OOP적인 프로그래밍
/**************************************************
##테스트시나리오 작성 해보기
1. 처음 화면이 그려질 때(렌더링) 초기화 하기
2. 이벤트가 발생할 때 초기화 하기 (v)
 
***************************************************/
public class Combo2 extends JFrame implements ItemListener, ActionListener {
    JComboBox<String> combo = null;
    JMenuBar jmb = new JMenuBar();
    JMenu jm = new JMenu("edit");
    JMenuItem jmi_DB = new JMenuItem("DB테스트");
    JMenuItem jmi_ins = new JMenuItem("입력");
    JMenuItem jmi_upd = new JMenuItem("수정");
    JMenuItem jmi_exit = new JMenuItem("종료");
    JMenuItem jmi_del = new JMenuItem("삭제");
    JMenuItem jmi_det = new JMenuItem("상세보기");
    JSeparator jsep = new JSeparator();

    public Combo2() {
        initDisplay();
    }
    public void initDisplay() {
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if(combo == null){
            combo = new JComboBox();
        }

        this.add("North", combo);

        jm.add(jmi_DB);
        jm.add(jmi_ins);
        jm.add(jmi_upd);
        jm.add(jmi_det);
        jm.add(jmi_del);
        jm.add(jsep);
        jm.add(jmi_exit);
        jmb.add(jm);

        combo.addItemListener(this);
        jmi_DB.addActionListener(this);

        this.setJMenuBar(jmb);

        this.setVisible(true);
    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new Combo2();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    }
    public JComboBox<String> dbTest(){
        DBconnectionMgr dbMgr = DBconnectionMgr.getInstance();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT distinct(zdo) FROM zipcode_t");
        sql.append(" ORDER BY zdo asc");
        String zdos[] = null;
        Vector<String> v = new Vector<>();
        try {
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("zdo"));
                v.add(rs.getString("zdo"));
            }
            zdos = new String[v.size()];
            v.copyInto(zdos);
            combo = new JComboBox(zdos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return combo;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == jmi_DB) {
            System.out.println("DB연결");
            Container cont = this.getContentPane();
            if(combo !=null){
                cont.remove(combo);
            }
            combo = dbTest();
            this.add("North", combo);
            cont.revalidate();
        }
    }
}
