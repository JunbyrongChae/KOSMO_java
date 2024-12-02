package Prac.variable;

import java.util.Random;
import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        // Scanner와 Random 객체 생성
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 컴퓨터가 1부터 100까지의 랜덤 숫자 생성
        int targetNumber = random.nextInt(100) + 1;

        int guess = 0; // 사용자가 입력한 숫자를 저장할 변수
        int attempts = 0; // 시도 횟수를 저장할 변수

        System.out.println("1부터 100 사이의 숫자를 맞춰보세요!");

        // 정답을 맞출 때까지 반복
        while (guess != targetNumber) {
            System.out.print("숫자를 입력하세요: ");
            guess = scanner.nextInt(); // 사용자로부터 숫자 입력 받기
            attempts++; // 시도 횟수 증가

            // 사용자가 입력한 숫자와 컴퓨터의 숫자를 비교
            if (guess > targetNumber) {
                System.out.println("더 작은 숫자를 입력하세요.");
            } else if (guess < targetNumber) {
                System.out.println("더 큰 숫자를 입력하세요.");
            } else {
                System.out.println("정답입니다! " + attempts + "번 만에 맞췄습니다.");
            }
        }

        // Scanner 닫기
        scanner.close();
    }
}
