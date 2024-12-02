package Task.Logic;


import java.util.Random;
import java.util.Scanner;


public class Task {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        int cop_nub = rd.nextInt(10);
        int ins_nub;
        int count=0;

        System.out.println("숫자 맞추기 게임!");
        System.out.println("0~9사이의 숫자를 입력하세요.");

        for (count=0;count<5;){
            System.out.println("남은입력횟수 : "+(5-count));

            ins_nub = sc.nextInt();

            if(ins_nub < 0 || ins_nub > 9){
                System.out.println("9이상은 입력 할 수 없습니다.");
                continue;
            }

            count++;

            if (ins_nub == cop_nub){
                System.out.println("정답입니다!");
                System.out.println("총 입력 횟수 : "+count);
                sc.close();
                return;
            }else if(ins_nub < cop_nub){
                System.out.println("더 큰 수를 입력하세요.");
                System.out.println("현재 입력 횟수 : "+count);

            }else {
                System.out.println("더 작은 수를 입력하세요.");
                System.out.println("현재 입력 횟수 : "+count);
            }
        }
        System.out.println("실패!!");
        System.out.println("정답은 "+cop_nub+" 입니다.");
        sc.close();
    }
}


/*
0~9사이에 임의의 숫자를 채번하고 그 숫자를 맞추는 게임을 구현 하시오.
기회는 5회 제한
힌트는 컴퓨터가 채번한 숫자보다 적으면 높이고
높으면 낮추고 맞추면 "정답입니다"와 함께 프로그램 종료되도록 구현하시오
 */