package day3.variable;
//강제형전환
public class H {
    public static void main(String[] args) {
        //int i = "1"; //불가능
        //int i = (int)"1"; //불가능
        //int i = 3.14; //오류-정수자리에 실수입력(정수<실수)
        int i = (int)3.14; //가능(하지만 출력은 정수까지만)
        System.out.println(i);//3
        double j = 3.14;
        System.out.println(j);//3.14
        //i = j; //불가능
        j = i; //가능 3.14>3.0치환>3.0
        System.out.println(j);//3.0

        //(작음)char>byte>short>int>long>Float>double(큼)
    }
}
