package basic.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest1 {

    public static void main(String[] args) {
     // Map<  키  ,   값   >
        Map<String, String> map1 = new HashMap<>();
        map1.put("name","나신입");
        map1.put("university","가산대");
        map1.put("address","서울시 금천구 가산동");
        map1.put("age","30");
        //map1.put("age",String.valueOf(30));

        Map<String, Object> map2 = new HashMap<>();
        map2.put("name","나신입");
        map2.put("university","가산대");
        map2.put("address","서울시 금천구 가산동");
        map2.put("age",30);
        Set<String> set = map1.keySet();
        Object keys[] = set.toArray();
        //String keys[] = set.toArray(new String[0]);
        for (int i = 0; i < keys.length; i++) {
            System.out.println(keys[i]); // name university address, age
        }
        for (int i = 0; i < keys.length; i++) {
            System.out.println(map1.get(keys[i]));// 나신입 가산대 서울시 금천구 가산동 30
        }
    }
}
