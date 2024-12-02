package Task.Logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TaskJFrame extends JFrame implements ActionListener {
    String imgpath = "C:\\workspace_java\\basic1\\src\\image\\game\\";
    TaskLogic lg = new TaskLogic();
    JButton ins_btn = new JButton("입력");
    JButton exit_btn = new JButton("종료");
    JButton reset_btn = new JButton("리셋");
    JTextField ins_text = new JTextField();
    JLabel label = new JLabel("0~9사이의 숫자를 입력하세요.");
    ImageIcon img_bg = new ImageIcon(imgpath + "blackboard.png");



    public TaskJFrame() {
        initDisplay();
    }

    class Mypanel extends JPanel {
        public void paintComponent(Graphics g) {
            g.drawImage(img_bg.getImage(),0,0,null);
            //(0,0)위치에 임미지패널 위치
            setOpaque(false);//패널의 배경을 투명하게 설정(true)
            //super는 상위 클래스를 가르키는 수정자입니다.
            super.paintComponent(g);
            //이미지 처리는 개발자가 호출만 할 수 있고 내부적으로 처리됨
        }
    }
    public void initDisplay() {
        setContentPane(new TaskJFrame.Mypanel());
        this.setLayout(null);
        this.setSize(415, 320);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        ins_btn.addActionListener(this);
        exit_btn.addActionListener(this);
        reset_btn.addActionListener(this);

        this.add(ins_btn);
        this.add(exit_btn);
        this.add(ins_text);
        this.add(reset_btn);
        this.add(label);

        ins_btn.setIcon(new ImageIcon(imgpath + "insert.png"));
        exit_btn.setIcon(new ImageIcon(imgpath + "exit.png"));
        reset_btn.setIcon(new ImageIcon(imgpath + "reset.png"));
        reset_btn.setBorderPainted(false);
        ins_btn.setBorderPainted(false);
        exit_btn.setBorderPainted(false);
        ins_btn.setFont(new Font("Arial", Font.PLAIN, 0));
        exit_btn.setFont(new Font("Arial", Font.PLAIN, 0));
        reset_btn.setFont(new Font("Arial", Font.PLAIN, 0));

        this.setTitle("Number Guessing Game");

        label.setLayout(new FlowLayout(FlowLayout.CENTER));
        label.setFont(new Font("온글잎 의청수 시우체",Font.PLAIN,25));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(Color.WHITE);
        label.setBounds(0,80,415,50);
        ins_text.setBounds(125,135,150,30);
        ins_text.setHorizontalAlignment(JTextField.CENTER);
        ins_btn.setBounds(110,190,60,40);
        reset_btn.setBounds(185,190,35,40);
        exit_btn.setBounds(230,190,60,40);

    }

    public static void main(String[] args) {
        new TaskJFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        JButton btn = (JButton)obj;

        if (btn.getText().equals("입력")) {

            ///try-catch외에 방법음?
            try {
                int inputNumber = Integer.parseInt(ins_text.getText().trim());
                lg.logic(inputNumber);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "유효한 숫자를 입력하세요.");
            }
            ins_text.setText("");

        } else if (btn.getText().equals("종료")) {
            System.exit(0);
        } else if (btn.getText().equals("리셋")) {
            lg.resetGame();
            System.out.println(lg.cop_nub);
        }
    }
}
