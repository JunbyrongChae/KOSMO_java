package jdbc.step1;
//오라클 서버와 자바 연동하기
//대화 내용을 서버에 저장하기를 구현 해 보면 어떨까?
public class EmpDTOMain {


    void m(int empno,String enam,int deptno) {
        System.out.println(empno+","+enam+","+deptno);
    }


    void m(EmpDTO empDTO) {
        System.out.println(empDTO.getEmpno()+","+empDTO.getEname()+","+empDTO.getDeptno());
    }
    public static void main(String[] args) {
        EmpDTOMain etm = new EmpDTOMain();
        EmpDTO dto2 = new EmpDTO();
        // etm.m(EmpDTO); //클래스 EmpDTO에는 변수가 세 개 선언되어있다.
        etm.m(dto2);//0,null,0
        dto2.setEmpno(8000);//private int empno; -> 8000-캡슐화
        dto2.setEname("SCOTT");
        dto2.setDeptno(50);
        etm.m(dto2);//8000,SCOTT,50
        etm.m(7566,"SMITH",20);
        EmpDTO dto = new EmpDTO();
        dto.setEmpno(7566);
        System.out.println(dto.getEmpno());
        dto.setEmpno(7499);
        System.out.println(dto.getEmpno());
    }
}
