package athread.bubble;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageRoom2 extends JFrame implements ActionListener {
    JPanel jp_center = new JPanel();
    JScrollPane jsp_center = new JScrollPane(jp_center, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JPanel jp_south = new JPanel();
    JTextField jtf_msg = new JTextField(20);
    JButton btn_send = new JButton("전송");
    int i = 1;

    public MessageRoom2() {
        initDisplay();
    }

    public static void main(String[] args) {
        new MessageRoom2();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == btn_send || obj == jtf_msg) {
            JPanel jp_msg1 = new ChatRight1("kiwi");
            JPanel jp_msg2 = new ChatLeft1();
            if (i % 2 == 1) {
                jp_center.add(jp_msg1);
                i++;
            } else {
                jp_center.add(jp_msg2);
                i++;
            }
            jp_center.revalidate();
            jp_center.repaint();
            jtf_msg.setText("");
            SwingUtilities.invokeLater(
                    () -> jsp_center.getVerticalScrollBar().setValue(jsp_center.getVerticalScrollBar().getMaximum()));
        }
    }
}