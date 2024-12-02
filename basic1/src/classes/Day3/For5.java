package classes.Day3;
// 변수 scope(범위)이슈
// 내가 선언한 위치의 변수가 어디까지 영향을 끼치는가? - 기초아님
// 멤버/전역/지역 변수 - 클래스설개를 한다(변수설계,메소드설계,생성자설계 포함)
// (메소드설계가 포함되는건 리턴타입도 변수, 파라미터자리도 변수)
public class For5 {
    public static void main(String[] args) {
        int i = 0;
        for(i=0;i<=10;i=i+2){
            System.out.println(i);
        }/////////// end of for
        //for문 밖에서도 변수i에 접근하려면 for문 밖에서 선언할 것.
    }/////////////// end of main
}/////////////////// end of class
