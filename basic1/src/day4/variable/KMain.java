package day4.variable;
class K{
    int i;
}
public class KMain {
    public static void main(String[] args) {
        K k = new K();//인스턴스화1
//  (선언부)   (생성부) -> 타입 같다.
        //K k;(선언부)
        //k = new K();(생성부)
        //;=호출
        System.out.println(k.toString());//=classK와 같은 k K@2f4d3709
        k = null;//초기화
        System.out.println(k);//null
        // System.out.println(k.toString());//NullPointerException-런타임 에러
        k = new K();//인스턴스화2, 재정의
        //같은문자 k지만 주소는 다름
        System.out.println(k.toString());//classK와 다른 k K@4e50df2e
    }
}
