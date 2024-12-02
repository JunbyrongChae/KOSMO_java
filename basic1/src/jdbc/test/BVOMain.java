package jdbc.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
class BVO {
    private int age;
    private String name;
    BVO(String name, int age) {this.age = age;this.name = name;}
}
public class BVOMain {
    public static void main(String[] args) {
        BVO b1 = new BVO(30, "홍길동");
        System.out.println(b1.getAge()+" "+b1.getName());
        b1.setAge(20);
        b1.setName("이순신");
        System.out.println(b1.getAge()+" "+b1.getName());
        BVO b2 = BVO.builder().age(40).name("강감찬").build();
        System.out.println(b2.getAge()+" "+b2.getName());
        BVO b3 = new BVO("신사임당", 50);
        System.out.println(b3.getAge()+" "+b3.getName());
        b3=new BVO(60,"신사임당");
        System.out.println(b3.getAge()+" "+b3.getName());
    }
}
