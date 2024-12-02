package classes.day4;

public class ArrayDept {
    public static void main(String[] args) {
        Dept[] depts = new Dept[]{new Dept(10,"ACCOUNTING","NEW YORK"),new Dept(20,"RESEARCH","DALLAS"),new Dept(30,"SALES","CHICAGO")};
        for(int i = 0; i < depts.length; i++) {
            System.out.println(depts[i]);
            System.out.println(depts[i].getDeptno()+","+depts[i].getDname()+","+depts[i].getLoc());
        }
    }
}
