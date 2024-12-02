package basic.collection;

import java.util.ArrayList;
import java.util.List;

class List22{
    List<String> names = new ArrayList<>();
    List22 (){
        System.out.println("default constructor");
        names.add("Jhon");
        names.add("Scott");
        names.add("Tiger");
    }
    List22(int i){
        System.out.println("method overloading");
        names = null;
    }
}
public class List21 {
    public static void main(String[] args) {
        List22 list = new List22();
        System.out.println(list.names);
        List22 list2 = new List22(1);
        System.out.println(list2.names);
    }
}
