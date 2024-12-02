package classes.day6;

import java.util.ArrayList;
import java.util.List;

public class ListMain2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        System.out.println(list.size());//0
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list.size());//3
        for (String str : list) {
            System.out.println(str);
        }//A B C

        boolean isOK = list.remove("B");
        System.out.println(isOK);//true
        String result = list.remove(1);
        System.out.println(result);//C
        System.out.println(list.isEmpty());//false

        if(list.contains("A")){
            System.out.println("A is in list");
        }else{
            System.out.println("A is not in list");
        }//A is in list

        list.remove(0);
        System.out.println(list.isEmpty());//true
    }
}
