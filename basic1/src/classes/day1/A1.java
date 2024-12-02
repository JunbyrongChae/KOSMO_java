package classes.day1;

public class A1 {
    A2 a2 = new A2();
    public A1(){
        System.out.println("A1디폴트생성자 호출");
    }
    public static void main(String[] args) {
        A1 a1 = new A1();
    }
}
