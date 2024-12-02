package Prac.variable;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("첫 번째 숫자를 입력하세요. :");
        double first = scanner.nextDouble();
        System.out.println("연산자를 입력하세요 (+, -, *, /)");
        char operator = scanner.next().charAt(0);
        System.out.println("두 번째 숫자를 입력하세요 :");
        double second = scanner.nextDouble();
        double result = 0;
        switch (operator) {
            case '+':
                result = first + second;
                break;
            case '-':
                result = first - second;
                break;
            case '*':
                result = first * second;
                break;
            case '/':
                if (second != 0) {
                    result = first / second;
                } else {
                    System.out.println("0으로 나눌 수 없습니다.");
                    return;
                }
                break;
            default:
                System.out.println("잘못된 연산자입니다.");
                return;

        }
        System.out.println("결과 : "+first+" "+operator+" "+second+" = "+result);

    }
}
