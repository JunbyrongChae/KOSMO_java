package Talk1.step1;

public class C {
    public static void main(String[] args) {
        Object obj = null;
        C c = new C();
        obj = c;
        c = (C)obj;
    }
}
