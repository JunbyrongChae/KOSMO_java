package classes.day6;
//변수-배열-객체배열-리스트 ---맵-세션/쿠키(상태관리,시간관리)
//배열에서 3차원 배열을 쓰지 않는 건 공간이 적으면 직관이 떨어짐
//리스트나 맵 활용해서 대체할 수 있다. -> JSON,UI지원하는 DataSet객체설계
import java.util.ArrayList;
import java.util.List;
//자바의 자료구조를 지원하는 컬렉션 프레임워크가 있다. -> java.util
public class ListMain1 {
    public static void main(String[] args) {
        //인터페이스는 단독으로 인스턴스화 할 수 없다 - 반드시 구현체 클래스가 필요
        //List list = new List();
        List list2 = new ArrayList(); // 제네릭을 표현하지 않은경우 타입을 맞춰야 함.(개발자몫)
        List<String> list3 = new ArrayList<>();//제네릭을 사용하면 타입을 명시적으로 정해 줌. - 타입을 따로 맞추지 않아도 된다.
        list2.add(0,"apple");
        list2.add("pineapple");
        for(Object str : list2){
            System.out.println((String) str);
        }
        //맨 앞부터 채운다.
        //add메소드는 오버로딩이 적용된 메소드다

        list3.add("orange");
        list3.add(0,"banana");
        list3.add(1,"grape");
        for(String str : list3){
            System.out.println(str);
        }////////////////// end of for
    }////////////////////// end of main
}////////////////////////// end of class
