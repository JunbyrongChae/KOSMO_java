package classes.day1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Table extends JFrame implements ActionListener {
    JButton emoji = new JButton("이모티콘");
    JButton exit = new JButton("종료");
    JButton twoPeople = new JButton("1 : 1");
    JButton manyPeople = new JButton("1 : N");
    JPanel jp_south = new JPanel();
    DefaultTableModel dtm = new DefaultTableModel(20,1);
    JTable jtb = new JTable(dtm);
    JScrollPane jsp = new JScrollPane(jtb,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);



    public Table() {
        initDisplay();    }

    public void initDisplay() {
        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jp_south.setLayout(new GridLayout(2,2,10,10));
        jp_south.add(twoPeople);
        jp_south.add(manyPeople);
        jp_south.add(emoji);
        jp_south.add(exit);
        this.add("South", jp_south);

        this.add("Center", jsp);


    }

    public static void main(String[] args) {
        new Table();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
