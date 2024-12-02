package day5.variable;

class Z{
    int i;
}
public class StringTest6 {
    public static void main(String[] args) {
        Z z = new Z();//외부클래스 변수 사용시 인스턴스화
        System.out.println(z);//주소출력 @2f4d3709
        String s = new String("안녕");
        System.out.println(s);//문자 출력

        //z클래스는 주소번지 출력(일반적임)
        //String은 클래스임에도 문자열 출력(예외적)

    }
}
