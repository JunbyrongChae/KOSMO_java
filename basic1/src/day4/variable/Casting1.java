package day4.variable;

public class Casting1 {
    public static void main(String[] args) {
        int i = 1;//정수형
        double pi = 3.14;//실수형
//          (casting연산자=형전환 연산자)
//          -> 실수를 정수로 변환, 소수점아래 탈락.
        i = (int)pi; //(int)
        i = (int)3.14;
        System.out.println(i);//3
        pi = i;
        System.out.println(pi);//3.0
    }
}
