-- MVC��� �Խ��� �����ϱ�
-- ������ �� ȭ����� ���� ������� ������
-- or �鿣��� �����ؼ� ȭ�� ���߿� ������
-- 1. Ŭ���� ����
-- 2. �޼��� ����(�Ķ���� ����, ����Ÿ�� ����)
-- DML������ ���� �ۼ��غ���

-- N�� ��ȸ CASE - ����Ÿ�� ����
-- �޼ҵ�� : getBoardList():List<Map> or List<BoarsVO> ------------//or BoardVO[]-�������� ������ �� ����.
SELECT b_no, b_title, b_writer,b_content,b_hit, b_date
 FROM MVC_BOARD ;
 
-- �޼���� : getBoardDetail(b_no), getBoardList(int b_no) 
-- 1. ��ü��ȸ �޼��� �ϳ��� �� ��� ��� ó�� ???
-- 2. No! ���� �и��ؾ��Ѵ�.!!!!
-- �� ���������� �̸��� �ٸ�
-- 1�ǰ�� if�� �߰��ؾ��� - �޼��� �ϳ��� �ϳ��� å���� ������.
-- 2�� ���� �Ѱ��� å���� ���´�

-- ����Ÿ���� Map(Ű���ߺ��Ұ�, ���ʸ�������) or BoardVO(getter/setter - ĸ��ȭ) ---- !!!!!!! NOT List<> !!!!!!!
SELECT b_no, b_title, b_writer,b_content,b_hit, b_date
  FROM MVC_BOARD
 WHERE b_no =:u_no;

-- More! SELECT�� COMMIT/ROLLBACK�� ��� �ƴ�
 
-- �۾��� ����(�Է� - insert��)
-- �÷����� �ڹٿ��� ������ ����ϴ�. - �ϳ��� �÷��� ���� ���� ���� �ٸ�
-- �⺻������ �÷��� Ÿ���� ������ ���� �ٸ���.(���� ���� �ִ�.)
--@Param - BoardVO or Map
--@return - int
-- boardInsert(BoardVO or Map) : int
INSERT INTO MVC_BOARD VALUES(SEQ_mvcboard_no.nextval, '������1', '�۾���1', '����1', 1, '2024-11-16');

INSERT INTO MVC_BOARD VALUES(SEQ_mvcboard_no.nextval, '������2', '�۾���2', '����2', 2, '2024-11-17');

INSERT INTO MVC_BOARD VALUES(SEQ_mvcboard_no.nextval, '������3', '�۾���3', '����3', 3, '2024-11-18');

INSERT INTO MVC_BOARD VALUES(SEQ_mvcboard_no.nextval, '������4', '�۾���4', '����4', 4, '2024-11-19');

INSERT INTO MVC_BOARD VALUES(SEQ_mvcboard_no.nextval, '������5', '�۾���5', '����5', 5, '2024-11-20');

-- �ۼ���(update��)
--@Param - BoardVO or Map
--@return - int
-- boardInsert(BoardVO or Map) : int
UPDATE MVC_BOARD 
   SET b_title = :title
      ,b_content = :content
      ,b_date = to_char(sysdate, 'YYYY-MM-DD')
 WHERE b_no = :no;
 
SELECT * FROM MVC_BOARD WHERE b_no = 2;


-- �����̸� 1 row update �����ϸ� 0 row update
-- �̷� ���ϰ��� �ʱ�ȭ �� ���� 1�̳� 0�� ���� �ʴ´�.

-- �ۻ���(delete��)
--@Param - int
--@return - int
-- boardInsert(BoardVO or Map) : int

DELETE FROM MVC_BOARD
 WHERE b_no = :no;
 
SELECT * FROM MVC_BOARD WHERE b_no = 4;
 
-- �����̸� 1 row delete �����ϸ� 0 row delete
-- �̷� ���ϰ��� �ʱ�ȭ �� ���� 1�̳� 0�� ���� �ʴ´�.

ROLLBACK;

SELECT * FROM MVC_BOARD WHERE b_no = 4;

COMMIT;

