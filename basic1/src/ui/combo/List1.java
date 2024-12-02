package ui.combo;

import java.util.ArrayList;
import java.util.List;

public class List1 {
    public List1() { }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();
        List list3 = new ArrayList();


        String name1 = new String("John");
        String name2 = new String("Jane");
        String name3 = new String("Jack");


        list.add(name1);
        list2.add(name1);
        list3.add(name1);
        list.add(name2);
        list.add(name3);


        String n1 = list.get(0);
        Object n2 = list2.get(0); // 타입 맞추기
        String n3 = (String)list3.get(0);// 타입을 캐스팅
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
    }
}
