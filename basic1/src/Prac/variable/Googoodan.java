package Prac.variable;

import java.util.Scanner;

public class Googoodan {
    public static void main(String[] args) {
        //내 답변
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력하세요: ");
        int first = scanner.nextInt();
        System.out.println();
        System.out.println(first+" * "+"1 = "+(first*1));
        System.out.println(first+" * "+"2 = "+(first*2));
        System.out.println(first+" * "+"3 = "+(first*3));
        System.out.println(first+" * "+"4 = "+(first*4));
        System.out.println(first+" * "+"5 = "+(first*5));
        System.out.println(first+" * "+"6 = "+(first*6));
        System.out.println(first+" * "+"7 = "+(first*7));
        System.out.println(first+" * "+"8 = "+(first*8));
        System.out.println(first+" * "+"9 = "+(first*9));

        //GPT답변
        System.out.print("숫자를 입력하세요 (1 ~ 9): ");
        int number = scanner.nextInt();

        // 입력된 숫자가 1 ~ 9 사이인지 확인
        if (number >= 1 && number <= 9) {
            // 구구단 출력
            System.out.println(number + "단 출력:");
            for (int i = 1; i <= 9; i++) {
                System.out.println(number + " * " + i + " = " + (number * i));
            }
        } else {
            // 1 ~ 9 사이가 아닌 숫자 입력 시 오류 메시지 출력
            System.out.println("잘못된 입력입니다. 1에서 9 사이의 숫자를 입력하세요.");
        }


    }
}
