package Quiz.step1;
//변수의 적용범위
public class Q2v {
    public static void main(String[] args) {
        int x = 5;//main에서 선언된 지역 변수 = main에서만 작용
        Q2v p = new Q2v();
        p.doStuff(x); //1번째
        System.out.println("main x = "+x);//3번째
    }

    void doStuff(int x){
        System.out.println("doStuff x = "+x++);//x증가시키기 전에 출력한다.(후위증가)->증가 전 값 출력
    }//2번째
}

/******************************************
 What is the result?
 A. Compilation fails.
 B. An exception is thrown at runtime.
 C. doStuffx = 6 main x = 6
 D. doStuffx = 5 main x = 5 (v)
 E. doStuffx = 5 main x = 6
 F. doStuffx = 6 main x = 5
 ******************************************/