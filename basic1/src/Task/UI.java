package Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame implements ActionListener {
    JTextField msg_insert;
    JTextArea msg_display;
    JTextArea mem_display;
    JButton send_button;
    JButton rename_button;
    JScrollPane scrollPane;
    JPanel left_panel;
    JPanel right_panel;
    JPanel msg_insPanel;

    public UI() {
        initDisplay();
    }

    private void initDisplay() {
        this.setTitle("UI");
        this.setSize(715, 530);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        left_panel = new JPanel();
        right_panel = new JPanel();
        msg_insPanel = new JPanel();
        msg_display = new JTextArea();
        msg_insert = new JTextField();
        send_button = new JButton("send");
        rename_button = new JButton("rename");
        mem_display = new JTextArea();
        scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        msg_insert.setSize(200, 40);

        left_panel.setBounds(0,0,500,500);
        right_panel.setBounds(500,0,200,500);

        msg_insPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        msg_insPanel.add(msg_insert);
        msg_insPanel.add(send_button);
        msg_insert.setSize(420,40);
        send_button.setSize(80,40);
        msg_display.setSize(500,460);

        left_panel.add(msg_display);
        left_panel.add("SOUTH",msg_insPanel);

        right_panel.setLayout(new BorderLayout());
        right_panel.add(rename_button);
        right_panel.add(mem_display);

        this.add(left_panel);
        this.add(right_panel);

        send_button.addActionListener(this);
        rename_button.addActionListener(this);
    }

    public static void main(String[] args) {
        new UI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //oos.writeObject(msg_insert.getText());


    }
}
