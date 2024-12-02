package day6.variable;

import javax.swing.*;

public class NullPoint1 {
    public static void main(String[] args) {
        String s = null;
        System.out.println(s);//null
        System.out.println(s.toString());//nullpoint exception
        JFrame jf = null;//선언만 됨. 타입만 정해짐.
        // jf = *** new *** JFrame(); //생성부 //구현체 class
        System.out.println(jf);//null
        System.out.println(jf.toString());//nullpoint exception
    }
}


/*************************************
 선언부 = 생성부     :다른게 올 수 있다.
 타입     (구현체)클래스
 *************************************/