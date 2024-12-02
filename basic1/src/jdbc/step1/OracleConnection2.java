package jdbc.step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleConnection2 {
    //변수선언
    //드라이버 클래스를 메모리에 올린다 - 제조사로부터 제공된 클래스
    public static final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
    //물리적으로 떨어져있는 오라클서버의 드라이버 이름관 IP주소,포트번호,SID이름
    //thin방식 : 멀티티어(동시접속자 많을때)에서 사용/oci방식
    public static final String _URL = "jdbc:oracle:thin:@localhost:1521:orcl11";
    //계정이름
    public static final String _USER = "scott";
    //비번
    public static final String _PW = "tiger";
    //인터페이스
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    public OracleConnection2() {
        try {
            Class.forName(_DRIVER);
            con = DriverManager.getConnection(_URL, _USER, _PW);
            System.out.println("Oracle JDBC DRIVER Loading Success");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(con);
        String sql = "SELECT EMPNO, ENAME, DEPTNO FROM EMP";
        //쿼리문 전달
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("EMPNO") + " "
                        + rs.getString("ENAME") + " "
                        + rs.getInt("DEPTNO"));
            }
        } catch (Exception e) {
            System.out.println("SQL Error : " + e.getMessage());

        }
    }

    public static void main(String[] args) {
        new OracleConnection2();
    }
}

/*
Java API를 활용 하여 오라클 서버에 접속하는 코드를 작성 해 봅니다.
1. 오라클 회사가 제공하는 드라이버 클래스(ojdbc6.jar)를 로딩한다.


 */