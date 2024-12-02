SELECT n_no, n_title, n_content FROM notice1030;

-- ���̺��� Ŀ���� ���� �ٴ´�. Ŀ���� �����ϴ� �޼ҵ� �ʿ�.
-- �޼ҵ带 �������� Ŭ������ �Ǿ� �ߴ�. 
-- �׷��� ����� ���ó�� ���� �޶���Ѵٸ� �������̽�(����̽����� �޶� ���� �� �� ������ �߻�޼ҵ�� ����) - ������ ����
-- Resultset�� Ŀ���� �����̴µ� �ʿ��� next(), previous(),isFirst(), isLast() : boolean
-- �׷��� if���̳� for�� ��ȣ �ȿ��� �� �� �ִ�. 
-- preparedStatement 
--      -SELECT -> psmt.executeQuery("SELECT��") : ResultSet(�������̽�)
--      - INSERT, UPDATE, DELETE -> commit, rollback
--      - pstmt.executeUpdate("INSERT��/UPDATE��,���줨����ans"): int
-- javadoc����              

-- CRUD����(�Է�,����, ����, ��ȸ) - Model����(������ó�� + ����Ͻ� ����)
-- -> Restful API

INSERT INTO DEPT (deptno, dname, loc) VALUES(50,'�ѹ���','��õ');

--executeUpdate()

commit;

SELECT deptno FROM dept
INTERSECT
SELECT deptno FROM emp;

SELECT empno FROM emp;--pk -> unique index(���Ϲ��� -> ��������,NOT NULL)
--�׷��� ���̺��� access���� �ʰ� index�� �а� ��� ���
--index - ���� �����ȴ�. ���������� ���� �ִ�. - index���� ����

1) �Ľ�
2) RDBMS�� �����ȹ�� �����
3) ��Ƽ�������� �����ȹ�� �޾Ƽ� ó���Ѵ�
---> ������� : INSERT, UPDATE, DELETE
4)OPEN.. CURSOR(��ġ�� �����Ͱ� �����ϸ� TRUE, FALSE��ȯ-�ñ׳�)- Fetch...CLOSE

SELECT ename FROM emp;--������ �ȵ��ִ�. ��? �ε����� ����. ��? pk�� �ƴϴϱ�.

SELECT ename FROM emp
Order by ename asc;

SELECT /*+index_desc(emp pk_emp)*/empno
  FROM emp;
  
-- hint���� ���� ��Ƽ���������� �������� �����ȹ�� ���� ����
-- ��Ÿ������ ��Ʈ ����. ������ ��.  

SELECT /*+index_desc(emmpp pk_emp)*/empno
  FROM emp;  

--FK �ܷ�Ű, �ε����� �������� ����, �ߺ� ����.
--��������� deptno�� �μ����հ� 1:n����� �߰��� �÷��ε�, �̰��� �ܷ�Ű��� �Ѵ�.

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

--���̵� �ִ��� ���ϱ�
SELECT 1 FROM dual;

SELECT NVL(comm, 0) comm FROM emp;

SELECT
      NVL ((SELECT 1 FROM dual
         WHERE EXISTS (SELECT mem_name FROM MEMBER
                        WHERE mem_id=:user_id)
         ),-1) isID               
  FROM dual;

--���̵� ������ ��� ���ϱ�

SELECT mem_nick FROM MEMBER
 WHERE mem_id =:X
   AND mem_pw =:Y;