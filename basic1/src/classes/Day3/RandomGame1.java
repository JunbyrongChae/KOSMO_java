package classes.Day3;

import java.util.Random;

public class RandomGame1 {
    //생성자를 최대한 활용하기 - 초기화
    //채번하기
    //1)메소드로 구현
    //2)생성자에서 하는 법
    //둘 중 재 사용성이 우수한 쪽은?
    //문제 - 만일 이 클래스를 재사용해야 하는데 깊은복사를 결정했다면? - 인스턴스화가 여러번 발생
    //=주소번지 바뀐다 -> 같은 타입의 클래스가 동시에 heep영역에 존재한다.
    // 그때마다 새로운 숫자가 채번 된다면, 정답이 계속 바뀌어도 되는건가?
    // 권장하는 방법은 채번하기 구현은 사용자정의 메소드로 처리 하세요
    //만일 새게임 버튼이 있다면...?
    //새게임 버튼이 눌릴 때 마다 채번하는 메소드가 호출되어야 한다.
    //이것이 화면을 그리는 것과 무관하게 독립적으로 처리되어야 하지 않을까?
    public  RandomGame1() {
        initDisplay();
        nanSu();
    }
    public void initDisplay() {
        System.out.println("initDisplay");
    }
    public void nanSu() {
        Random rand = new Random();
        rand.nextInt(10);//채번된 숫자가 정답이다.
        //정답은 게임이 유지되는 동안 불변
    }

    public static void main(String[] args) {
        RandomGame1 rg = new RandomGame1();
        System.out.println(rg);
        rg = new RandomGame1();
        System.out.println(rg);
        rg = new RandomGame1();
        System.out.println(rg);

    }////////////////// end of main
}////////////////////// end of RandomGame
