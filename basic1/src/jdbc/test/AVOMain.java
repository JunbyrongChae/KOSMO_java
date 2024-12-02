package jdbc.test;
//생성자-메소드 오버로딩-API보는 능력
class AVO {
    private int age;
    private String name;

    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    AVO(){}
    AVO(int age){this.age = age;}
    AVO(String name){this.name = name;}
    AVO(int age, String name){this.age = age;this.name = name;}
    AVO(String name, int age){this.name = name;this.age = age;}
}
public class AVOMain {
    public static void main(String[] args) {
        //나이를 초기화 하세요
        AVO a1 = new AVO(30);
        System.out.println(a1.getAge());
        AVO a2 = new AVO("Kim");
        System.out.println(a2.getName());
        AVO a3 = new AVO(30, "Kim");
        a3.setAge(20);
        System.out.println(a3.getAge() + " " + a3.getName());
        AVO a4 = new AVO("Kim", 30);
        a4.setName("Lee");
        System.out.println(a4.getAge() + " " + a4.getName());
    }
}
