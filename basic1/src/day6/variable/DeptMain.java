package day6.variable;
class Dept{
    int deptno; //디폴트 0
    String dname;  //null
    String loc; //null
}//////////////end of Dept
public class DeptMain {
    void effectParam(Dept dept){
        //dept = new Dept(); //p = new Param();
        dept.deptno = 100;
        System.out.println("Sub deptno : No."+dept.deptno); //main보다 먼저 출력
    }////////////////end of effectParam
    public static void main(String[] args) {
        DeptMain obj = new DeptMain();
        Dept dept = new Dept();
        obj.effectParam(dept);//effectParam을 호출했기에 먼저 출력
        System.out.println("Main deptno : No."+dept.deptno);//두번째 출력
        System.out.println(dept); //@27973e9b
        dept = new Dept();
        dept.deptno = 500;
        System.out.println("Main deptno : No."+dept.deptno);//세번째 출력
        System.out.println(dept);//@312b1dae
    }////////////////end of main
}////////////////////end of DeptMain
