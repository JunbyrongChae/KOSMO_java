package Talk.step1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatApp {
    // JFrame과 주요 컴포넌트 선언
    private JFrame frame;
    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;
    private JButton exitButton;

    public ChatApp() {
        // JFrame 설정
        frame = new JFrame("Chat Application");
        frame.setSize(450, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // 채팅 기록을 표시하는 JTextArea (읽기 전용)
        chatArea = new JTextArea();
        chatArea.setEditable(false);

        // JScrollPane에 JTextArea 추가 (스크롤 가능)
        JScrollPane scrollPane = new JScrollPane(chatArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // 메세지 입력창과 전송 버튼을 아래쪽에 추가
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        messageField = new JTextField();
        sendButton = new JButton("Send");
        bottomPanel.add(messageField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // 오른쪽 상단에 나가기 버튼을 추가
        exitButton = new JButton("Exit");
        JPanel topRightPanel = new JPanel();
        topRightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        topRightPanel.add(exitButton);
        frame.add(topRightPanel, BorderLayout.NORTH);

        // 전송 버튼 클릭 이벤트 처리
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = messageField.getText();
                if (!message.trim().isEmpty()) {
                    chatArea.append("You: " + message + "\n");
                    messageField.setText(""); // 입력 후 입력창 비우기
                    chatArea.setCaretPosition(chatArea.getDocument().getLength()); // 스크롤을 자동으로 아래로 내림
                }
            }
        });

        // 나가기 버튼 클릭 이벤트 처리
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // 프로그램 종료
            }
        });

        // 화면에 창 표시
        frame.setLocationRelativeTo(null); // 화면 중앙에 창 배치
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ChatApp(); // 채팅창 애플리케이션 실행
    }
}
