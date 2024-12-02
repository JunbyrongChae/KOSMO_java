package Quiz;

public class DeptMain {
    public static void main(String[] args) {
        DeptDTO[] depts = new DeptDTO[3];
        DeptDTO dto = new DeptDTO(10, "총무부", "daejeon");
        System.out.println(dto);
        depts[0] = dto;
        System.out.println(depts[0] == depts[1]);
        System.out.println(depts[1] == depts[2]);
        System.out.println(dto.deptno + "," + dto.dname + "," + dto.loc);
        dto = new DeptDTO(20, "영업부", "seoul");
        depts[1] = dto;
        System.out.println(dto.deptno + "," + dto.dname + "," + dto.loc);
        dto = new DeptDTO(30, "개발부", "busan");
        depts[2] = dto;
        System.out.println(dto.deptno + "," + dto.dname + "," + dto.loc);
        for(int i = 0; i < depts.length; i++) {
            System.out.println(depts[i].deptno + "," + depts[i].dname + "," + depts[i].loc);
        }
    }
}
