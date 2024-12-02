package day2;

import java.util.Scanner;

public class Scanner1 {
    //사용자가 정의하는 메소드
    //제공되는 메소드가 아니고 개발자가 같은 이름의 메소드를 선언
    String next(){
        return "안녕";
    }
    int nextint(){
        return 1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner1 scanner1 = new Scanner1();
        int a = scanner1.nextint();
        System.out.println("안녕");//문자열 상수사용. 변수사용하는 방향을 추천
        System.out.println(a);
        System.out.println(scanner1.next());
    }
}
