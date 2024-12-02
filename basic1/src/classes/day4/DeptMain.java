package classes.day4;
//오라클에서 생성된 테이블을 자바의 클래스로 설계함
//오라클의 컬럼명은 변수로 이해
//value object역할을 수행하는 클래스로 설계
//하나의 클래스에 여러개의 멤버변수를 선언할 수 있다.
//서로 관련이 있는 하나의 로우를 담을 수 있는 클래스
//객체 배열을 사용 할 수 있다.-n개의 로우도 담을 수 있다.
//단 고정형이다. 단점-한 번 크기를 정하면 변경불가.
//Value object의 역할을 수행하는 클래스는 List, Map의 제네릭으로 사용할 수 있다.(완결) =>쿠키 / 세션 : time제어(신계level) - 인증, 인가, 상태값관리
//초기화 챙겨보기
class Dept{
    //생성자를 통해서 멤버변수의 초기화 가능
    //여러 생성자를 재정의해서 상황에 따라 선택, 호출 할 수 있다.
    //this 있/없 차이
    private int deptno=0;
    private String dname=null;
    private String loc=null;
    Dept(){}
    Dept(int deptno, String dname, String loc){
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }
    Dept(String dname){
        this.dname = dname;
    }
    public int getDeptno() {
        //접근제한자 private은 내 클래스 안에서만 접근이 가능
        //SELECT deptno, dname, loc FROM dept; -> SQL
        return deptno;
    }
    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }
    public String getDname() {
        return dname;
    }
    public void setDname(String dname) {
        this.dname = dname;
    }
    public String getLoc() {
        return loc;
    }
    public void setLoc(String loc) {
        this.loc = loc;
    }
}////////// end of Dept class

public class DeptMain {
    public static void main(String[] args) {
        Dept dept = new Dept();
        dept.setDeptno(100);
        System.out.println(dept.getDeptno());
        System.out.println(dept.getDname());
        System.out.println(dept.getLoc());
    }
}
