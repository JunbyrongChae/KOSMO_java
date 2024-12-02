package Quiz;

public class DeptDTO {
    int deptno;
    String dname;
    String loc;
    DeptDTO() {
        //0, null, null
    }
    public DeptDTO(int deptno, String dname, String loc) {
        DeptDTO[] depts = new DeptDTO[3];
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }
}
