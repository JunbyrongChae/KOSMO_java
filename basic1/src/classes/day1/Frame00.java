package classes.day1;
//하나의 클래스로 코딩하기
//두 개의 클래스로 나누어 코딩하기
//세 개의 클래스로 쪼개서 구현하기

import javax.swing.*;
import java.awt.*;

public class Frame00 extends JFrame /*implements ActionListener*/ {
    public JButton button;
    public JLabel label;
    public JTextField textField;
    public JPanel panel;

    public void initDisplay(){
        button = new JButton();
        label = new JLabel();
        textField = new JTextField();
        panel = new JPanel();
        this.setLayout(new BorderLayout());
        this.add(button);
        button.setText("Button");
        button.setBackground(new Color(131, 205, 218));
        button.setForeground(Color.BLACK);
        this.add(textField);
        textField.getText();
        this.add(label,"NORTH");
        label.setText("Hello");
        label.setHorizontalTextPosition(JLabel.CENTER);
        this.add(panel,"SOUTH");
        panel.setLayout(new FlowLayout());
        panel.add(textField,"CENTER");
        panel.add(button,"RIGHT");


        this.setSize(500,500);
        this.setTitle("JFrame");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Frame00 fm = new Frame00();
        fm.initDisplay();
    }////////////// end of main

    /*
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String text = textField.getText();

    }////////////// end of actionPerformed */
}////////////////// end of class
