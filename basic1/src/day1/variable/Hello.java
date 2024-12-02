package day1.variable;
// 용어정리 필요 - GPT가 다 해줌.
// vscode에서 markdown파일로 작성해보고 pdf로 변환연습
// 클래스 선언하기 - 접근제한자가 public이니까 누구나사용
// 사용자정의 클래스 입니다. //JVM이 제공하는 클래스가 있습니다. - String, System(로컬PC-윈도우-O/S)
// Hello는 클래스이름입니다. Hello클래스 타입이라고도 말 합니다.
// Hello.java 파일로 작성하였습니다.
// 컴파일하고나면 확장자가  .class로 바뀐다.
// 클래스 안(좌우중괄호)에는
public class Hello {// 클래스 선언할 때는 대문자로 시작.-참조형 타입.<->원시형 타입
    // 우중괄호와 좌중괄호(scope)가 있는 영역 안에서만 사용 할 수 있는 변수는 무엇? - 지역변수(aka지변)
    // 메인메소드의 원형.-약속. 못바꿈.
    // public - 접근제한자라고 함. everybody-access modifier
    // void : 반환값이 없다. 리턴값이 없다. 메소드 호출로 돌려받을 수 있는 값이 없다.
    // 어떤 이름 뒤에 괄호가 있으면 메소드 입니다.
    // main메소드 괄호 안에 변수선언(타입은 String[] args이고, 변수는 args입니다.)이 있다.
    // main메소드 뒤에 좌우중괄호가 있으면 메소드선언. 호출아님.
    // 메소드 호출은 ;로 끝남 - syntax보고 구별합니다.
    // 또는 또는 메소드 구현 입니다. 라고 말합니다.
    // 클래스 내부(좌/우중괄호)에서 선언된 함수는 자바에서는 메소드라고 부른다.
    // 메소드 선언시 파라미터자리에 변수를 선언할 수 있다.
    // 이 때 파라미터 자리에 선언된 변수는 지변이다.
    // 메소드에 파라미터 자리는 변수 선언만 가능!(초기화x)
    // 문법적으로 허용되는 코드와 허용되지 않는 코드를 적어봅니다.
    public static void main(String[] args) {//좌우중괄호를 사용해 메소드 영역표시
        // scope -범위 - 범위안에서 (값이)유지됩니다. (변수를)사용할 수 있습니다. 호출할 수 있습니다.
        // 클래스의 scope라면 전역변수(aka전변) - 전변 -변수선언 위치
        // 이(main메소드) 안에 선언된 변수는 모두 지역변수.(위치)
        // 자바에서는 문자열을 담을 수 있는 클래스를 제공.- String클래스
        // 지변은 반드시 초기화를 해야한다.
        // String msg = "Hello java";//변수선언(기초)과 초기화(기초x)

        //msg = "Hello Java"; 초기화를 먼저하면 에러남 (선언 후 초기화!)
        String msg;// 변수선언만 함. 초기화x -> 출력오류
        msg = "Hello Java"; // 초기화O ->정상출력
        System.out.println("Hello Java");// -> \r\n
        System.out.println(msg);// 나는 변수를 사용했어요.
                        // ln의 유무는 줄바꿈 유무
    }//// end of main
}//////// end of Hello
//한줄 주석입니다. - 실행안됨
/* 여러줄 주석입니다. - 실행안됨
선언이 먼저이고 사용(호출)은 나중입니다.
변수를 선언 할 때는 변수이름 앞에 타입을 적어야 합니다.
문자열을 선언할 때는 String타입을 사용합니다.
String타입은 문자열을 담을 수 있는 타입입니다.
카톡(동시에 여러사람을 관리, 대화순서 중요, 읽기/쓰기-IO)
프로그래밍이란 입력(Input, 파라미터)받은 값을 처리하고 그 결관를 출력(Println())하는 것 (String[] args = 파라미터, []변수, {}배열)

 */