package basic.generic;

import jdbc.book.BookVO;

import java.util.*;

public class List3 {
    public static void main(String[] args) {
        List list1 = new ArrayList();//제네릭 사용안함 = Object다.
        list1.add(true);
        boolean isOK = (Boolean)list1.get(0);
        System.out.println("제네릭 X : "+isOK);//true
        //형 전환 연사자를 사용하지 않고 바꾸는 방법이 제네릭.
        List<Boolean> list2 = new ArrayList<>();
        list2.add(true);
        isOK = list2.get(0);//true
        System.out.println("제네릭 O : "+isOK);//true
        List<Object> list3 = new ArrayList<>();
        list3.add(false);
        isOK = (Boolean)list3.get(0);//false
        System.out.println("제네릭 O but equals list1 : "+isOK);//false
        List<BookVO> list4 = new ArrayList<>();
        BookVO bookVO = new BookVO();
        list4.add(bookVO);
        BookVO rbvo = list4.get(0);
        System.out.println(rbvo + "==" + bookVO);//true`
        List<Map<String, Object>> list5 = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("b_no", 1);
        map1.put("b_name", "name1");
        map1.put("b_author", "author1");
        list5.add(map1);
        Map<String, Object> map2 = list5.get(0);
        Object[] keys = map2.keySet().toArray();
        for (int i = 0; i < keys.length; i++) {
            System.out.println(map2.get(keys[i]));
        }
    }
}
