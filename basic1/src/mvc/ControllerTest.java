package mvc;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
BoardController 에서 BoardLogic인스턴스화 하기
BoardLogic에서 BoardDao인스턴스화 하기
 */
public class ControllerTest {
    BoardController bc = new BoardController();
    //전체 조회 테스트
    public List<Map<String, Object>> boardList(BoardVO pbvo){
        System.out.println("boardList");
         List<Map<String, Object>> list = bc.boardListAll(pbvo);
         //항상 메소드의 리턴 타입이 null이 올 수 있다는 것을 잊지 말자.
        if(list != null){
            System.out.println(list.toString());
        }
        return list;
    }
    //select b_no, b_title, b_writer, b_content, b_date, b_hit from mvc_board
    //where b_no = 3;
    //BoardController에서 상세조회는 send메소드에서 처리한다.
    //send메소드 안에는 if문이 4가지 존재하고 있다.
    //4가지 메소드에 대한 호출이 if문으로 처리되고 있다.
    public BoardVO boardDetail(BoardVO pbvo){
        System.out.println("boardDetail");
        pbvo.setCommand("selectOne");
        //b_title=null, b_writer=null,
        //파라미터에 있는 pbvo와 rbVO가 서로 다르다.
        //rbvo에는 selectOne이 들어있지 않지만 pbvo에는 selectOne들어있다.
        //rbvo에는 한 건을 조회하여 조회된 결과를 담은 주소번지이다.
        BoardVO rbVO = bc.send(pbvo);//b_no = 3, command=selectOne
        System.out.println(rbVO.getResult());//1:입력성공, 0:입력실패, -1:아무것도 한게 없음
        return rbVO;
    }
    public static void main(String[] args) {
        ControllerTest ct = new ControllerTest();
        //ct.boardList()가 반환값이 null일 수있다.
        //NullPointerException일어날 수 있다.
        Scanner scanner = new Scanner(System.in);
        System.out.println("검색하고자 하는 글번호를 입력하세요.");
        //String b_title = scanner.nextLine();
        int b_no = scanner.nextInt();
        BoardVO pbvo = new BoardVO();
        pbvo.setB_no(b_no);
        BoardVO rbVO = ct.boardDetail(pbvo);
        System.out.println(rbVO.getB_no() +", "+ pbvo.getB_no());// 1, 1
        System.out.println(rbVO.getCommand() +", "+ pbvo.getCommand()); // null, selectOne
    }
}
