package basic.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Map1 {
    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("b_no", 5);
        map.put("b_name", "name5");
        map.put("b_author", "author5");
        list.add(map);
        map = new HashMap<>();
        map.put("b_no", 6);
        map.put("b_name", "name6");
        map.put("b_author", "author6");
        list.add(map);
        map = new HashMap<>();
        map.put("b_no", 7);
        map.put("b_name", "name7");
        map.put("b_author", "author7");
        list.add(map);
        map = new HashMap<>();
        map.put("b_no", 8);
        map.put("b_name", "name8");
        map.put("b_author", "author8");
        list.add(map);
        System.out.println(list.size());
        for (Map<String, Object> map2 : list) {
            System.out.println(map2.get("b_no") + "," + map2.get("b_name") + "," + map2.get("b_author") + ","+map2.get("b_publish"));
        }
    }
}
