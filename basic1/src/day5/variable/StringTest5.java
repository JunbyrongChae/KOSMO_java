package day5.variable;

import java.util.Scanner;

public class StringTest5 {
    public static void main(String[] args) {
        String mem_id = "kiwi";
        String user_id = null;
        System.out.println(mem_id.equals(user_id));
        Scanner sc = new Scanner(System.in);
        user_id = sc.nextLine();//재치환 될 때 새로운 주소번지 할당
        System.out.println(mem_id.equals(user_id));
    }
}
