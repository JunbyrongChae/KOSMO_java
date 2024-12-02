package Messenger;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class InsertNickname extends JFrame {
    JTextField nickname;
    JButton insert_button;
    Font font = new Font("netmarble Medium", Font.PLAIN, 15);
    String imagePath = "C:\\workspace_java\\Messenger\\src\\image\\";

    public void fontInstaller(){
        try {
            // 폰트 파일 경로 설정
            File fontFile = new File("C:\\workspace_java\\Messenger\\src\\fonts\\netmarbleM");

            // 폰트를 로드
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);

            // 시스템 그래픽 환경에 폰트 추가
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            System.out.println("커스텀 폰트가 성공적으로 설치되었습니다.");
        } catch (IOException | FontFormatException e) {
            System.out.println("폰트를 로드하는 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }


    // 배경 이미지
    class Mypanel extends JPanel {
        ImageIcon img = new ImageIcon(imagePath + "insertnic.png");
        public void paintComponent(Graphics g) {
            g.drawImage(img.getImage(), 0, 0, null);
            super.paintComponents(g);
        }
    }

    public InsertNickname() {
        nickname = new JTextField();
        insert_button = new JButton(new ImageIcon(imagePath + "insertB.png"));
        setContentPane(new InsertNickname.Mypanel());
        //프레임 기본설정
        this.setLayout(null);
        this.setTitle("닉네임 입력");
        this.setSize(310, 310);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //글씨설정
        nickname.setFont(font);
        nickname.setForeground(new Color(40, 40, 40));
        nickname.setHorizontalAlignment(SwingConstants.CENTER);
        nickname.setCaretColor(new Color(40, 40, 40));

        //버튼테두리제거
        insert_button.setBorder(null);

        //위치설정
        nickname.setBounds(50, 130, 200, 30);
        insert_button.setBounds(105, 180, 100, 30);

        //요소삽입
        this.add(nickname);
        this.add(insert_button);

        //크기변경 불가
        this.setResizable(false);
        this.setVisible(true);

    }
    public JTextField getNicknameField() {return nickname;}
    public JButton getInsertButton() {return insert_button;}
}
