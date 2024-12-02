package Quiz.step1;

public class Q3_1 {
    public static void main(String[] args) {
        int deptnos[] = null;
        try {
            deptnos = new int[3];
            System.out.println(deptnos[2]);
        } catch (Exception e) {
            System.out.println(e.toString());
        }finally {
            System.out.println("finally");
        }
    }
}
