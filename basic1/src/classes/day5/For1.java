package classes.day5;

import javax.swing.*;

public class For1 {
    public static void main(String[] args) {
        int is[] = {1, 2, 3};
        for (int i : is){
            System.out.println(i);
        }
        String []names  = {"홍길동", "이순신", "강감찬"};
        for (String s : names){
            System.out.println(s);
        }
        JButton []btns = new JButton[3];
        btns[0] = new JButton();
        btns[1] = new JButton();
        btns[2] = new JButton();
        for (JButton b : btns){
            System.out.println(b);
        }

    }
}
