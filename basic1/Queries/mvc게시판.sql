-- MVC기반 게시판 구현하기
-- 구현할 때 화면부터 시작 벡엔드로 마무리
-- or 백엔드로 시작해서 화면 나중에 마무리
-- 1. 클래스 설계
-- 2. 메서드 설계(파라미터 갯수, 리턴타입 결정)
-- DML구문을 먼저 작성해보기

-- N건 조회 CASE - 리턴타입 결정
-- 메소드명 : getBoardList():List<Map> or List<BoarsVO> ------------//or BoardVO[]-고정형이 단점일 수 있음.
SELECT b_no, b_title, b_writer,b_content,b_hit, b_date
 FROM MVC_BOARD ;
 
-- 메서드명 : getBoardDetail(b_no), getBoardList(int b_no) 
-- 1. 전체조회 메서드 하나로 두 경우 모두 처리 ???
-- 2. No! 둘이 분리해야한다.!!!!
-- ∵ 응답페이지 이름이 다름
-- 1의경우 if문 추가해야함 - 메서드 하나는 하나의 책임이 따른다.
-- 2는 각자 한가지 책임을 갖는다

-- 리턴타입은 Map(키값중복불가, 차례맞지않음) or BoardVO(getter/setter - 캡슐화) ---- !!!!!!! NOT List<> !!!!!!!
SELECT b_no, b_title, b_writer,b_content,b_hit, b_date
  FROM MVC_BOARD
 WHERE b_no =:u_no;

-- More! SELECT는 COMMIT/ROLLBACK의 대상 아님
 
-- 글쓰기 구현(입력 - insert문)
-- 컬럼명이 자바에서 변수와 비슷하다. - 하나의 컬러명에 대해 값이 각각 다름
-- 기본적으로 컬럼은 타입이 같지만 값은 다르다.(같을 때도 있다.)
--@Param - BoardVO or Map
--@return - int
-- boardInsert(BoardVO or Map) : int
INSERT INTO MVC_BOARD VALUES(SEQ_mvcboard_no.nextval, '글제목1', '글쓴이1', '내용1', 1, '2024-11-16');

INSERT INTO MVC_BOARD VALUES(SEQ_mvcboard_no.nextval, '글제목2', '글쓴이2', '내용2', 2, '2024-11-17');

INSERT INTO MVC_BOARD VALUES(SEQ_mvcboard_no.nextval, '글제목3', '글쓴이3', '내용3', 3, '2024-11-18');

INSERT INTO MVC_BOARD VALUES(SEQ_mvcboard_no.nextval, '글제목4', '글쓴이4', '내용4', 4, '2024-11-19');

INSERT INTO MVC_BOARD VALUES(SEQ_mvcboard_no.nextval, '글제목5', '글쓴이5', '내용5', 5, '2024-11-20');

-- 글수정(update문)
--@Param - BoardVO or Map
--@return - int
-- boardInsert(BoardVO or Map) : int
UPDATE MVC_BOARD 
   SET b_title = :title
      ,b_content = :content
      ,b_date = to_char(sysdate, 'YYYY-MM-DD')
 WHERE b_no = :no;
 
SELECT * FROM MVC_BOARD WHERE b_no = 2;


-- 성공이면 1 row update 실패하면 0 row update
-- 이런 리턴값을 초기화 할 때는 1이나 0을 쓰지 않는다.

-- 글삭제(delete문)
--@Param - int
--@return - int
-- boardInsert(BoardVO or Map) : int

DELETE FROM MVC_BOARD
 WHERE b_no = :no;
 
SELECT * FROM MVC_BOARD WHERE b_no = 4;
 
-- 성공이면 1 row delete 실패하면 0 row delete
-- 이런 리턴값을 초기화 할 때는 1이나 0을 쓰지 않는다.

ROLLBACK;

SELECT * FROM MVC_BOARD WHERE b_no = 4;

COMMIT;

