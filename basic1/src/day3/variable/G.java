package day3.variable;

public class G {

    public static void main(String[] args) {
        //String s = 1; //String은 정수타입이 아님
        int i =1;
        String s1 = "1";
        String s2 = "";
        String s3 = "1";
        System.out.println(s1+s3);//11
        System.out.println(i+i);//2
        System.out.println(i+i+"3");//23 -> int+String=String
        System.out.println(i+"3"+i);//131 String에서 +는 붙여쓰기다.(덧셈X)
        System.out.println(i+"3"+i+2);//1312
        System.out.println(i+"3"+(i+2));//133
        System.out.println(i+i+Integer.parseInt("3"));//5
        //Integer : 원시형 int의 클래스이름.-Wrapper class
    }
}
