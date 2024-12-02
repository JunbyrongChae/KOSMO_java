package classes.design;
//인스턴스화와 null
class B1{
    int i =1;
}

public class B1Main {
    public B1Main() {

    }
    public B1Main(B1 b1) {
        System.out.println("B1Main(B1)-"+b1);//원본 얕복
        b1.i = 3;
        System.out.println("B1Main(B1)-"+b1);
    }
    public static void main(String[] args) {
        //i를 2로 변경
        B1 b1 = null;//선언부 - 객체(참조형-주소번지만 있는)만 해당
        //아무것도 없다. 비어있다. -> 아무것도 참조하지 않는다. -> 객체가 아니다.
        //b1.i =2; -> NullpointerException
        b1= new B1();// 생성부
        b1.i = 2;
        System.out.println(b1.i);
        System.out.println(b1);
        //main메서드 안에서 선언됨 b1은 지변인데 이것을 다른 생성자나 다른 메서드에서 사용하려면 파라미터로 넘겨서 사용.
        B1Main bm = new B1Main(b1);
        System.out.println("main() B1-"+b1);
        System.out.println(b1.i);
    }
}
