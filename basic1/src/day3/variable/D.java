package day3.variable;

public class D {
    static int i=1;//전역변수 선언 자리, static
    int j=2;//전역변수, static
    public static void main(String[] args) {
        System.out.println(i);//static
        i=2; // 재정의
        System.out.println(i);//static 재정의
        D d = new D();//non-static은 인스턴스화
        d.j=3;
        System.out.println(d.j);
        d.j=4;
        System.out.println(d.j);
    }
}