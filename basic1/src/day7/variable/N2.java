package day7.variable;

public class N2 {
    void methodA(){
        System.out.println("this : "+this);
    }
    public static void main(String[] args) {
        N2 n2 = new N2();
        System.out.println("n2: "+n2);
        n2 = null;//재정의 //안해도 상관 없지만 GC에 전달해서 candidate상태로 전환.
        n2 = new N2();//재정의
        n2.methodA();
    }
}
