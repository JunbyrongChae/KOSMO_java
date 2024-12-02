package Prac.variable;
//toString메소드는 누가 정의? - Object
//자바에서는 제공하는 클래스 중 Object
//모든 클래스의 부모 클래스 -> 모든클래스는 원하지 않아도 Object를 상속받음
//Pride클래스 타입을 인스턴스화 하면 부모클래스인 Object가 제공하는 toString()호출할 수 있다.
public class Pride extends Object{

    //extends - Object에 상속됨
    public String toString(){
        return "I am Pride Car";
    }//// end of String class

    public static void main(String[] args) {
        Pride car = new Pride();
        //car는 인스턴스화에서 선언된 변수 이므로 인스턴스변수라고 한다.
        //car를 이용해서 변수나 메소드를 호출할 수 있다.
        //이 때 호출은 전변만 가능(지변 불가)
        //소스파일에는 전변이 없어서 호출 할 수 없다.
        //그러나 toString()은 재정의함. 그래서 부모클래스가 제공하는 toString()이 호출되는게 아니라 이 파일 안에서 구현한 메소드가 호출.
        System.out.println(car);
        //이 코드에서는 toString()이 구현되어있어 주소번지가 출력되지 않고 return문구가 출력 됨
        System.out.println(car.toString());

    }
}
