package ui.combo;

import classes.Day3.StringArray1;

import java.util.Vector;

public class StringArray {

    public StringArray() {

    }

    public static void main(String[] args) {
        String[] strs = null;//크기를 정할 수 없었음, 그때그때 달라서...
        //크기를 결정할 수 없으면 선언과 생성을 분리해야 한다.
        Vector<String> v = new Vector<>();
        v.add("전체");
        v.add("서울");
        v.add("경기");
        v.add("부산");
        //System.out.println(strs.length);//NullPointerException
        strs = new String[v.size()];
        strs[0] = v.get(0);
        strs[1] = v.get(1);
        strs[2] = v.get(2);
        strs[3] = v.get(3);
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        v.copyInto(strs);
        for (String str : strs) {
            System.out.println(str);
        }
    }
}
