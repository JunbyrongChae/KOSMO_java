package classes.day2;
//자료구조를 사용하는 경우 모두 Object단위로 읽고 쓸 수 있다.
//그래서 타입을 맞춰야 한다.
//이 문제를 개선하기 위해 제네릭이나 형전환이 필요
public class Type1 {
    public static void main(String[] args) {
        String msg = "Hello";
        Object obj = msg; //O
    //  String temp = new Object();//X
        Object obj1 = new String();//O
        Object obj2 = null;
        obj2 = msg;
    //  String msg2 = obj2;//X
        String msg2 = (String)obj2;//O
        System.out.println(msg2);
    }
}

/*
메신저 프로젝트 - 문자열 처리와 관련된 API활용합니다.
 */