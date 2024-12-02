package Prac.variable;

public class A1main {
    public static void main(String[] args) {
        A1 a1 = new A1();
        int j = 2;//j는 지변
        System.out.println(a1.i);//전변(클래스위치) - 0출력
        System.out.println(j);//지변(메소드위치) - 2출력

    }
}
