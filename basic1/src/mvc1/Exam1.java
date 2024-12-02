package mvc1;
class A1{
    A2 a2 = new A2();
    void methodA(){
        System.out.println("A1.methodA");
        a2.methodA();
    }
}
class A2{
    A3 a3 = new A3();
    void methodA(){
        System.out.println("A2.methodA");
        a3.methodA();
    }
}
class A3{
    void methodA(){
        System.out.println("A3.methodA");
    }
}
public class Exam1 {
    public static void main(String[] args) {
        A1 a1 = new A1();
        a1.methodA();
    }
}
