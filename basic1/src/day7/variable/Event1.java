package day7.variable;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Event1 extends JFrame implements ActionListener {
    JButton button = new JButton("전송");

    public void initDisplay(){//내가 정하는 이름
        this.add(button);//Event1클래스가 JFrame을 상속 받았지만 여전히 this는 자기자신을 참조하는 수정자이므로 Event1타입이다
        //actionPerformed메소드가 호출되려면
        //addActionListener()호출
        button.addActionListener(this);
        button.setBackground(new Color(41, 124, 101));
        button.setForeground(new Color(255, 249, 169));
        this.setSize(400,500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        Event1 e1 = new Event1();
        e1.initDisplay();
    }

    @Override
    //callback method-개발자가 직접 호출하지 않고 이벤트가 발생시 JVM이 호출
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        JButton jbt = (JButton)source;
        System.out.println("actionPerformed 호출");

    }
}
