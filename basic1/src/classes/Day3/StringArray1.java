package classes.Day3;

public class StringArray1 {
    public static void main(String[] args) {
        String[] names = null;
        names = new String[3];//3개의 공간에 null이 들어있음
        System.out.println(names);
        System.out.println(names[0]);
        System.out.println(names[1]);
        System.out.println(names[2]);
        StringArray1[] sas = new StringArray1[3];
        StringArray1 sa = new StringArray1();
        System.out.println(sa);
        sas[0] = sa;
        sas[1] = sa;
        System.out.println(sas[0]==sa);//주소번지 비교 - true //equals와 다름
        System.out.println(sas[1]==sa);//주소번지 비교 - true
        System.out.println(sas[2]==sa);//주소번지 비교 - false
    }
}
