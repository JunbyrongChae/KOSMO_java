package Talk.step1;

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

    public void signInDisplay(){
        frame.setLayout(null);

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

        idLabel.setBounds(20,30,70,30);
        id.setBounds(225,30,150,30);
        pwLabel.setBounds(20,60,70,30);
        pw.setBounds(225,60,150,30);
        pwCheckLabel.setBounds(20,90,70,30);
        pwCheck.setBounds(225,90,150,30);
        name.setBounds(20,120,70,30);
        nameField.setBounds(225,120,150,30);
        email.setBounds(20,150,100,30);
        emailField.setBounds(225,150,150,30);
        phone.setBounds(20,180,100,30);
        phoneField.setBounds(225,180,150,30);
        signInButton.setBounds(140,210,100,60);

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

        frame.setTitle("KiTalk Sign In");
        frame.setSize(380,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new KiSignIn().signInDisplay();
    }
}
