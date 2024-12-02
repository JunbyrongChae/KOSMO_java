package day3.variable;
//static이 붙은 메소드 안에서는 non-static변수 사용불가
//즉 non-static변수 안에서는 사용가능.
public class E {
    //변수x는 전역변수이지만 static붙지않아 hap안에서 호출가능
    //하지만 메인 안에서 불가
    //왜냐하면 메인에는 static이 있으니까.
    int x;
    void hap(int i, int j){
        System.out.println(i+j);
        System.out.println(x);
    }
    public static void main(String[] args) {
        //System.out.println(hap(2,3));
        //System.out.println(x);//호출 불가
        E e = new E();//인스턴스화
        e.hap(1,2);
        System.out.println(e.x);//호출가능 > 0

    }
}
