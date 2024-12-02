package athread.step1;

import com.util.DBconnectionMgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TalkDao {
    DBconnectionMgr dbMgr = DBconnectionMgr.getInstance();//싱글톤패턴
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    //메서드 설계 - 리턴타입과 파라미터타입 결정할 수 있다.
    public boolean memIdCheck(String p_id) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT mem_id FROM talk_member WHERE mem_id = ?");
        try {
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, p_id);
            rs = pstmt.executeQuery();
            if(rs.next()){//rs.next()가 참이면 입력한아이디 존재함.
                if (rs.getString("mem_id")!=null) {
                    return true; //입력받은 아이디가 존재 합니다.
                }else {
                    return false; // 입력받은 아이다가 존재하지 않습니다.
                }
            }
        }catch (SQLException se){
            System.out.println(sql.toString());
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            dbMgr.freeConnection(con, pstmt, rs);
        }
        return false;
    }

    public int memJoin(JoinVO jVo) {
        int result = -1;
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO talk_member(mem_id, mem_pw, nickname, mem_name, birthday, mem_hp) ");
        sql.append(" VALUES (?, ?, ?, ?, ?, ?)");

        try {
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sql.toString());
            int i = 1;
            pstmt.setString(i++, jVo.getMem_id());
            pstmt.setString(i++, jVo.getMem_pw());
            pstmt.setString(i++, jVo.getMem_nickname());
            pstmt.setString(i++, jVo.getMem_name());
            pstmt.setString(i++, jVo.getMem_birth());
            pstmt.setString(i++, jVo.getMem_hp());
            result = pstmt.executeUpdate(); // 성공적으로 삽입되면 1 반환
        } catch (SQLException se) {
            System.out.println("[SQL 오류] memJoin: " + se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 자원 해제
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public String idFind(String mem_name, String mem_hp) {
        String find_id = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT mem_id FROM talk_member WHERE mem_name = ? AND mem_hp = ?");
        try {
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, mem_name);
            pstmt.setString(2, mem_hp);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                find_id = rs.getString("mem_id");
            }
        } catch (SQLException se) {
            System.out.println("[SQL 오류] idFind: " + se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbMgr.freeConnection(con, pstmt, rs);
        }
        return find_id;
    }

    // 로그인 처리 메서드
    public String login(String id, String pw) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT mem_id FROM talk_member WHERE mem_id = ? AND mem_pw = ?");
        String result = null;
        try {
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getString("mem_id");
            }
        } catch (SQLException se) {
            System.out.println("[SQL 오류] login: " + se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbMgr.freeConnection(con, pstmt, rs);
        }
        return result;
    }

    public String pwFind(String mem_name, String mem_id) {
        String find_pw = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT mem_pw FROM talk_member WHERE mem_name = ? AND mem_id = ?");
        try {
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, mem_name);
            pstmt.setString(2, mem_id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                find_pw = rs.getString("mem_pw");
            }
        } catch (SQLException se) {
            System.out.println("[SQL 오류] pwFind: " + se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbMgr.freeConnection(con, pstmt, rs);
        }
        return find_pw;
    }

    public String pwUpdate(String mem_id, String mem_pw) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE talk_member SET mem_pw = ? WHERE mem_id = ?");
        try {
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, mem_id);
            pstmt.setString(2, mem_pw);
            pstmt.executeUpdate();
        } catch (SQLException se) {
            System.out.println("[SQL 오류] pwUpdate: " + se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbMgr.freeConnection(con, pstmt, rs);
        }
        return mem_id;
    }
}
