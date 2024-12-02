package day5.variable;

public class Oper1 {
    public static void main(String[] args) {
        Oper1 o1 = new Oper1();
        System.out.println(o1);//주소출력
        int i = 1;
        int j = i+2; //1+2=3이 면수 j에 초기화
        System.out.println(j);//3출력
        j+=2; //=j+2 //+=는먼저 앞에 변수와 뒤에 2를 더하고 대입
        System.out.println(j);//5출력
    }
}
