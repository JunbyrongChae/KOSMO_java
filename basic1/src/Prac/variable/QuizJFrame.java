package Prac.variable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class QuizJFrame extends JFrame {
    private JTextField inputField;  // 사용자 입력을 받을 텍스트 필드
    private JButton guessButton;    // 추측 버튼
    private JLabel resultLabel;     // 결과를 출력할 레이블
    private int targetNumber;       // 컴퓨터가 생성한 목표 숫자
    private int attempts;           // 시도 횟수

    public QuizJFrame() {
        // GUI 설정
        setTitle("숫자 맞추기 게임");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // 컴포넌트 초기화
        JLabel instructionLabel = new JLabel("1부터 100까지의 숫자를 맞춰보세요:");
        inputField = new JTextField(10);
        guessButton = new JButton("추측");
        resultLabel = new JLabel("결과가 여기에 표시됩니다.");

        // 이벤트 리스너 추가
        guessButton.addActionListener(new GuessButtonListener());

        // 컴포넌트 배치
        add(instructionLabel);
        add(inputField);
        add(guessButton);
        add(resultLabel);

        // 컴퓨터가 맞출 숫자 생성
        Random random = new Random();
        targetNumber = random.nextInt(100) + 1;
        attempts = 0;
    }

    // 추측 버튼 클릭 시 동작할 이벤트 리스너
    private class GuessButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // 사용자 입력 숫자 받기
                int guess = Integer.parseInt(inputField.getText());
                attempts++; // 시도 횟수 증가

                // 숫자 비교 및 결과 출력
                if (guess > targetNumber) {
                    resultLabel.setText("더 작은 숫자를 입력하세요.");
                } else if (guess < targetNumber) {
                    resultLabel.setText("더 큰 숫자를 입력하세요.");
                } else {
                    resultLabel.setText("정답입니다! " + attempts + "번 만에 맞췄습니다.");
                    guessButton.setEnabled(false);  // 게임이 끝나면 버튼 비활성화
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("유효한 숫자를 입력하세요.");
            }
        }
    }

    public static void main(String[] args) {
        // GUI 실행
        QuizJFrame game = new QuizJFrame();
        game.setVisible(true);
    }
}