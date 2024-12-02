package jdbc.book;

import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.util.List;

public class BookDaoTest {
    JFrame frame = new JFrame();
    BookDao bookDao = new BookDao();

    public int bookUpdate(BookVO pbvo) {//추천
        int result = -1;
        pbvo = new BookVO();
        pbvo.setB_name("추천");
        pbvo.setB_author("추천");
        pbvo.setB_publish("추천");
        pbvo.setB_info("");
        pbvo.setB_img("");
        pbvo.setB_no(5);
        result = bookDao.bookUpdate(pbvo);
        return result;
    }
    public int bookUpdate(int b_no, String b_name, String b_author, String b_publish) {//추천
        int result = -1;

        return result;
    }
    public int bookDeleteTest(int b_no) {
        int result = -1;
        result = bookDao.bookDelete(b_no);
        return result;
    }
    public void getBookListTest() {
        System.out.println("getBookListTest호출 성공");
        BookDao bookDao = new BookDao();
        BookVO pbvo = new BookVO();
        pbvo.setB_no(0);
        List<BookVO> bList = bookDao.getBookList(pbvo);
        System.out.println(bList.size());
        System.out.println(bList);
        System.out.println(bList.get(3).getB_no());
        System.out.println(bList.get(3).getB_name());
        System.out.println(bList.get(3).getB_author());
        //System.out.println(bList.get(3).getB_publish());
    }
    public void bookUpdateTest() {

    }
    public static void main(String[] args) {
        BookDaoTest bdt = new BookDaoTest();
        int result = -1;
        result = bdt.bookUpdate(null);
        if(result == 1) {
            JOptionPane.showMessageDialog(bdt.frame, "UpdateTest 성공");
        }else {
            JOptionPane.showMessageDialog(bdt.frame, "UpdateTest 실패");
        }
        /*
        result = bdt.bookDeleteTest(4);
        if (result == 1) {
            JOptionPane.showMessageDialog(bdt.frame, "DeleteTest 성공");
        }else {
            JOptionPane.showMessageDialog(bdt.frame, "DeleteTest 실패");
        }
        result = -1;
        //BookVO pbvo = new BookVO(0,"test", "test", "test", "test", "test.png");
        //result = bdt.bookDao.bookInsert(pbvo);
        if (result == 1) {
            JOptionPane.showMessageDialog(bdt.frame, "UpdateTest 성공");
            bdt.getBookListTest();
        }else {
            JOptionPane.showMessageDialog(bdt.frame, "UpdateTest 실패");
            bdt.getBookListTest();
        }*/
    }
}
