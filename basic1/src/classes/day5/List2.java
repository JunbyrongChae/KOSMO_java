package classes.day5;

import java.util.ArrayList;
import java.util.List;

class A {

}
public class List2 {
    public static void main(String[] args) {
        List<A> list = new ArrayList<A>();
        System.out.println(list.size());
        A a = new A();
        list.add(a);
        a = new A();
        list.add(a);
        a = new A();
        list.add(a);
        System.out.println(list.size());
        //자료구조 안에 있는 모두를 다 출력할 때는 개선된 for문을 사용
        //앞에는 제네릭 타입을 적는다. 뒤에는 자료구조 클래스가 온다.
        for (A a1 : list) {//개선된for문 지원
            System.out.println(a1);
        }
    }
}
