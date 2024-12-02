package day2;
//문제풀이
//두가지 답
import java.util.Scanner;

public class Scanner2 {
    public static void main(String[] args) {
        //1답안
        Scanner scanner = new Scanner(System.in);
        //터미널(명령프롬프트)에서 사용자가 입력한 값을 읽어올 수 있다.
        System.out.println("숫자를 입력하세요.");
        String first = scanner.next();
        System.out.println("첫번째 숫자 : " + first);
        System.out.println("한번 더 숫자를 입력하세요.");
        String second = scanner.next();
        System.out.println("두번째 숫자 : " + second);
        int i_first = Integer.parseInt(first);
        int i_second = Integer.parseInt(second);
        System.out.println("합계 : "+first+second);
        System.out.println("합계 : "+(i_first+i_second));
        //int+int=int / string+int=string / string+string=string
        //parseInt()-파라미터자리에 string타입 ex) parseInt("2")
        //Integer.parseInt("")- string을 int로 변환
        //출력값()먼저 실행. "합계 : "+다음 괄호로 묶어 int+int 실행.

        /* 2답안
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력하세요.");
        int first = scanner.nextInt();
        System.out.println("첫번째 숫자 : " + first);
        System.out.println("한번 더 숫자를 입력하세요.");
        int second = scanner.nextInt();
        System.out.println("두번째 숫자 : " + second);
        System.out.println("합계 : "+(first+second));
         */

        // 두 답중 더 좋은 것은?
        //->코드의 양은 늘어 나더라도 코드의 복잡도는 증가되지 않도록 작성해보세요.
    }
}
