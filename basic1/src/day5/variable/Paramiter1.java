package day5.variable;

public class Paramiter1 {
    public A methodA(){
        return new A();
        //return타입에도 메소드를 쓸 수 있다.
    }
    public static void main(String[] args) {
        Paramiter1 p = new Paramiter1();
        System.out.println(p.methodA());//A클래스주소@2f4d3709
    }
}
