package day6.variable;

import javax.swing.*;
import java.awt.*;

public class KiSignIn {
    JFrame frame = new JFrame();
    JLabel idLabel = new JLabel();
    JLabel pwLabel = new JLabel();
    JLabel pwCheckLabel = new JLabel();
    JLabel name = new JLabel();
    JLabel email = new JLabel();
    JLabel phone = new JLabel();
    JTextField id = new JTextField();
    JPasswordField pw = new JPasswordField();
    JPasswordField pwCheck = new JPasswordField();
    JTextField nameField = new JTextField();
    JTextField emailField = new JTextField();
    JTextField phoneField = new JTextField();
    JButton signInButton = new JButton("회원가입");
    JButton signInButton2 = new JButton("취   소");

    public void signInDisplay(){
        frame.setLayout(new GridLayout(7, 2));

        idLabel.setText("아이디");
        idLabel.setForeground(Color.BLACK);
        pwLabel.setText("비밀번호");
        pwLabel.setForeground(Color.BLACK);
        pwCheckLabel.setText("비밀번호 확인");
        pwCheckLabel.setForeground(Color.BLACK);
        name.setText("이  름");
        name.setForeground(Color.BLACK);
        email.setText("이메일");
        email.setForeground(Color.BLACK);
        phone.setText("전화번호 : ");
        phone.setForeground(Color.BLACK);

        frame.add(idLabel);
        frame.add(id);
        frame.add(pwLabel);
        frame.add(pw);
        frame.add(pwCheckLabel);
        frame.add(pwCheck);
        frame.add(name);
        frame.add(nameField);
        frame.add(email);
        frame.add(emailField);
        frame.add(phone);
        frame.add(phoneField);
        frame.add(signInButton);
        frame.add(signInButton2);

        frame.setTitle("KiTalk Sign In");
        frame.setSize(450,350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new KiSignIn().signInDisplay();
    }
}
