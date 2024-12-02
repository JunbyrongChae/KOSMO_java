package inheritance.step1;

public class Test {
    public static void main(String[] args) {
        Person p1 = null;
        p1 = new Person("Hong", "GilDong");
        System.out.println(p1 instanceof Person); //true
        System.out.println(p1 instanceof Student); // false
        System.out.println(p1 instanceof Teacher); // false
                System.out.println(p1.getFullname());
        p1 = new Student("GilDong", "Hong");
        System.out.println(p1 instanceof Person); // true
        System.out.println(p1 instanceof Student); // true
        System.out.println(p1 instanceof Teacher); // false
        System.out.println(p1.getFullname());
        Student student = new Student("Apple", "Kiwi");
        Person p2 = new Person("Banana", "Orange");
        //ClassCastException-오른쪽에 더 큰타입이 오는건 형전환 연산자로 문법은 해결 할 수 있지만 결국 문제는 발생
        //student = (Student)p2;
        System.out.println(student instanceof Person); // true
        System.out.println(student instanceof Student); // true
        //System.out.println(student instanceof Teacher); // 관계없음
        //p2 = student;
    }
}
