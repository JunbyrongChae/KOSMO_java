package jdbc.book;

import com.util.DBconnectionMgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//MVC패턴 - 데이터와 관련된 것은 Model계층입니다. < CRUD작업
//SELECT, INSERT, UPDATE, DELETE
public class BookDao {
    //Sprin프레임워크가 기본적으로 객체 라이프사이클 관리하는 메커니즘
    DBconnectionMgr dbMgr = DBconnectionMgr.getInstance();//싱글톤 패턴
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    /*************************************
     ## 도서목록 조회 및 상세조회 구현

     SELECT b_no, b_name, b_author, b_publish, b_info, b_img
     FROM book152
     WHERE b_no = ? //1건 조회

     SELECT b_no, b_name, b_author, b_publish, b_info, b_img
     FROM book152 //전체조회

     @param pbvo
     @return List<BookVO> : BookVO가 한 건만 담을 수 있다.
     bList.size() = 1이면 한 건이다.
     bList.size() = 0이면 여러건이다.
     *************************************/
    public List<BookVO> getBookList(BookVO pbvo) {
        List<BookVO> bList = new ArrayList<>();
        System.out.println(bList.size());//0
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT b_no, b_name, b_author, b_publish, b_info, b_img ");
        sql.append(" FROM book152");
        if (pbvo.getB_no() != 0) {
            sql.append(" WHERE b_no = ? ");
        }else if(pbvo != null&&"b_name".equals(pbvo.getGubun())){
            sql.append(" WHERE b_name LIKE '%'||:KEYWORD||'%' ");
        }else if(pbvo != null&&"b_author".equals(pbvo.getGubun())){
            sql.append(" WHERE b_author LIKE '%'||:KEYWORD||'%' ");
        }else if(pbvo != null&&"b_publish".equals(pbvo.getGubun())){
            sql.append(" WHERE b_publish LIKE '%'||:KEYWORD||'%' ");
        }else {
            sql.append(" ORDER BY b_no ASC ");
        }
        try {
            conn = dbMgr.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            if (pbvo.getB_no() != 0) {
                pstmt.setInt(1, pbvo.getB_no());
            } else if (pbvo.getB_no()>0) {
                pstmt.setInt(1, pbvo.getB_no());
            } else if(pbvo != null&&"b_name".equals(pbvo.getGubun())){
                pstmt.setString(1, pbvo.getKeyword());
            } else if(pbvo != null&&"b_author".equals(pbvo.getGubun())){
                pstmt.setString(1, pbvo.getKeyword());
            } else if(pbvo != null&&"b_publish".equals(pbvo.getGubun())){
                pstmt.setString(1, pbvo.getKeyword());
            }
            rs = pstmt.executeQuery();
            BookVO bvo = null;
            while (rs.next()) {
                bvo = new BookVO();
                bvo.setB_no(rs.getInt("b_no"));//도서번호
                bvo.setB_name(rs.getString("b_name"));//도서명
                bvo.setB_author(rs.getString("b_author"));//저자
                bvo.setB_publish(rs.getString("b_publish"));//출판사
                bvo.setB_info(rs.getString("b_info"));//도서소개
                bvo.setB_img(rs.getString("b_img"));//이미지
                bList.add(bvo);
            }
        } catch (SQLException se) {
            System.out.println(sql.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //자원 반납하기 - 생성된 역순 -생략해도 되지만 명시적처리
            dbMgr.freeConnection(conn, pstmt, rs);
        }
        return bList;
    }

    /*******************************************
     도서삭제 구현하기

     DELETE FROM book152 WHERE b_no = ?
     * @param b_no
     * @return int = 1이면 삭제 성공. = 0이면 삭제 실패
     ******************************************/
    public int bookDelete(int b_no) {
        int result = -1;//1이면 수정 성공. 0이면 수정 실패
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM book152 WHERE b_no = ?");
        try {
            conn = dbMgr.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1, b_no);
            result = pstmt.executeUpdate();
        } catch (SQLException se) {
            System.out.println(sql.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //자원 반납하기 - 생성된 역순 -생략해도 되지만 명시적처리
            dbMgr.freeConnection(conn, pstmt, rs);
        }
        return result;
    }

    /*****************************************
     *도서정보 수정하기
      UPDATE book152
     SET b_name = ?,
         b_author = ?,
         b_publish = ?,
         b_info = ?,
         b_img = ?
     WHERE b_no = ?
     * @param bvo
     * @return int = 1이면 수정 성공. = 0이면 수정 실패
     *********************************************/
    public int bookUpdate(BookVO bvo) {
        int result = -1;//1이면 수정 성공. 0이면 수정 실패
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE book152 ");
        sql.append("   SET b_name = ?");
        sql.append("       ,b_author = ?");
        sql.append("       ,b_publish = ?");
        sql.append("       ,b_info = ?");
        sql.append("       ,b_img = ?");
        sql.append(" WHERE b_no = ?");
        try {
            conn = dbMgr.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, bvo.getB_name());
            pstmt.setString(2, bvo.getB_author());
            pstmt.setString(3, bvo.getB_publish());
            pstmt.setString(4, bvo.getB_info());
            pstmt.setString(5, bvo.getB_img());
            pstmt.setInt(6, bvo.getB_no());
            result = pstmt.executeUpdate();
        } catch (SQLException se) {
            System.out.println(sql.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //자원 반납하기 - 생성된 역순 -생략해도 되지만 명시적처리
            dbMgr.freeConnection(conn, pstmt, rs);
        }
        return result;
    }

    /*********************************************
     * 도서정보 추가하기

     INSERT INTO book152
      VALUES (?, ?, ?, ?, ?, ?)

     * @param bvo
     * @return
     ***********************************************/
    public int bookInsert(BookVO bvo) {
        int result = -1;//1이면 추가 성공. 0이면 추가 실패
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO book152 VALUES (SEQ_BOOK152_NO.NEXTVAL, ?, ?, ?, ?, ?)");
        int i =1;
        try {
            conn = dbMgr.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            //?자리를 채우는 값을 설정 할 때는 1번 부터 입니다.
            //컬럼이 추가되거나 컬럼의 순서가 바뀌면 숫자를 일일이 바꿔야 하니
            //번호 대신 변수로 처리- 후위연산자
            pstmt.setString(i++, bvo.getB_name());
            pstmt.setString(i++, bvo.getB_author());
            pstmt.setString(i++, bvo.getB_publish());
            pstmt.setString(i++, bvo.getB_info());
            pstmt.setString(i++, bvo.getB_img());
            result = pstmt.executeUpdate();
        } catch (SQLException se) {
            System.out.println(sql.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //자원 반납하기 - 생성된 역순 -생략해도 되지만 명시적처리
            dbMgr.freeConnection(conn, pstmt, rs);}
        return result;
    }
}
