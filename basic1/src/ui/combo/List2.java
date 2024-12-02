package ui.combo;

import java.util.Vector;

class A{}
public class List2 {
    public static void main(String[] args) {
        Vector<A> v = new Vector<A>();
        v.add(new A());
        v.add(new A());
        v.add(new A());
        v.size();//3
        for(A a : v){
            System.out.println(a);
        }
        A a = v.get(0);
        A a1 = v.get(1);
        A a2 = v.get(2);
        System.out.println(a==v.get(0)); //true
        System.out.println(a1==v.get(1)); //true
        System.out.println(a2==v.get(2)); //true
        //16번 a는 candidate상태로 빠짐 - 쓰레기값 - garbage collector에 전달
        //System.gc();//candidate상태에 있는 값들을 회수
        a = new A();
        System.out.println(a==v.get(0)); //false
    }
}
