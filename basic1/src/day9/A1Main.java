package day9;
class A1{
    A1Main am = null;//주의 : new하지 말것-반복호출이 되어 stack memory overflow
    A1(){}
    //생성자 파라미터 자리에 null이 올 수 있읍니다. 기억하기
    //참조형 타입을 파라미터로 넘기는 경우 null유무 체크하기
    A1(A1Main am){
        //am = new A1Main();
        if(am == null){
            System.out.println("파라미터로 넘어온 주소번지가 아무것도 가리키지 않음.");
        }else{
            //위치1
            am.m();
            //this.am = am;//스팟 13번에서 정상적으로 호출됨. 나는 왜?
            //위치2
            other();
        }
    }
    void other(){
        this.am.m();
    }
}
public class A1Main {
    //파라미터 자리의 null은 타입만 있고 실체가 없다.
    //타입- A1Main
    A1 a1 = new A1(this);
    void m(){
        System.out.println("m() 호출");
    }
    public static void main(String[] args) {
        new A1Main();
    }
}