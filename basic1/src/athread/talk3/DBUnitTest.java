package athread.talk3;

import com.util.DBconnectionMgr;
import jdbc.step1.DeptDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBUnitTest {
    DBconnectionMgr dbMgr = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    public DBUnitTest() {
        dbMgr = DBconnectionMgr.getInstance();
        conn = dbMgr.getConnection();
        dbTest();
    }
    public void dbTest(){
        System.out.println(conn);
        //select count(deptno) from dept -> 4
        String query = "SELECT deptno, dname, loc FROM dept";
        List<DeptDTO> list = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(query);
            //executeQuery()는 select일때 사용함, 리턴타입이 ResultSet
            //조회결과를 읽어온다. - 커서가 필요하다.
            //open....cursor....fetch...close
            rs = pstmt.executeQuery();//executeUpdate():int- INSERT, UPDATE, DELETE
            DeptDTO dto = null;
            while(rs.next()){//4바퀴 반복한다.
                //생성자 파라미터 자리로 초기화를 처리하는 것.- 권장
                dto = new DeptDTO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
                //dto = new DeptDTO(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(dto);
            }
            System.out.println(list.size());
            for(DeptDTO ddto:list){
                System.out.println(ddto.getDeptno());//4개의 주소번지 출력
            }
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        new DBUnitTest();
    }
}
