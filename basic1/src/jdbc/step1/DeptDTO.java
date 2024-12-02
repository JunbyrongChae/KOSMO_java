package jdbc.step1;
public class DeptDTO {
    String dname;
    String loc;
    int deptno;
    public DeptDTO() {
        //0, null, null
    }
    public int getDeptno() {return deptno;}
    public void setDeptno(int deptno) {this.deptno = deptno;}
    public String getDname() {return dname;}
    public void setDname(String dname) {this.dname = dname;}
    public String getLoc() {return loc;}
    public void setLoc(String loc) {this.loc = loc;}

    public DeptDTO(int deptno, String dname, String loc) {
        DeptDTO[] depts = new DeptDTO[3];
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }
}
