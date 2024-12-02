package day3.variable;

public class A {
    public String toString(){
        return "I'm A class";
    }
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a);
        System.out.println(a.toString());
        a = null;
        System.out.println(a);
        a = new A();
        System.out.println(a);
        // 타입은 같지만 객체가 다름.(주소 다름)

    }
}
