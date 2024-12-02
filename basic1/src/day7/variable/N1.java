package day7.variable;

public class N1 {
    void methodA(){
        System.out.println("this : "+this);
    }
    public static void main(String[] args) {
        N1 n1 = new N1();
        System.out.println(n1);
        n1.methodA();
        n1 = null;//재정의
        System.out.println(n1);
        n1 = new N1();//재정의
        System.out.println(n1);
        n1.methodA();
    }
}
