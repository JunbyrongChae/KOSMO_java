package day3.variable;

public class C {
    //메소드 선언하기
    //리턴타입메소드이름(파라미터){}
    /*****************
     두 수의 합을 구하는 메소드 구현
     자바가 제공하는 메소드가 아니라 사용자가 정의한 메소드
     파라미터 갯수를 정햇고 파라미터 타입 정함
     리턴타입도 정함 (int+int=int, int+double=double)
     재사용성을 높이는 코드를 작성하는 첫 단계가 메소드중심의 코딩을 전개하는 것
     i,j는 정수형 - 실수 불가
     리턴타입은 정수(왜냐하면 파라미터타입이 둘 다 int이므로)
     ********************/
    static int hap(int i, int j){
        return i+j;}

    static double hap2(double k, double l){
        return k+l;
    }
    //static은 원본-하나,공유 모든클래스에 적용
    public static void main(String[] args) {
        //클래스안에 선언된 메소드 이더라도 main메소드 안에서 호출 하려면 - 인스턴스화
        System.out.println(hap(2,3));//5
        System.out.println(hap2(2,3));//5.0
        System.out.println(hap(2,3)+hap2(2,3));//10.0



    }
}
