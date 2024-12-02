package day6.variable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
ActionListener는 JButton에 대한 이벤트처리를 담당하는
추상메소드를 정의
그래서 입벤트를 처리하려면 반드시 actionPerformed메소드를 구현해야함
 */
class This1EventHandler implements ActionListener {
    JButton button = null;
    //JButton button = new JButton() //깊은 복사
    This1EventHandler(JButton button){
        this.button = button; //얕은 복사
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        Object source = e.getSource();
        //JButton sourse = (JButton)e.getSource();
        System.out.println(command+","+source);
        System.out.println(source==button);//true
    }
}


public class This1 {
    JFrame frame = new JFrame();
    JButton button = new JButton("로그인");
    This1EventHandler handler = new This1EventHandler(button);
    public  void initDisplay(){
        button.addActionListener(handler);
        frame.add("North",button);
        frame.setSize(600,450);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        This1 this1 = new This1();
        this1.initDisplay();
    }
}
