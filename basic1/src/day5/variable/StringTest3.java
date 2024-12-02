package day5.variable;

public class StringTest3 {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("Hello");
        StringBuilder sb2 = new StringBuilder("Hello");//sb1과 같은 문구지만 객체가 다름
        //StringBuilder sb3 = "Hello";
        System.out.println("before"+sb1);//Hello
        System.out.println(sb1==sb2);
        System.out.println(sb1.equals(sb2));
        sb1.append(" World"); //=sb1+" World" //Hello World
        System.out.println("after"+sb1);//Hello World

        //아래의 경우 String타입의 클래스가 3번 만들어짐
        //String으로 여러 문자열을 만들게 되면 불변객체라서 반드시 대입연산자로 추가된 문자열을 재정의 해야함. = 두번 생성됨
        String query = "SELECT ename, empno";//1번
        System.out.println("query"+query);
        query = query + " FROM emp";//2번
        System.out.println("query"+query);
        query = query + "WHERE salary>3000";//3번 생성
        System.out.println("query"+query);

        StringBuilder query1 = new StringBuilder();
        query1.append("SELECT ename, empno");//1번
        System.out.println("query1"+query1);
        query1.append(" FROM emp");//2번
        System.out.println("query1"+query1);
        query1.append("WHERE salary>3000");//3번 생성
        System.out.println("query1"+query1);
    }
}
