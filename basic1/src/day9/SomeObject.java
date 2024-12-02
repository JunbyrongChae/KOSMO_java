package day9;
class Some{
    SomeObject so = null;
    public Some(){
        System.out.println("Some Constructor");
    }
    //같은 이름의 생성다를 여러개 가진다.(파라미터의 갯수가 다르거나 타입이 다름.)
    public Some(SomeObject so){
        System.out.println("Some Constructor : "+so);
        this.so=so;
    }
}
public class SomeObject {
    //선언부
    //클래스와 클래스 사이에 관계가 있다.
    //아래 코드가 언제 초기화 되는가.
    //어떤 생성자가 먼저 출력되는가?
    Some some = new Some(this);//얕복/깊복
    //생성자 - 메소드 활용(선언과 호출 유사 - 다른점은 리턴이 없다)
    public SomeObject() {
        System.out.println("SomeObject Constructor");
    }
    //사용자 정의메소드
    public void methodA() {    }
    //메인메소드
    public static void main(String[] args) {
        SomeObject so =new SomeObject();//생성자 호출-멤버초기화
        System.out.println("main : "+so);
    }
}
