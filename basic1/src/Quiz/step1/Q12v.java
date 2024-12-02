package Quiz.step1;
//상속과 생성자
class Person{
    String name ="No name";
    public Person(String nm){name = nm;} //public Person(){} 디폴트 생성자 필요
}/*
    class Emploee extends Person{
    String empID ="0000";
    public Emploee(String id){empID = id;}
  //public Emploee(String id){  ***문자열타입***
        super("No name"); ***명시적 호출 필요***
        empID = id;

}*/
public class Q12v {
    public static void main(String[] args) {/*
        Emploee e = new Emploee("4321");
        System.out.println(e.empID);*/
    }
}
/*******************************************************
 * What is the result?
 * A. 4321
 * B. 0000
 * C. An exception is thrown at runtime.
 * D. Compilation fails because of an error in line 9. (v)
 *********************************************************/