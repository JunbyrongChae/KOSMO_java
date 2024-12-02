package athread.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextAreaView extends JFrame implements ActionListener {
    //선언부
    JTextField jtf_msg = new JTextField(30);
    JTextArea jta_display = null;
    JScrollPane jsp_display = null;
    String path = "src\\image\\talk\\";
    Image backimg = null;
    Font font = new Font("맑은 고딕",Font.BOLD,20);


    //디폴트 생성자
    public JTextAreaView() {initDisplay();}
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == jtf_msg) {
            jta_display.append(jtf_msg.getText()+"\n");
            jtf_msg.setText("");
        }
    }/////////////// end of actionPerfoermed

    //화면그리기
    public void initDisplay() {
        setSize(500, 700);

        backimg = getToolkit().getImage(path+"jtextarea.png");

        jta_display = new JTextArea(){
            public void paint(Graphics g) {
                g.drawImage(backimg, 0, 0, this);
                setOpaque(false);
                Point p = jsp_display.getViewport().getViewPosition();
                g.drawImage(backimg, p.x, p.y, null);
                super.paintComponent(g);
            }
        };
        jta_display.setLineWrap(true);
        jta_display.setWrapStyleWord(true);
        jsp_display = new JScrollPane(jta_display);
        jta_display.setFont(font);
        jta_display.setCaretPosition(jta_display.getDocument().getLength());

        jtf_msg.addActionListener(this);

        add("Center", jsp_display);
        add("South", jtf_msg);
        setResizable(false);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new JTextAreaView();
    }/////////////// end of main
}/////////////////// end of class
