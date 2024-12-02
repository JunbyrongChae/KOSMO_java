package day7.variable;

public class M1 {
    //생성자는 클래스이름을 적는다
    //생성자는 반환타입이 없다
    //생성자는 인스턴스화 할때 호출된다
    //디폴트생성자는 파라미터가 없는거라서 JVM이 대신 처리한다.
    public M1(){
        System.out.println("M1디폴트 생성자");
        System.out.println(this);
    }
    public static void main(String[] args) {
        M1 m1 = new M1();
        String s1 = new String("Hello");
        System.out.printf("%s, %s\n",s1,m1);
        System.out.println("M1: "+m1);
        m1=null;
        System.out.println("M1: "+m1);//null
        //nullPointException
        /*
        m1.toString();//예외(Exception-디버깅,문제해결능력)가 발동하면 프로그램 중단
        System.out.println("M1: "+m1); */
        m1 = new M1();//초기화
        System.out.println("M1: "+m1); //this값 바뀜


    }
}
