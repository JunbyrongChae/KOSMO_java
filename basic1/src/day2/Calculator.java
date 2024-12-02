package day2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 사용자에게 숫자 입력 받기
        System.out.print("첫 번째 숫자를 입력하세요: ");
        double num1 = scanner.nextDouble();
        // 연산자 입력 받기
        System.out.print("연산을 선택하세요 (+, -, *, /): ");
        char operator = scanner.next().charAt(0);
        System.out.print("두 번째 숫자를 입력하세요: ");
        double num2 = scanner.nextDouble();
        // 결과를 저장할 변수
        double result = 0;
        // 선택한 연산에 따라 결과 계산
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("0으로 나눌 수 없습니다.");
                    return;
                }
                break;
            default:
                System.out.println("잘못된 연산자입니다.");
                return;
        }
        // 결과 출력
        System.out.println("결과: " + result);
    }
}
