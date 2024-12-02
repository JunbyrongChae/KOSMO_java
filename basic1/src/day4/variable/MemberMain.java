package day4.variable;

import java.sql.SQLOutput;

class Member{//static 없음 -> 인스턴스화 필요
    int age;
    String name;
    String address;
    String sex;
}
/***************************************************
3개의 변수중 하나의 변수에만 static을 붙이면
static이 추가된 변수만 최종 초기화내용으로 적용되어 출력됨
 ***************************************************/

public class MemberMain {
    public static void main(String[] args) {
        Member m1 = new Member();//인스턴스화
        m1.age = 24;
        m1.name ="John";
        m1.address ="Seoul";
        m1.sex = "male";

        Member m2 = new Member();//인스턴스화
        m2.age = 32;
        m2.name ="Maria";
        m2.address ="Busan";
        m2.sex = "female";

        Member m3 = new Member();//인스턴스화
        m3.age = 19;
        m3.name = "Jane";
        m3.address ="London";
        m3.sex = "female";

        System.out.println("Member Infomation");
        System.out.println();
        System.out.println("Member1 Name : "+m1.name);//John
        System.out.println("Member1 Age : "+m1.age);//24
        System.out.println("Member1 Address : "+m1.address);//Seoul
        System.out.println("Member1 Sex"+m1.sex);//male
        System.out.println();
        System.out.println("Member2 Name : "+m2.name);
        System.out.println("Member2 Age : "+m2.age);
        System.out.println("Member2 Address : "+m2.address);
        System.out.println("Member2 Sex"+m2.sex);
        System.out.println();
        System.out.println("Member3 Name : "+m3.name);
        System.out.println("Member3 Age : "+m3.age);
        System.out.println("Member3 Address : "+m3.address);
        System.out.println("Member3 Sex"+m3.sex);

    }
}

