package day2;
//디버깅
//가상머신이 실행하는 순서대로 클론코딩 해보는것은 동의
//그러나 무작정 받아쓰기는 비효율적
public class A3 {
    //선언부 -전역변수 선언
    //사용자 정의 메소드
    //지변은 초기화를 생략 할 수 없다.
    //i,j 지변이나 초기화 안됨. 메소드 호출시 값을 갖는다. (값에 의한 호출, call by value)
    int hap(int i, int j){
        //파라미터자리에 변수선언 가능
        return i+j;
    }
    // main메소드>17(a3 객체생성)>18(메소드 호출)>10~13>18(리턴값이있어 돌아옴, 디버깅시 확인가능, 값을 받음)>19~21
    public static void main(String[] args) {
        //인스턴스화 - 클래스가 heep메모리에 로딩됨
        A3 a3 = new A3();
        int result = a3.hap(2,3); //메소드 이름 뒤에 ;으로 끝나면 메소드 호출
        System.out.println(result);
    }
}