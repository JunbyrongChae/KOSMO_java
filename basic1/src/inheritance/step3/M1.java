package inheritance.step3;

class M0{

}
public class M1 extends M0{
    public static void main(String[] args) {
        M0 m0 = new M0();
        M0 m1 = new M1();
        Class c = m0.getClass();
        System.out.println(c);
        Class c1 = m1.getClass();
        System.out.println(c1);
        System.out.println(c1.getName());//로그메세지를 출력할 때
    }
}
