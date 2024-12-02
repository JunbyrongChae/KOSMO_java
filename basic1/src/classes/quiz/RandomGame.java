package classes.quiz;

import java.util.Random;
import java.util.Scanner;

public class RandomGame {
    //멤버지만 전역아님
    int com = -1;//end of file

    public RandomGame() {
        Random r = new Random();//캡슐화
        nansuPrint(r);
        com = r.nextInt(10);//0~9
    }

    //게임 진행하기
    public void goGame() {
        System.out.println("0~9사이의 숫자를 입력하세요.");
        Scanner sc = new Scanner(System.in);

    }
    public void nansuPrint(Random r) {
        for(int i = 0 ; i < 10 ; i++){
            System.out.println(r.nextInt(10));
        }
    }
    public static void main(String[] args) {
        RandomGame rg = new RandomGame();
        rg.goGame();
    }
}


/*
단위 테스트와 통합테스트를 하는 사람
테스트시나리오를 적어내는 개발자 = 해본사람
 */