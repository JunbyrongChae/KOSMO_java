package day2;
/*
    변수선언하기 : 타입(int(정수), String(문자)) v 변수명
    변수 초기화하기.(기초아님-책으로 공부하는게 아님 책은 참고만)
    1)타입을 적지 않습니다. 왜?-타입을 적으면 변수선언이라 초기화에는 필요없음
      자바에서는 변수선언과 초기화를 분리해서(2줄에 나눠서) 작성가능.
    2)주의사항 ->합법적인것과 불법적인것을 구분할 수 있어야 함. -컴파일 타입 에러를 잡아야 함.(디버깅)
      -> 허용과 불허용을 구분 할 수 있어야한다.
      :syntax 타입>변수명>대입연산자
      :대입연산자 - 오른쪽에 있는 값(원시형타입)을 왼쪽에 대입
       -> 부르면 값이 출력
    3)원시형타입 vs 참조형타입(주소번지, RAM-stack영역,heep영역)
 */

public class Login {
    //전역변수(클래스 다음위치)는 선언과 초기화 분리 안됨
    //프로그래밍이란? 입력(변수)>처리(메소드:제공되는 메소드(JVM)/사용자가 정의하는 메소드)>출력
    //선언부 - 변수(명사형)선언, 메소드(동사형)선언
    //사용자가 정의하는 메소드
    //아이디 중복검사를 할때는 파라미터가 한개만 필요합니다 - 기초아님.경험많이.
    //boolean - true/false,yes/no(판단,선택) ->if, 기준이 중요, 흐름을 바꿈
    //아이디 중복검사의 결과는 판정이다. - 사용 가능 / 불가능
    boolean isIDcheck(String mem_id){
        return false;
    }
    //파라미터의 갯수는?
    String LoginAction(String mem_id, String mem_pw){
        return "tomato";

    }
    public static void main(String[] args) {
        String mem_id = "tomato"; // mem_id는 변수이름.
        mem_id = "kiwi"; // 재정의
        String mem_pw = "123";
    }
}
