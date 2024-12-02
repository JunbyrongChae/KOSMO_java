package jdbc.book;

public class BookVOTest {
    public static void main(String[] args) {
        //BookVO book = new BookVO(1,"test", "test", "test", "test", "test.png");
        BookVO book = new BookVO();
        System.out.println(book.getB_no());
        System.out.println(book.getB_name());
        System.out.println(book.getB_author());
        System.out.println(book.getB_publish());
        System.out.println(book.getB_info());
        System.out.println(book.getB_img());
        book.setB_no(5);
        book.setB_name("testTitle");
        book.setB_author("testName");
        book.setB_publish("testPublisher");
        book.setB_info("testInfo");
        book.setB_img("test.png");
        System.out.println(book.getB_no());
        System.out.println(book.getB_name());
        System.out.println(book.getB_author());
        System.out.println(book.getB_publish());
        System.out.println(book.getB_info());
        System.out.println(book.getB_img());
    }
}
