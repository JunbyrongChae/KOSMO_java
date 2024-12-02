package ui.table;

import model.vo.Notice1030;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Table1 extends JFrame implements ActionListener, MouseListener {
    String[] headers = {"번호","제목","작성자"};
    DefaultTableModel dtm = new DefaultTableModel(headers,0);
    JTable table = new JTable(dtm);
    JScrollPane jsp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JButton jbtn_sel = new JButton("조회");

    public Table1() {
        initDisplay();
    }

    public void initDisplay() {
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        jbtn_sel.addActionListener(this);
        table.addMouseListener(this);

        this.add("Center",jsp);
        this.add("North",jbtn_sel);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Table1();
    }
    public List<Notice1030> getNoticeList() {
        List<Notice1030> nList = new ArrayList<>();
        Notice1030 no = new Notice1030();
        no.setN_no(1);
        no.setN_title("제목1");
        no.setN_writer("나신입");
        nList.add(no);
        no = new Notice1030();
        no.setN_no(2);
        no.setN_title("제목2");
        no.setN_writer("나초보");
        nList.add(no);
        no = new Notice1030();
        no.setN_no(3);
        no.setN_title("제목3");
        no.setN_writer("나일등");
        nList.add(no);
        return nList;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == jbtn_sel) {
            List<Notice1030> list = getNoticeList();
            for (int i = 0; i < list.size(); i++) {
                Notice1030 nvo = list.get(i);
                Vector<Object> oneRow = new Vector<>();
                oneRow.add(nvo.getN_no());
                oneRow.add(nvo.getN_title());
                oneRow.add(nvo.getN_writer());
                dtm.addRow(oneRow);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getClickCount()==1){
            System.out.println("double click");
            int index[] = table.getSelectedRows();
            if (index.length ==0) {
                JOptionPane.showConfirmDialog(this, "선택하세요.");
                return;
            } else if (index.length>1) {
                JOptionPane.showConfirmDialog(this, "한 건만 석택하세요");
                return;
            } else {
                int no = (Integer)dtm.getValueAt(index[0],0);
                String title = (String)dtm.getValueAt(index[0],1);
                String writer = (String)dtm.getValueAt(index[0],2);
                System.out.println(no+" "+title+" "+writer);
            }
        }
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
