package athread.talk2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
	//선언부
	String imgPath = "C:\\workspace_java\\basic1\\src\\image\\talk\\";
	//JPanel에 쓰일 이미지 아이콘
	ImageIcon img = new ImageIcon(imgPath + "main.png");

	JLabel jl_id = new JLabel("아이디");
	JLabel jl_pw = new JLabel("비밀번호");
	JTextField jtf_id = new JTextField("tomato",20);
	JPasswordField jpf_pw = new JPasswordField("1234",20);
	Font font = new Font("야놀자 야체 Bold", Font.BOLD, 27);
	JButton btn_login = new JButton(new ImageIcon(imgPath + "login.png"));
	JButton btn_join = new JButton(new ImageIcon(imgPath + "confirm.png"));
	JButton btn_exit = new JButton(new ImageIcon(imgPath + "exit.png"));

	//생성자
	public Login() {
		initDisplay();
	}
	class Mypanel extends JPanel {
		public void paintComponent(Graphics g) {
			g.drawImage(img.getImage(), 0, 0, null);
			//(0,0)위치에 임미지패널 위치
			setOpaque(false);//패널의 배경을 투명하게 설정(true)
			//super는 상위 클래스를 가르키는 수정자입니다.
			super.paintComponent(g);
			//이미지 처리는 개발자가 호출만 할 수 있고 내부적으로 처리됨
		}
	}
	//화면처리부
	public void initDisplay() {
		setContentPane(new Mypanel());
		this.setLayout(null);
		//로그인 버튼 라인추가
		btn_login.setBounds(45, 300, 120, 40);
		this.add(btn_login);
		//회원가입 버튼 라인추가
		btn_join.setBounds(175, 300, 120, 40);
		this.add(btn_join);
		//아이디라벨
		jl_id.setBounds(45, 190, 80, 40);
		jl_id.setFont(font);
		this.add(jl_id);
		jtf_id.setBounds(110, 190, 185, 40);
		this.add(jtf_id);
		//비밀번호라벨
		jl_pw.setBounds(35, 240, 80, 40);
		jl_pw.setFont(font);
		this.add(jl_pw);
		jpf_pw.setBounds(110, 240, 185, 40);
		this.add(jpf_pw);

		btn_exit.setBounds(0, 0, 30, 30);
		btn_exit.addActionListener(this);
		btn_exit.setBackground(Color.RED);
		this.add(btn_exit);

		this.setTitle("Log-in");
		this.setSize(350, 600);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btn_login.addActionListener(this);
		btn_join.addActionListener(this);
		btn_exit.addActionListener(this);

	}
	//메인메소드
	public static void main(String[] args) {
		new LoginForm();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == btn_login) {
			System.out.println("사용자가 입력한 아이디 : " + jtf_id.getText());
			System.out.println("사용자가 입력한 비밀번호 : " + jpf_pw.getText());
			JOptionPane.showConfirmDialog(
					this,
					"사용자가 입력한 아이디 : " + jtf_id.getText() + "\n" + "사용자가 입력한 비밀번호 : " + jpf_pw.getText(),
					"사용자가 입력한 아이디와 비밀번호",
					JOptionPane.OK_OPTION
			);
		} else if (source==btn_join) {
			System.out.println("회원가입 양식 호출");
			JOptionPane.showConfirmDialog(
					this,
					"회원가입 불가",
					"Information",
					JOptionPane.DEFAULT_OPTION
			);
		}
		if (source == btn_exit) {
			System.exit(0);
		}
	}
}
