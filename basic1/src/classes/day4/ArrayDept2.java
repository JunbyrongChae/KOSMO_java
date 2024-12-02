package classes.day4;

public class ArrayDept2 {
    public static void main(String[] args) {
        Dept[] depts = new Dept[3];
        Dept d1 = new Dept();
        Dept d2 = new Dept("ACCOUNTING");
        Dept d3 = new Dept(10, "ACCOUNTING", "NEW YORK");
        System.out.println(d1.getDeptno()+","+d1.getDname()+","+d1.getLoc());
        System.out.println(d2.getDeptno()+","+d2.getDname()+","+d2.getLoc());
        System.out.println(d3.getDeptno()+","+d3.getDname()+","+d3.getLoc());

    }
}
