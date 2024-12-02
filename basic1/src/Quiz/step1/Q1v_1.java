package Quiz.step1;
//실행문
public class Q1v_1 {
    public static void main(String[] args) {
        int i = 1;
        int j = 2;
        if((i==j)&(++i<j--)){//조건 둘 다 지나며 값이 변함
            System.out.println("참일때 : i-"+i+" j-"+j);
        }else {
            System.out.println("거짓일때 : i-"+i+" j-"+j);
        }
       //거짓일때 : i=2 j=1

        i = 1;
        j = 2;
        if((i==j)&&(++i<j--)){//조건1이 F라서 조건2생략함 -> 값 유지
            //i=1-2>2 j=2-2-2(비교후 결과에 +1)>3
            System.out.println("참일때 : i-"+i+" j-"+j);
        }else {
            System.out.println("거짓일때 : i-"+i+" j-"+j);
        }
        //거짓일때 : i=1 j=2
    }
}
