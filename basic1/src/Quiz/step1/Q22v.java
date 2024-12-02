package Quiz.step1;
//while문
public class Q22v {
    public static void main(String[] args) {
        int x=12;
        while (x<10){
            x--;
        }
        System.out.println(x);
    }
}

/****************************************
 What is the result?
 A. 0 //불가능
 B. 10 int //x = 10;
 C. 12 (v)
 D. Line 29 will never be reached. //int x <10일 경우
********************************************/
//do..while 문과는 다르게 먼저 조건을 따진다. 한번도 실행이 되지 않을 수도 있다.