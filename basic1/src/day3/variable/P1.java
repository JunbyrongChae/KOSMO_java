package day3.variable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class P1 extends JFrame implements ActionListener {
    // 필요한 GUI 컴포넌트 선언
    private JTextField num1Field, num2Field, resultField;
    private JComboBox<String> operatorBox;
    private JButton calculateButton;

    // 생성자에서 GUI 설정
    public P1() {
        // JFrame 기본 설정
        setTitle("계산기");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // 첫 번째 숫자 입력 필드
        add(new JLabel("첫 번째 숫자:"));
        num1Field = new JTextField();
        add(num1Field);

        // 연산자 선택
        add(new JLabel("연산자:"));
        String[] operators = {"+", "-", "*", "/"};
        operatorBox = new JComboBox<>(operators);// JComboBox: 연산자를 선택할 수 있는 드롭다운 메뉴.
        add(operatorBox);

        // 두 번째 숫자 입력 필드
        add(new JLabel("두 번째 숫자:"));
        num2Field = new JTextField();
        add(num2Field);

        // 결과 표시 필드
        add(new JLabel("결과:"));
        resultField = new JTextField();
        resultField.setEditable(false);  // 결과는 수정할 수 없도록 설정
        add(resultField);

        // 계산 버튼
        calculateButton = new JButton("계산");
        add(calculateButton);

        // 버튼에 액션 리스너 추가
        calculateButton.addActionListener(this);

        // 창을 보이도록 설정
        setVisible(true);
    }

    // 버튼 클릭 이벤트 처리
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // 입력값 받아오기
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            String operator = (String) operatorBox.getSelectedItem();
            double result = 0;

            // 연산자에 따른 계산
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        JOptionPane.showMessageDialog(this, "0으로 나눌 수 없습니다.");
                        return;
                    }
                    break;
            }

            // 결과를 텍스트 필드에 표시
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "숫자를 입력하세요.");
        }
    }

    public static void main(String[] args) {
        // 계산기 GUI 실행
        new P1();
    }
}


/**************
 객체작성은 지향하지만 너무 객체 의존적인것은 좋지 않음.
 인스턴스화나 재사용성을 생각해서 작성하는 것이 좋음.
 외부코드는 공부하기 전 강사님 검수하고 보는것이 졸음.
 *************/