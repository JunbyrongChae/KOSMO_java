package day2;
/*
에러에는 두가지 에러 존재
compile time에러 - 문법 에러 -> .class파일 생성불가 -> 실행불가
run time에러 - 실행에러
 */
import java.util.Scanner;
//사용자가 입력하는 값은 반드시 유효성 검사를 해야함.
//후에 예외처리 수업에서 자세히 다룸
public class Scanner2P {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력하세요.");
        int first = scanner.nextInt();
        System.out.println("첫번째 숫자 : " + first);
        System.out.println("한번 더 숫자를 입력하세요.");
        int second = scanner.nextInt();
        System.out.println("두번째 숫자 : " + second);
        System.out.println("합계 : "+(first+second));
    }
}
