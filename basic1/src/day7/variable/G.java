package day7.variable;

public class G {
    public static void main(String[] args) {
        /* 모든 클래스의 부모가 Object클래스라서
        대입연산자 오른쪽에 더 큰타입이 오지 못한다.
        그래도 입력하려면 Casting연산자를 쓴다.
         */
        String s = "abc";
        Object obj = "ABC";
        s=(String)obj;
        System.out.println(s);
    }
}
