package ProjectCode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TalkDao {
    // DB 연결 관리 객체
    DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();

    // 1. 사용자 로그인 (닉네임과 IP로 로그인 처리)
    public String log_in(String id, String pw) {
        String result = null;
        String sql = "SELECT mem_id, nickname, status_msg FROM talk_member WHERE mem_id = ? AND mem_pw = ?";
        try (Connection conn = dbMgr.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    result = rs.getString("nickname");
                }
            }
        } catch (SQLException se) {
            System.out.println("[SQL 오류] login: " + se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 2. 메시지 전송 (채팅)
    public int sendMessage(String sender, String receiver, String msg) {
        int result = 0;
        String sql = "INSERT INTO chat_messages (sender, receiver, messages) VALUES (?, ?, ?)";

        try (Connection conn = dbMgr.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sender);
            pstmt.setString(2, receiver);
            pstmt.setString(3, msg);
            result = pstmt.executeUpdate();
        } catch (SQLException se) {
            System.out.println("[SQL 오류] sendMessage: " + se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 3. 메시지 수신 (채팅)
    public List<String> getMessages(String mem_nick) {
        List<String> messages = new ArrayList<>();
        String sql = "SELECT sender, message FROM chat_messages WHERE receiver=? ORDER BY timestamp DESC";

        try (Connection conn = dbMgr.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, mem_nick);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String msg = "From: " + rs.getString("sender") + " - " + rs.getString("message");
                    messages.add(msg);
                }
            }
        } catch (SQLException se) {
            System.out.println("[SQL 오류] getMessages: " + se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return messages;
    }

    // 4. 아이디 체크
    public boolean memIdCheck(String p_id) {
        boolean exists = false;
        String sql = "SELECT mem_id FROM talk_member WHERE mem_id = ?";

        try (Connection conn = dbMgr.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, p_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                exists = rs.next();
            }
        } catch (SQLException se) {
            System.out.println("[SQL 오류] memIdCheck: " + se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exists;
    }

    // 5. 회원가입
    public int memJoin(String mem_id,String mem_pw,String mem_nickname,String mem_name,String mem_birth,String mem_hp) {
        int result = -1;
        String sql = "INSERT INTO talk_member (mem_id, mem_pw, nickname, mem_name, birthday, mem_hp) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = dbMgr.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int i = 1;
            pstmt.setString(i++, mem_id);
            pstmt.setString(i++, mem_pw);
            pstmt.setString(i++, mem_nickname);
            pstmt.setString(i++, mem_name);
            pstmt.setString(i++, mem_birth);
            pstmt.setString(i++, mem_hp);
            result = pstmt.executeUpdate();
        } catch (SQLException se) {
            System.out.println("[SQL 오류] memJoin: " + se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // 6. 아이디 찾기
    public String idFind(String mem_name, String mem_hp) {
        String find_id = null;
        String sql = "SELECT mem_id FROM talk_member WHERE mem_name = ? AND mem_hp = ?";

        try (Connection conn = dbMgr.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, mem_name);
            pstmt.setString(2, mem_hp);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    find_id = rs.getString("mem_id");
                }
            }
        } catch (SQLException se) {
            System.out.println("[SQL 오류] idFind: " + se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return find_id;
    }

    // 7. 비밀번호 찾기
    public String pwFind(String mem_name, String mem_id) {
        String find_pw = null;
        String sql = "SELECT mem_pw FROM talk_member WHERE mem_name = ? AND mem_id = ?";

        try (Connection conn = dbMgr.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, mem_name);
            pstmt.setString(2, mem_id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    find_pw = rs.getString("mem_pw");
                }
            }
        } catch (SQLException se) {
            System.out.println("[SQL 오류] pwFind: " + se.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return find_pw;
    }
}
