package day3.variable;

public class F {
    int x =1;
    public static void main(String[] args) {
        F f = new F();
        //같은 변수에 대해서 초기화를 여러번 할 수 있다.
        //변수는 한번에 하나만 담을 수 있다.
        //전역변수는 '인스턴스변수.변수명'으로 호출(or 초기화) 가능.
        f.x = 10;
        System.out.println(f.x);
        f.x = 20;
        System.out.println(f.x);
    }
}
