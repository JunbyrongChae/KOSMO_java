package day5.variable;
/*
7566 - scott - 1900.56
7499 - tiger - 2700.00
7390 - king - 3100.00
 */
public class EmpSimulation {
    public static void main(String[] args) {
        //변수 이름은 같지만 주소값이 다름.
        Emp emp = new Emp();
        //새로운 객체 생성 - 깊은복사
        System.out.println(emp);
        emp.empno = 7566;
        emp.ename = "scott";
        emp.salary = 1900.56;
        System.out.println(emp.empno);//7566
        emp = null;
        emp = new Emp(); //null로 초기화 되었다가 새로 인스턴스화
        System.out.println(emp);
        emp.empno = 7499;
        emp.ename = "tiger";
        emp.salary = 2700.00;
        System.out.println(emp.empno);//7499
        emp = null;
        //null초기화 했다가 다시 인스턴스화 할때
        //기존에 참조되던 객체가 candidate상태가 됨
        //명시적으로 사용한 자원에 대해서 반납처리 하는것을 권장함.
        emp = new Emp();//변수 이름도 같고 타입도 같지만 새로운 객체
        System.out.println(emp.empno);//0 입력 순서대로 출력
        emp.empno = 7390;
        emp.ename = "king";
        emp.salary = 3100.00;
        System.out.println(emp);
        System.out.println(emp.empno);//7390

        Emp scott = new Emp();
        scott.empno = 7566;
        scott.ename = "scott";
        scott.salary = 1900.56;
        System.out.println(scott);
        System.out.println(scott.empno);
        Emp tiger = new Emp();
        tiger.empno = 7499;
        tiger.ename = "tiger";
        tiger.salary = 2700.00;
        System.out.println(tiger);
        System.out.println(tiger.empno);
        Emp king = new Emp();
        king.empno = 7390;
        king.ename = "king";
        king.salary = 3100.00;
        System.out.println(king);
        System.out.println(king.empno);

    }
}
