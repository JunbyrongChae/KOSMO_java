package Quiz.step1;
//this.x와 x의 차이
public class Q4_1 {
    int x = 12;
    public void method(int x) {
        x+=x; // x=x+x; -> x=5+5
        System.out.println(x);
        System.out.println(this.x);
    }
    public void method(int x,Q4_1 t) {

    }
    public static void main(String[] args) {
        Q4_1 t = new Q4_1();
        System.out.println(t);
        t.x = 10;
        //t = new Q4_1();
        System.out.println(t);
        t.method(5);
        t.method(5,t);
    }
}


/**********************************************
 What is the output from line 5 of the Test class?
 // Test   클래스의 5    라인에 출력되는 것은?
 A. 5
 B. 10 (v)
 C. 12
 D. 17
 E. 24
 ***********************************************/