package classes.day6;

import model.vo.Tomato_Member;

import java.util.ArrayList;
import java.util.List;

public class ListMain3 {
    public static void main(String[] args) {
        List<Tomato_Member> list = new ArrayList<>();
        Tomato_Member tomato = new Tomato_Member();
        tomato.setMem_id("tomato");
        tomato.setMem_pw("123");
        tomato.setNickname("토마토");
        tomato.setName("김유신");
        list.add(tomato);
        System.out.println(tomato==list.get(0));
        System.out.println(tomato.getMem_id());
        System.out.println(tomato.getMem_pw());
        System.out.println(tomato.getNickname());
        System.out.println(tomato.getName());
        tomato = new Tomato_Member();
        tomato.setMem_id("apple");
        tomato.setMem_pw("123");
        tomato.setNickname("사과");
        tomato.setName("강감찬");
        list.add(tomato);
        System.out.println(tomato+","+list.get(1));
        System.out.println(tomato==list.get(1));
        System.out.println(tomato.getMem_id());
        System.out.println(tomato.getMem_pw());
        System.out.println(tomato.getNickname());
        System.out.println(tomato.getName());
    }
}
