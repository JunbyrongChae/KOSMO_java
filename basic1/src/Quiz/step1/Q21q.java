package Quiz.step1;
//do while문
public class Q21q {
    public static void main(String[] args) {
        int x=0;
        int y=10;
        do {
            y--;
            ++x;
        }while(x<=5); //x가 5가 되는 순간 종료
        //x<=5 //x가 5일때도 반복문 실행
        System.out.println(x+","+y);
    }
}

/*****************************************************
 What is the result?
 A. 5,6
 B. 5,5
 C. 6,5
 D. 6,6
 *****************************************************/