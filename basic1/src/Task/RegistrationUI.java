package Task;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationUI extends JFrame implements ActionListener {
    JFrame frame;
    JLabel idLabel = new JLabel("ID");
    JTextField idField = new JTextField();
    JButton idButton = new JButton("ID 확인");
    JLabel emailLabel = new JLabel("이메일 주소");
    JTextField emailField = new JTextField();
    JLabel phoneLabel = new JLabel("전화번호");
    JTextField phoneField = new JTextField();
    JLabel passwordLabel = new JLabel("비밀번호");
    JPasswordField passwordField = new JPasswordField();
    JLabel confirmPasswordLabel = new JLabel("비밀번호 확인");
    JPasswordField confirmPasswordField = new JPasswordField();
    JLabel dobLabel = new JLabel("생년월일 (선택 사항)");
    JTextField dobField = new JTextField();
    JLabel genderLabel = new JLabel("성별 (선택 사항)");
    JLabel countryLabel = new JLabel("국가 또는 지역");
    JTextField countryField = new JTextField();
    JCheckBox termsCheckBox = new JCheckBox("서비스 이용 약관에 동의합니다", false);
    JCheckBox privacyCheckBox = new JCheckBox("개인정보 처리방침에 동의합니다", false);
    JCheckBox marketingCheckBox = new JCheckBox("마케팅 정보 수신에 동의합니다 (선택 사항)", false);
    JButton submitButton = new JButton("회원가입");

    public void registrationUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(null);


        idLabel.setBounds(0,0,0,0);
        idField.setBounds(0,0,0,0);
        idButton.setBounds(0,0,0,0);
        frame.add(idLabel);
        frame.add(idField);
        frame.add(idButton);

        frame.add(emailLabel);
        frame.add(emailField);

        frame.add(phoneLabel);
        frame.add(phoneField);

        frame.add(passwordLabel);
        frame.add(passwordField);

        frame.add(confirmPasswordLabel);
        frame.add(confirmPasswordField);
/*
        JLabel profilePictureLabel = new JLabel("프로필 사진 (선택 사항)");
        JButton profilePictureButton = new JButton("파일 선택");
        frame.add(profilePictureLabel);
        frame.add(profilePictureButton);
*/
        frame.add(dobLabel);
        frame.add(dobField);

        String[] genderOptions = {"선택", "남성", "여성", "기타"};
        JComboBox<String> genderComboBox = new JComboBox<>(genderOptions);
        frame.add(genderLabel);
        frame.add(genderComboBox);

        frame.add(countryLabel);
        frame.add(countryField);


        frame.add(termsCheckBox);

        frame.add(privacyCheckBox);

        frame.add(marketingCheckBox);

        frame.add(submitButton);

        frame.setVisible(true);

        //todo : setBounds setting

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        JButton button = (JButton) source;

        if (button.getText().equals("ID 확인")) {
            // ID 중복검사

        } else if (button.getText().equals("비밀번호 확인")) {
            // Password Check

        } else if (button.getText().equals("회원가입")) {
            // Check All Fields
        }
    }
}
