package day5.variable;
// nullpoint exception
public class A {
    public int i; //전역변수 선언자리 //정석은 접근제한자를 붙임.
    public void hap(int i, int j){
    }
    public static void main(String[] args) {
        //non-static변수 i는 static영역에서 사용 불가.
        //사용하려면 인스턴스화
        A a = null; //참조형일 때 사용하는 리터럴이 null입니다.
        System.out.println(a);//null출력
        System.out.println(a.toString());//toString()은 Object(부모)메소드 상속됨
        System.out.println(a.i);//컴파일타임 합법, 런타임은 에러.//NullPointException
    }
}
