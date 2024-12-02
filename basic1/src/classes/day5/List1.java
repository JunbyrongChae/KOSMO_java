package classes.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class List1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();// <String>
        System.out.println(list instanceof ArrayList<String>);//boolean
        //List는 인터페이스이다.
        //List는 구현체클래스를 갖고있다
        List<String> list2 = new ArrayList<>();// <String>

        //단독으로 인스턴스화 불가
        //인터페이스는 추상메소드만 갖고있어 오른쪽 사용 불가.
        //반드시 구현체클래스가 와야 한다
        //List<String> list3 = new List<>();
        //구현체 클래스가 추상메소드를 구현했기 때에 올 수 있다.
        List<String> list4 = new Vector<>();
    }
}
