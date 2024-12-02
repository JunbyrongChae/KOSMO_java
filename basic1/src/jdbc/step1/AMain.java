package jdbc.step1;
class A {

}
public class AMain {
    public static void main(String[] args) {
        A[] as = new A[5];
        System.out.println(as.length);
        for (A a1:as) {
            System.out.println(a1);
        }
        A a = new A();
        System.out.println(a);//@1d81eb93
        as[0] = a;
        System.out.println(as[0]);//@1d81eb93
        as[0] = new A();
        System.out.println(as[0]);//@7291c18f

    }
}
