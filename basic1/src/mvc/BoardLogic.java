package mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardLogic {
    BoardDao dao = new BoardDao();
    //insert here - 객체 주입코드 - BoardDao - 생성자 호출(인스턴스화)
    public BoardVO boardInsert(BoardVO pbvo) {
        System.out.println("Board Insert called");
        BoardVO rbvo = new BoardVO();
        return rbvo;
    }
    public BoardVO boardUpdate(BoardVO pbvo) {
        System.out.println("Board Update called");
        BoardVO rbvo = new BoardVO();
        return rbvo;
    }
    public BoardVO boardDelete(BoardVO pbvo) {
        System.out.println("Board Delete called");
        BoardVO rbvo = new BoardVO();
        return rbvo;
    }
    //SELECT * FROM mvc_board WHERE b_no = 3
    //SELECT * FROM mvc_board WHERE b_title = "여행지"
    //public Map<String,Object> boardDetail(String b_title){
    public Map<String,Object> boardDetail(int b_no){
        System.out.println("Board Detail called : " + b_no);
        Map<String,Object> map = new HashMap<String,Object>();
        map = dao.boardDetail(b_no);
        return map;
    }
    public List<Map<String,Object>> boardList(BoardVO pbvo){
        System.out.println("Board List called");
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        list = dao.boardList(pbvo);
        System.out.println("BoardLogic boardList() "+list.size());//0
        return list;
    }
}
