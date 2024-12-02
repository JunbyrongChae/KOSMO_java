package Quiz.step1;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    int x = 1;
    public static void main(String[] args) {
        List<Test2> list = new ArrayList<Test2>();
        System.out.println(list.size());
        Test2 t2 = new Test2();
        t2.x = 10;
        System.out.println(t2);
        list.add(t2);
        t2 = new Test2();
        t2.x = 20;
        list.add(t2);
        System.out.println(list.get(0));
        System.out.println(list.get(0).x);//10
        System.out.println(list.get(1));
        System.out.println(list.get(1).x);//20
        System.out.println(list.size());//2
        System.out.println(t2==list.get(1));//true
        System.out.println(list.get(0).x==list.get(1).x);//false
        t2.x=10;
        System.out.println(list.get(0).x==list.get(1).x);//true
    }
}
