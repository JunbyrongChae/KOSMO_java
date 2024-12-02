package classes.day7;

class A1 {
    A1Main a1Main = new A1Main();
    //생성자에는 리턴이 없다, 클래스이름이 온다.
    //파라미터가 없는 생성자를 디폴트 생성자라 한다.
    A1() {
        System.out.println("A1생성자");
    }
    //생성자 파라미터 자리 name은 언제 초기화 되는가? - 생성자가 호출 될 때
    //name은 지변이다. - 인스턴스화와 관련없다.
    //멤버변수는 인스턴스화와 관령이 있다.(중요)
    A1(String name){
        System.out.println("파라미터가 있는 생성자(이름) "+name);
    }
    A1(int age){
        System.out.println("파라미터가 있는 생성자(나이) "+age);
    }
    A1(String name, int age){
        System.out.println("파라미터가 있는 생성자(이름,나이) "+name+" "+age);
    }
}

public class A1Main {
    public static void main(String[] args) {
        A1 a1 = new A1("이성계");
        A1 a2 = new A1(30);
        A1 a3 = new A1("강감찬", 50);
    }
}
