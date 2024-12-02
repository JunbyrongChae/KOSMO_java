package classes.day1;

public class B2 {
    B1 b1 = null;//얕복
    //B1 b1 = new B1(); 깊복 - 복사본 -오버플로우
    public B2(B1 b1){
        System.out.println("B2디폴트생성자입니다.");
        this.b1=b1;
    }
    public static void main(String[] args) {

    }
}
