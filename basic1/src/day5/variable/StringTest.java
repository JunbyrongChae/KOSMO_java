package day5.variable;

public class StringTest {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = s1;
        String s3 = new String("Hello");
        String s4 = new String("Hello");
        System.out.println(s1==s2); //T
        System.out.println(s3==s4); //F
        System.out.println(s1.equals(s2)); //T
        //s1 문자열값과 s2문자열값이 같나? - T
        System.out.println(s3.equals(s4)); //T
        //s3 문자열값과 s4문자열값이 같나? - T (주소는 다름)
        //String객체를 만들 때 new를 사용하지 않으면(원시형처럼 초기화 가능)
        //기존에 같은 문자열이 메모리에 존재 유무를 체크하고
        //있다면 새로운 문자열을 갖는게 아니라 기존 주소번지를 갖는다.(하나를 공유-얕은 복사)

        //==는 객체 주소번지 비교
        //equals()의 경우 String 클래스에서 오버라이딩을 함으로써 문자열 간의 비교

    }
}

