package Quiz.step1;
//실행문
public class Q1v {
    public static void main(String[] args) {
        int x = 5;
        boolean b1 = true;
        boolean b2 = false;

        if((x==4) && !b2) //&&는 둘 다 true일 때 true다 : x==4는 거짓이므로 false
            System.out.println("1"); //참일 때 실행
            //if문에서 {}가 없으면 다음행까지만 적용된다. 따라서 아래println은 if문과 관계없이 작동된다.
            System.out.println("2"); //거짓 일 때 실행 : 9행의 결과가 거짓이기에 실행
        if ((b2 = true) && b1)  //b2의 값은 false인데 true값으로 대입하여 true, b1도 true
            System.out.println("3"); //참일 때 실행 : 12행의 결과가 참으로 실행
    }
}

/****************************************
 What is the result?
 a. 2
 b. 3
 c. 1 2
 d. 2 3 (v)
 e. 1 2 3
 f. Compilation fails.
 g. Au exceptional is thrown at runtime.


 ***************************************/