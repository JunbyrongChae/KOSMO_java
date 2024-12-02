package Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NumberBaseballGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> answer = generateAnswer();
        int attempts = 0;
        boolean gameWon = false;

        System.out.println("숫자 야구 게임을 시작합니다! 0부터 9까지의 서로 다른 3자리 숫자를 맞춰보세요.");

        while (!gameWon) {
            System.out.print("세 자리 숫자를 입력하세요: ");
            String userInput = scanner.nextLine();
            List<Integer> guess = parseInput(userInput);

            if (guess == null) {
                System.out.println("유효하지 않은 입력입니다. 0부터 9까지의 서로 다른 세 자리 숫자를 입력하세요.");
                continue;
            }

            attempts++;
            int[] result = checkGuess(answer, guess);
            int strikes = result[0];
            int balls = result[1];

            if (strikes == 3) {
                gameWon = true;
                System.out.println("축하합니다! " + attempts + "번 만에 맞추셨습니다.");
            } else {
                System.out.println(strikes + " 스트라이크, " + balls + " 볼입니다.");
            }
        }

        scanner.close();
    }

    // 정답 숫자 생성
    private static List<Integer> generateAnswer() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, 3);
    }

    // 사용자 입력을 숫자 리스트로 변환
    private static List<Integer> parseInput(String input) {
        if (input.length() != 3) {
            return null;
        }

        List<Integer> guess = new ArrayList<>();
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return null;
            }
            int digit = Character.getNumericValue(c);
            if (guess.contains(digit)) {
                return null;
            }
            guess.add(digit);
        }

        return guess;
    }

    // 사용자 입력과 정답 비교
    private static int[] checkGuess(List<Integer> answer, List<Integer> guess) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (guess.get(i).equals(answer.get(i))) {
                strikes++;
            } else if (answer.contains(guess.get(i))) {
                balls++;
            }
        }

        return new int[]{strikes, balls};
    }
}
