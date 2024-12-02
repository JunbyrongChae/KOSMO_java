package basic.collection;

import javax.swing.*;
import java.util.HashMap;
import java.util.Set;

/*********************
 변수 - 같은 타입만 담을 수 있다.
 배열 - 같은 타입만 담을 수 있다. 크기가 고정이다
 객체배열 - 다른 타입도 담을 수 있다. 그러나 크기는 고정이다.
 컬렉션프레임워크 - 다른타입도 담을 수 있다. 크기도 비고정적이다.
               - Object타입이라면 모두 담는다.(원시형은 불가능)
               - int -> Integer, double -> Double, 원시형이라도 Wrapper클래스가 있다.
 **********************/
public class MapTest2 {
    public static void main(String[] args) {
        //키-String타입만 가능, Value-Object타입이면 모두 가능
        HashMap<String, Object> map = new HashMap<>();
        map.put("kye1","value1");//String
        map.put("key2",1);//원시형은 Wrapper클래스로 자동전환됨
        map.put("key3",new JButton("key3"));
        Set<String> set = map.keySet();
        Object[] keys = set.toArray();
        for (int i = 0; i < keys.length; i++) {
            System.out.println(keys[i]+"=>"+map.get(keys[i]));
        }
    }
}
