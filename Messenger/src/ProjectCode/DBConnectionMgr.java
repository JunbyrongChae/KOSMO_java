package ProjectCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 공통코드 작성해보기
// 메소드는 슬림하게 하나의 책임만 진다. >> 재사용이 좋다.
// DB서버는 하나이고 하나의 서버를 여러 개발자들이 바라본다.
// 하나의 객체를 가지고 공유하자.(싱글톤패턴 - Spring에서 지원)
// 클래스 선언에 static을 붙인다. - 얕은 복사(원본이 하나다)
// 이것이 가능한가? - 스레드가 있어서 가능하다.하나의 자원을 여러사람이 공유(싱글스레드, 멀티스레드)
public class DBConnectionMgr {
    static DBConnectionMgr dbMgr = null;
    // 서버 (정보를 제공하는 측) - 클라이언트측(제공된 정보를 활용한다. - 2 - tier 투티어라고 한다.
    // 서버 - 중간에 밀들웨어 서버 - 클라이언트로 사용하면 3-tier 멀티티어를 사용한다.
    // java.sql.* 혹은 javax.sql.*(multi tier)참조한다. << 디비 소스 연결하는데 필요한 것들
    // 모두 인터페이스이다. Connection, PreparedStatement, ResultSet - 결정할 수 없다.
    // 왜? 디바이스마다 각각 다르게 동작해야한다. - 결정할 수 없다. >> 구현체 클래스가 구현을 한다.
    // 아래 인터페이스는 모두 메소드로 객체를 생성한다.
    Connection con;
    public final static String _DRIVER = "oracle.jdbc.driver.OracleDriver";
    public final static String _URL = "jdbc:oracle:thin:@localhost:1521:orcl11";
    public final static String _USER = "scott";
    public final static String _PW = "tiger";

    private DBConnectionMgr() { // 생성자 만들기
    }

    //메소드를 활용하여 객체를 생성하는 코드 >> 세련된 코드이다. >> 싱글톤패턴 - 시스템의 안전을 위해 사용하는 것을 흉내내는 것이다.
    // 선택적(if문 - 조건문)으로 객체를 생성한다.
    public static DBConnectionMgr getInstance() {
        if (dbMgr == null) { // if문의 조건절에서 null을 체크한다.
            dbMgr = new DBConnectionMgr();
        }
        return dbMgr;
    }

    public Connection getConnection() {
        try {
            Class.forName(_DRIVER);
            con = DriverManager.getConnection(_URL, _USER, _PW);
        } catch (ClassNotFoundException e) {
            System.err.println("드라이버 로딩 실패: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("DB 연결 실패: " + e.getMessage());
        }
        return con;
    }

    // 사용한 자원 반납하기 - 이종간에 연계하는 코드 작성
    // 사용한 자원을 닫을 때는 생성된 역순으로 닫는다.
    // 이를 생략하면 JVM의 가비지 컬렉터가 대신 해주지만, 명시적으로 구현하는 것을 권장한다.
    // JDBC API - 순수한 코드를 사용하고 있다면 -> MyBatis사용하게 된다면 -> Hibernate를 사용함으로서 레벨업해야한다.
    // Insert, Update, Delete -> Connection, PreparedStatement
    // Select -> Connection, PreparedStatement, ResultSet
    public void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.err.println("자원 해제 중 오류 발생: " + e.getMessage());
        }
    }

    public void freeConnection(Connection con, PreparedStatement pstmt) {
        try {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.err.println("자원 해제 중 오류 발생: " + e.getMessage());
        }
    }
}
