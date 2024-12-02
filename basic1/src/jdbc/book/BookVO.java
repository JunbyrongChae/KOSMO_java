package jdbc.book;


//그러나본인의 경우 상황에 따라 사용하지 않고 공부해야함.

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookVO {
    private int b_no;
    private String b_name;
    private String b_author;
    private String b_publish;
    private String b_info;
    private String b_img;
    //테이블에 존재하는 컬럼은 아니지만 조건검색을 위해서 필요한 변수 추가
    private String gubun = "전체";//b_name,b_author,b_publish
    private String keyword;//사용자가 입력한 조건검색 키워드 읽기와 쓰기

}


