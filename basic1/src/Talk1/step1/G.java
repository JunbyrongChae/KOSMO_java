package Talk1.step1;

public class G {
    public static void main(String[] args) {
        //모든 클래스의 부모가 Object클래스 이라서
        //대입연산자 오른쪽에 더 큰 타입이 오는 것은 불법
        //그래도 하고 싶으면 Casting(괄호가 있는)연산자를  쓰면된다.
         String s = "Hello";
        Object obj = "World";
        s = (String)obj;
        System.out.println(s);//Hello
    }
}
