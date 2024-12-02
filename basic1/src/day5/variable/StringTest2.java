package day5.variable;

public class StringTest2 {
    public static void main(String[] args) {
        //String은 클래스 중에서 유일하게 new를 사용하지 않고도 객체를 만들 수 있다.
        String s1 = "Hello";
        //s1 = s1 + " World";
        String s2 = "Hello5";
        System.out.println(s1.equals(s2));
        System.out.println(s1==s2);
        System.out.println(s1+" World");
        System.out.println(s1); //'World'는 날아감


        String s3 = "haha";
        s3.replace("h","j");
        System.out.println(s3);//haha
        s3=s3.replace('h','j');//jaja
        System.out.println(s3);
    }
}
/*
String은 연속된 문자열을 표현하는 클래스입니다.
클래스는 언제나 참조형
연속된 문자(char, Character)를 저장하는 메모리 할당
위 데이터를 처리하는 각종 메소드 지원함(ex : .equals())
**************************************************
Java의 String은 immutable이다. - 불변객체
: 변경불가. 원본이 안바뀐다.
문제
select문 처럼 여러 줄에 여러 단어를 길게 쓸 때 String을 쓰면
메모리누수가 생기는건 아닐까?
 */