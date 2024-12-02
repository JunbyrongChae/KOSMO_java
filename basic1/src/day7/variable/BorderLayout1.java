package day7.variable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorderLayout1 extends JFrame implements ActionListener {
    //String buttonText = null;
    //JFrame을 상속 받아 인스턴스화 안함. -> 코드 한 줄 줄었다.
    JButton jbt_north = new JButton("NORTH");
    JButton jbt_south = new JButton("SOUTH");
    JButton jbt_east = new JButton("EAST");
    JButton jbt_west = new JButton("WEST");
    JButton jbt_center = new JButton("CENTER");
    JPanel jp = new JPanel();
    //화면 메소드 선언하기
    //메소드 중심의코딩을 전개하기 연습
    public void initDisplay(){
        System.out.println("initDisplay 호출 성공");
        //아래 문장이 있어야 actionPerformed메소드를
        //JVM이 이벤트가 감지되었을때 호출함
        jbt_north.addActionListener(this);
        jbt_south.addActionListener(this);
        jbt_east.addActionListener(this);
        jbt_west.addActionListener(this);
        jbt_center.addActionListener(this);

        this.setLayout(new BorderLayout());

        this.add(jbt_north,BorderLayout.NORTH);
        this.add(jbt_south,BorderLayout.SOUTH);
        this.add(jbt_east,BorderLayout.EAST);
        this.add(jbt_west,BorderLayout.WEST);
        this.add(jbt_center,BorderLayout.CENTER);
        this.setVisible(true);
        this.setSize(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        jp.setBackground(new Color(106, 114, 173));
    }
    public static void main(String[] args) {
        BorderLayout1 bl = new BorderLayout1();
        bl.initDisplay();

    }
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        JButton jbt = (JButton)source;
        //buttonText = e.getActionCommand();

        /*
        switch (buttonText) {
            case "NORTH":
                JOptionPane.showMessageDialog(this, "North");
                System.out.println("Pressed North");
                break;
            case "SOUTH":
                JOptionPane.showMessageDialog(this, "South");
                System.out.println("Pressed South");
                break;
            case "EAST":
                JOptionPane.showMessageDialog(this, "East");
                System.out.println("Pressed East");
                break;
            case "WEST":
                JOptionPane.showMessageDialog(this, "West");
                System.out.println("Pressed West");
                break;
            case "CENTER":
                JOptionPane.showMessageDialog(this, "Center");
                System.out.println("Pressed Center");
                break;
        }*/
        if(jbt.equals(jbt_north)){
            System.out.println("Pressed North");
        }else if(jbt.equals(jbt_south)){
            System.out.println("Pressed South");
        }else if(jbt.equals(jbt_east)){
            System.out.println("Pressed East");
        }else if(jbt.equals(jbt_west)){
            System.out.println("Pressed West");
        }else if(jbt.equals(jbt_center)){
            System.out.println("Pressed Center");
        }
    }
}
