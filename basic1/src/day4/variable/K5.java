package day4.variable;

public class K5 {
    //선언부 변수/메소드 둘 다 가능
    int a;
    int speed;

    //생성자 - 선언 가능.
    public K5(){
        speed = 0;
        System.out.println("K5 디폴트 생성자 입니다.");
    }

    //사용자정의 메소드
    public void speedUp(){
        speed = speed +1;//지변이라 안됨 ->컴파일에러
        a = a +1;//전변이라 가능
    }

    //static블록 - 잘 안씀
    static {
        //K5가 전시장에 전시되어 있는 상태.->정지상태->초기값 0
        int speed = 0;
        System.out.println("static블록이 호출 되었습니다.1(main()보다 먼저)"); //\n(줄바꿈)
    }////////////// end of static

    //메인메소드
    public static void main(String[] args) {
        System.out.println("static블록이 호출 되었습니다.2");
        K5 k5 = new K5(); //생성자 호출

    }////////////// end of main
}////////////////// end of K5
