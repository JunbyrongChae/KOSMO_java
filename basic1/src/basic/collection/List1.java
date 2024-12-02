package basic.collection;

import jdbc.book.BookVO;

import java.util.ArrayList;
import java.util.List;

public class List1 {
    public static void main(String[] args) {
        List<BookVO> list = new ArrayList<>();
        BookVO bvo =new BookVO();
        //b_no=0, b_name=null, b_author=null
        //1) settermathod, 2) 생성자
        bvo.setB_no(1);
        bvo.setB_name("test");
        bvo.setB_author("test");
        System.out.println(bvo.getB_no()+","+bvo.getB_name()+","+bvo.getB_author());
        bvo = new BookVO(2,"test2","test2","test2",null,null,null,null);
        list.add(bvo);
        System.out.println(bvo.getB_no()+","+bvo.getB_name()+","+bvo.getB_author());
        bvo = new BookVO(3,"test3","test3","test3",null,null,null,null);
        list.add(bvo);
        bvo = new BookVO(4,"test4","test4","test4",null,null,null,null);
        list.add(bvo);
        System.out.println(list.size());
        for (int i=0;i<list.size();i++) {
            BookVO rbvo = list.get(i);
            System.out.println(rbvo.getB_no()+","+rbvo.getB_name()+","+rbvo.getB_author());
        }
    }
}
