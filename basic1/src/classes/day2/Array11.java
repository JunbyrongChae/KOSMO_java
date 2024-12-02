package classes.day2;

public class Array11 {
    public static void main(String[] args) {
        //new로 배열을 선언하면 아직 초기화가 안된거라서  디폴트값 가짐
        boolean[] bs = new boolean[3];//false, false, false
        bs[0] = true; //true, false, false
        //반복되는 코드는 항상 옳지 않다. - 개선방법 항상 고민하는 습관
        //출력하는 문장에서 같은 것.(system.out.println,bs,[])
        //다른 것 []안에 숫자만 다름 - 반복문(for문)
        System.out.println(bs[0]);//true
        System.out.println(bs[1]);//false
        System.out.println(bs[2]);//false
        bs[1] = true; //true, true, false
        System.out.println(bs[0]);//true
        System.out.println(bs[1]);//true
        System.out.println(bs[2]);//false

        //for(선언 및 초기화;조건식-반환값;증감연산자){}
        //주의 : for문 안에서 변수선언 한 경우 밖에서 접근 불가.
        //조건문 생략시 무한루프에 빠짐.
        //반복문은 항상 무한루프에 대한 방지코드를 고려
        //무한루프에 빠지면 다음코드는 실행기회를 잃음.
        //for문 사용시 조건문 확인
        int i;
        for(i=1;i<3;i++){
            System.out.println("for문");
        }
        System.out.println(i);//3
    }
}
