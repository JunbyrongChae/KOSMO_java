package athread.bubble;

import com.util.DBconnectionMgr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class FriendListView extends JFrame implements ActionListener {
    DBconnectionMgr dbMgr = DBconnectionMgr.getInstance();
    Connection conn = dbMgr.getConnection();
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    JPanel jp_center = new JPanel();
    JScrollPane jsp_center = new JScrollPane(jp_center, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JPanel jp_south = new JPanel();
    JTextField jtf_msg = new JTextField(20);
    JButton btn_send = new JButton("전송");
    int i = 1;

    public FriendListView() {
        initDisplay();
    }

    public List<Map<String, Object>> FriendList(String mem_id) {
        List<Map<String, Object>> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT mem.mem_id, fri.f_id,fri.rerelationship, mem.status_msg");
        sql.append(" ,mem1_status_msg,mem.mem_name,mem1.mem_name");
        sql.append(" FROM talk_member mem, talk_friend fri, talk_member mem1");
        sql.append(" WHERE mem.mem_id = fri.mem_id");
        sql.append(" AND fri.f_id = mem1.mem_id");
        sql.append(" AND mem.mem_id = ?");
        try {
            conn = dbMgr.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, mem_id);
            rs = pstmt.executeQuery();
            Map<String, Object> map = null;
            while (rs.next()) {
                map = new HashMap<>();
                map.put("mem_id", rs.getString("mem_id"));
                map.put("f_id", rs.getString("f_id"));
                map.put("rerelationship", rs.getString("rerelationship"));
                map.put("status_msg", rs.getString("status_msg"));
                map.put("mem1_status_msg", rs.getString("mem1_status_msg"));
                map.put("mem_name", rs.getString("mem_name"));
                map.put("mem1_name", rs.getString("mem1_name"));
                list.add(map);
            }
        } catch (SQLException se) {
            System.out.println("[SQL 오류] FriendList: " + se.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            dbMgr.freeConnection(conn, pstmt, rs);
        }
        return list;
    }

    public void initDisplay() {
        btn_send.addActionListener(this);
        jtf_msg.addActionListener(this);

        jp_center.setLayout(new GridLayout(0, 1));
        jp_south.setLayout(new BorderLayout());
        jp_south.add("Center", jtf_msg);
        jp_south.add("East", btn_send);

        this.add("Center", jsp_center);
        this.add("South", jp_south);
        this.setSize(500, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FriendListView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == btn_send || obj == jtf_msg) {
            jtf_msg.setText("");
            JPanel jp_msg = new JPanel(new BorderLayout());
            JButton btn_img = new JButton("img");
            JLabel jlb_status = new JLabel("상메창",JLabel.LEFT);
            JLabel jlb_id = new JLabel("Friend_id",JLabel.CENTER);
            jp_msg.add("West",btn_img);
            jp_msg.add("Center",jlb_status);
            jp_msg.add("East",jlb_id);
            JPanel jp_msg2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            if (i % 2 == 1) {
                jp_msg.setBackground(new Color(244, 255, 243));
                i++;
            } else {
                jp_msg.setBackground(new Color(255, 247, 238));
                i++;
            }
            jp_center.add(jp_msg);
            jp_center.revalidate();
            jp_center.repaint();
            jtf_msg.setText("");
            SwingUtilities.invokeLater(
                    () -> jsp_center.getVerticalScrollBar().setValue(jsp_center.getVerticalScrollBar().getMaximum()));
        }
    }
}