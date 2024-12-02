SELECT n_no, n_title, n_content FROM notice1030;

-- 테이블에는 커서가 따라 붙는다. 커서를 조작하는 메소드 필요.
-- 메소드를 가지려면 클래스가 되야 했다. 
-- 그런데 기능은 사용처에 따라 달라야한다면 인터페이스(디바이스마다 달라서 결정 할 수 없으면 추상메소드로 정의) - 다형성 실현
-- Resultset은 커서를 움직이는데 필요한 next(), previous(),isFirst(), isLast() : boolean
-- 그래서 if문이나 for문 괄호 안에서 쓸 수 있다. 
-- preparedStatement 
--      -SELECT -> psmt.executeQuery("SELECT문") : ResultSet(인터페이스)
--      - INSERT, UPDATE, DELETE -> commit, rollback
--      - pstmt.executeUpdate("INSERT문/UPDATE문,ㅇ띠ㄸㅆㄸans"): int
-- javadoc문법              

-- CRUD수업(입력,수정, 삭제, 조회) - Model계층(데이터처리 + 비즈니스 로직)
-- -> Restful API

INSERT INTO DEPT (deptno, dname, loc) VALUES(50,'총무부','인천');

--executeUpdate()

commit;

SELECT deptno FROM dept
INTERSECT
SELECT deptno FROM emp;

SELECT empno FROM emp;--pk -> unique index(유일무이 -> 제약조건,NOT NULL)
--그래서 테이블을 access하지 않고 index만 읽고서 결과 출력
--index - 따로 관리된다. 별도공간이 따로 있다. - index전략 수립

1) 파싱
2) RDBMS가 실행계획을 세운다
3) 옵티마이저가 실행계획을 받아서 처리한다
---> 여기까지 : INSERT, UPDATE, DELETE
4)OPEN.. CURSOR(위치에 데이터가 존재하면 TRUE, FALSE반환-시그널)- Fetch...CLOSE

SELECT ename FROM emp;--정렬이 안돼있다. 왜? 인덱스가 없다. 왜? pk가 아니니까.

SELECT ename FROM emp
Order by ename asc;

SELECT /*+index_desc(emp pk_emp)*/empno
  FROM emp;
  
-- hint문을 통해 옵티마이저에게 개발자의 실행계획을 전달 가능
-- 오타있으면 힌트 무시. 실행은 됨.  

SELECT /*+index_desc(emmpp pk_emp)*/empno
  FROM emp;  

--FK 외래키, 인덱스가 제공되지 않음, 중복 가능.
--사원집합의 deptno는 부서집합과 1:n관계로 추가된 컬럼인데, 이것을 외래키라고 한다.

SELECT count(deptno) FROM emp WHERE deptno=30;

SELECT count(deptno) FROM emp WHERE deptno=10;

SELECT distinct(deptno) FROM emp;

SELECT emp.ename, emp.sal, emp.hiredate,dept.dname
  FROM dept, emp
WHERE dept.deptno = emp.deptno;

SELECT emp.ename, emp.sal, emp.hiredate,dname
  FROM emp;

SELECT deptno FROM dept
MINUS
SELECT deptno FROM emp;

DELETE FROM dept WHERE deptno = :X;

SELECT * FROM dept WHERE deptno=50;

UPDATE dept 
  SET dname='DEVELOP'
     ,loc='JEJU' 
WHERE deptno = 50;

DELETE from dept WHERE deptno=:x;

commit;

--아이디가 있는지 비교하기
SELECT 1 FROM dual;

SELECT NVL(comm, 0) comm FROM emp;

SELECT
      NVL ((SELECT 1 FROM dual
         WHERE EXISTS (SELECT mem_name FROM MEMBER
                        WHERE mem_id=:user_id)
         ),-1) isID               
  FROM dual;

--아이디가 있으면 비번 비교하기

SELECT mem_nick FROM MEMBER
 WHERE mem_id =:X
   AND mem_pw =:Y;