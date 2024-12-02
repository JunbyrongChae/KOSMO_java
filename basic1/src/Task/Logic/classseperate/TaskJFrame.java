package Task.Logic.classseperate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskJFrame extends JFrame implements ActionListener {
    private TaskLogic lg;  // TaskLogic 인스턴스 참조
    private JTextArea ins_text = new JTextArea();  // 입력 텍스트 필드 선언

    public TaskJFrame(TaskLogic logic) {
        this.lg = logic;  // TaskLogic 인스턴스를 생성자에서 받음
        initDisplay();
    }

    public void initDisplay() {
        JButton ins_btn = new JButton("입력");
        JButton exit_btn = new JButton("종료");
        JLabel label = new JLabel("0~9 사이의 숫자를 입력하세요.");

        this.setLayout(null);
        this.setSize(400, 200);
        this.setFont(new Font("돋움", Font.BOLD, 20));
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        ins_btn.addActionListener(this);
        exit_btn.addActionListener(this);

        this.add(ins_btn);
        this.add(exit_btn);
        this.add(ins_text);
        this.add(label);

        this.setTitle("Number Guessing Game");

        label.setLayout(new FlowLayout(FlowLayout.CENTER));
        label.setFont(new Font("돋움", Font.BOLD, 20));
        label.setBounds(55, 0, 300, 50);
        ins_text.setBounds(90, 55, 200, 30);
        ins_btn.setBounds(100, 100, 70, 40);
        exit_btn.setBounds(210, 100, 70, 40);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        JButton btn = (JButton) obj;

        if (btn.getText().equals("입력")) {
            try {
                int inputNumber = Integer.parseInt(ins_text.getText().trim());
                lg.logic(inputNumber);  // 입력 값을 TaskLogic으로 전달
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "유효한 숫자를 입력하세요.");
            }
        } else if (btn.getText().equals("종료")) {
            System.exit(0);
        }
    }
}
