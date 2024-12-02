package classes.day1;

public class B1 {
    //B2클래스에서 파라미터 B1을 갖는 생성자 없어서 에러
    B2 b2 = new B2(this);//this는 B1타입
    public B1(){
        System.out.println("B1디폴트생성자 호출");
    }
    public static void main(String[] args) {
    new B1();
    }
}
