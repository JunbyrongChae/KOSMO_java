package mvc;

public class BoardVO {
    private int b_no;//글 번호
    private String b_title;//글 제목
    private String b_writer;//작성자
    private String b_content;//글내용
    private int b_hit;//조회수
    private String b_date;//작성일
    //화면에서 컨트롤계층으로 보낼 메시지 저장
    //selectAll, selectOne, insert, update, delete
    private String command = null;
    //오라클 서버에 DML요청시 돌려받는 값을 담기
    private int result = -1;//1이면 입력|수정|삭제 성공, 0이면 실패
    public int getB_no() {
        return b_no;
    }
    public void setB_no(int b_no) {
        this.b_no = b_no;
    }
    public String getB_title() {
        return b_title;
    }
    public void setB_title(String b_title) {
        this.b_title = b_title;
    }
    public String getB_writer() {
        return b_writer;
    }
    public void setB_writer(String b_writer) {
        this.b_writer = b_writer;
    }
    public String getB_content() {
        return b_content;
    }
    public void setB_content(String b_content) {
        this.b_content = b_content;
    }
    public int getB_hit() {
        return b_hit;
    }
    public void setB_hit(int b_hit) {
        this.b_hit = b_hit;
    }
    public String getB_date() {
        return b_date;
    }
    public void setB_date(String b_date) {
        this.b_date = b_date;
    }
    public String getCommand() {
        return command;
    }
    public void setCommand(String command) {
        this.command = command;
    }
    public int getResult() {
        return result;
    }
    public void setResult(int result) {
        this.result = result;
    }
}
