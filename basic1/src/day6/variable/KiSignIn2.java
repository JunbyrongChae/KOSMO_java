package day6.variable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KiSignIn2 implements ActionListener {
    JFrame frame = new JFrame();
    JButton signUpButton = new JButton("Sign Up");
    JTextField idField = new JTextField(30);
    JPasswordField passwordField = new JPasswordField(30);
    JTextField emailField = new JTextField(30);
    JLabel idLabel = new JLabel("ID:");
    JLabel passwordLabel = new JLabel("Password:");
    JLabel emailLabel = new JLabel("Email:");

    public void initDisplay() {
        frame.setLayout(null); // 레이아웃 매니저 비활성화
       
        int labelWidth = 80;
        int fieldWidth = 150;
        int height = 25;
        int gap = 10;
        
        // 위치와 크기 설정
        idLabel.setBounds(20, 20, labelWidth, height);
        idField.setBounds(110, 20, fieldWidth, height);

        passwordLabel.setBounds(20, 60, labelWidth, height);
        passwordField.setBounds(110, 60, fieldWidth, height);

        emailLabel.setBounds(20, 100, labelWidth, height);
        emailField.setBounds(110, 100, fieldWidth, height);

        signUpButton.setBounds(110, 140, fieldWidth, height);

        // 프레임에 컴포넌트 추가
        frame.add(idLabel);
        frame.add(idField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(signUpButton);

        // 버튼에 이벤트 리스너 추가
        signUpButton.addActionListener(this);

        // 프레임 설정
        frame.setSize(300, 250);
        frame.setTitle("KiTalk Sign-In");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        KiSignIn2 signIn = new KiSignIn2();
        signIn.initDisplay();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ("Sign Up".equals(command)) {
            String id = idField.getText();
            char[] password = passwordField.getPassword();
            String email = emailField.getText();

            // 입력 값 검증 (예: 필수 항목들이 모두 입력되었는지 확인)
            if (id.isEmpty() || password.length == 0 || email.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "모든 필드를 채워주세요.", "오류", JOptionPane.ERROR_MESSAGE);
            } else {
                // 회원가입 처리
                System.out.printf("ID: %s, Password: %s, Email: %s%n", id, new String(password), email);
                JOptionPane.showMessageDialog(frame, "회원가입이 완료되었습니다!", "성공", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose(); // 회원가입 후 창 닫기
            }
        }
    }
}