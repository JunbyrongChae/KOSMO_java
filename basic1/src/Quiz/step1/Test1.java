package Quiz.step1;
class T{
    int a =1;
    T(){
        System.out.println("T");
    }
    T(Test1 test1){
        System.out.println("test1");
        System.out.println(test1);
        System.out.println(this.a);
    }
}
public class Test1 {
    T t = new T(this);
    public static void main(String[] args) {
        Test1 t = new Test1();
        System.out.println(t);
        Test1 t1 = new Test1();
        System.out.println(t1.t.a);
    }
}
