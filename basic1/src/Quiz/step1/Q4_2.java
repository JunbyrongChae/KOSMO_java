package Quiz.step1;

public class Q4_2 {
    int i = 1;
    Q4_2 q = null;
    void m(int i, Q4_2 q) {
        System.out.println(q);
        q=new Q4_2();
        System.out.println(q);
        System.out.println(this.q);
        System.out.println(this);
    }
    public static void main(String[] args) {
        Q4_2 q = new Q4_2();
        q.m(1, q);
    }
}
