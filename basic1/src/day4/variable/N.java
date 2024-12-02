package day4.variable;

public class N {
    //파라미터 1개, N클래스 타입
    void methodA(N n){
        System.out.println(n.toString());
    }
    //파라미터 1개, String타입
    void methodB(String msg){
        System.out.println(msg.toUpperCase());
    }
    public static void main(String[] args) {
        N n = new N();
        //n.methodA(n);
        String name = null;
        n.methodB(name);
    }
}