package day4.variable;

public class H {
    int i=1;//전역변수=멤버변수(global variable=member variable)


    public static void main(String[] args) {
        //인스턴스화를 3번 하였으므로 H타입의 클래스가 3개 생성됨
        //3개의 클래스는 heep메모리에 상주한다.
        H h1 = new H();
        h1.i =2;
        //전역변수는 인스턴스 변수에 따라서 서로다른 값을 초기화 할 수 있다.
        H h2 = new H();
        h2.i =3;
        H h3 = new H();
        h3.i =4;
        System.out.println(h1+","+h1.i);//2
        System.out.println(h2+","+h2.i);//3
        System.out.println(h3+","+h3.i);//4


    }
}
