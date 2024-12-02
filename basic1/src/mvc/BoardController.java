package mvc;
/*
1. 일반화/특정화 관점에서 이해하는 방법
2. 기능의 관점에서 이해하는 방법
- 공통(DBConnectionMgr, Person) 클래스를 만들고
그로부터 상속받은 상태와 기능을 재활용해 보기
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoardController {
    BoardLogic bLogic = new BoardLogic();
    public static final String _ALL = "selectAll";//리턴타입 - List<Map<>>, List<BoardVO>
    public static final String _ONE = "selectOne";//Map or BoardVO
    public static final String _INS = "insert";//int
    public static final String _UPD = "update";//int
    public static final String _DEL = "delete";//int
    //insert,update, delete는 int
    //한건 조회는 BoardVO
    public BoardVO send(BoardVO pbvo){
        String command = pbvo.getCommand();
        BoardVO rbvo = new BoardVO();
        System.out.println("command : "+command);//selectOne
        if(_INS.equals(command)){//글등록이라면?
            System.out.println("글등록 메시지 호출 성공");
            //pbvo에는 사용자가 입력한 글제목, 글내용, 글작성자
            //insert into mvc_board values(?,?,?,,,)
            rbvo = bLogic.boardInsert(pbvo);
        }else if(_UPD.equals(command)) {//글수정이라면?
            System.out.println("글수정 메시지 호출 성공");
            bLogic.boardUpdate(pbvo);
        }else if(_DEL.equals(command)){//글삭제라면?
            System.out.println("글삭제 메시지 호출 성공");
            bLogic.boardDelete(pbvo);
        }else if(_ONE.equals(command)){//상세보기라면?
            System.out.println("글상세보기 메시지 호출 성공");
            Map<String,Object> rmap  = bLogic.boardDetail(pbvo.getB_no());
            rbvo.setB_no(Integer.parseInt(rmap.get("b_no").toString()));
            rbvo.setB_title(rmap.get("b_title").toString());
            rbvo.setB_writer(rmap.get("b_writer").toString());
            rbvo.setB_content(rmap.get("b_content").toString());
            System.out.println();
        }
        return rbvo;
    }
    //전체 조회 구현하기 와 조건 검색 구현하기 같이 공유 가능함.
    //SELECT * FROM mvc_board
    // WHERE b_title LIKE '%'||?||'%'
    // WHERE b_no = ?
    //조건절에 들어갈 값은 화면에서 결정 되는 것이다.
    public List<Map<String,Object>> boardListAll(BoardVO pbvo){
        System.out.println("전체 조회 호출 성공");
        //사용자로 부터 입력 받은 값 넘기기
        List<Map<String,Object>> bList = bLogic.boardList(pbvo);
        return bList;
    }
}
