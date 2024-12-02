package Quiz;

public class Test3 {
    public static void main(String[] args) {
        Test3[] t3 = new Test3[3];
        System.out.println(t3.length);//3
        System.out.println(t3);
        System.out.println(t3[0]);//null
        System.out.println(t3[1]);//null
        System.out.println(t3[2]);//null

        t3[0] = new Test3();
        Test3 t4 = new Test3();
        System.out.println(t3[0]);
        System.out.println(t4);
        t3[0] = t4;
        System.out.println(t3[0]);
        System.out.println(t3[0] == t4);//true
    }
}
