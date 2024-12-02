-- ���������� DB =>RDB
-- ���տ����� ���ǿ� ���� �������� ���� ����
-- ���̺��� ���� ��������.
-- ���������� ���� : 1:1, 1:n, n:n(�������� ���ǰ� �� �� ���)
-- �� �̻��� ���� ���̿��� ������ ���� ���´� 1:1,1:n
-- n:n�� �� ����� �ƴѰ�? - �����Ⱚ�� ���Ե�. ���� �� �ִ� ����� ��(���ɼ�)

SELECT EMPNO, ENAME
 FROM EMP;
 
SELECT DEPTNO, DNAME
 FROM DEPT;
 
SELECT EMPNO, ENAME, DNAME
 FROM EMP;

-- �� �μ��̸��� ������? �� ����� �μ��̸��� �˰� �ʹ�.
-- ��ȸ����� 14�� ����� ���� �μ��̸� ����Ѵ�.
--14*4 = 56���� ����� �ֳ�? - false -īŸ�þ��� �� - �ٹ��� �� �ִ� �μ��� ������ ��� ���.
-- ���� - �����ذ����̴�.

SELECT EMPNO, ENAME, DNAME
 FROM EMP, DEPT;

-- ERD(Entity Relation Diagram) - ER-WIN

-- �ϳ��� �μ��� �ٹ��ϴ� ����� ��� �ΰ���?

SELECT count (empno) FROM EMP
WHERE deptno = 10;

SELECT count (empno) FROM EMP
WHERE deptno = 20;

SELECT count (empno) FROM EMP
WHERE deptno = 30;

SELECT count (empno) FROM EMP
WHERE deptno = 40;

SELECT deptno, COUNT(empno)
 FROM EMP 
GROUP BY deptno;

SELECT deptno FROM emp
MINUS
SELECT deptno FROM DEPT;

SELECT deptno FROM DEPT
MINUS
SELECT deptno FROM EMP;

SELECT distinct(deptno) FROM EMP;

SELECT deptno FROM emp;

SELECT
       e.ename, d.dname,D.deptno
  FROM emp e, dept d
 WHERE E.DEPTNO = D.DEPTNO; 
 
 -- �μ����տ��� 40���� �ִµ� ������տ��� 40���� ����.
 --�׷��� ������ �����ʿ� ������ �÷��� �ڿ� ��ȣ�� ���� +�� ���´�.
 
SELECT
       e.ename, d.dname,D.deptno
  FROM emp e, dept d
 WHERE E.DEPTNO(+) = D.DEPTNO;     

-- Natural ����(=equal����)

-- �μ��̸��� ������ �μ���ȣ �ִ�.

-- UID��(Unique Identifier Bar)
-- ���̺� �� ��ƼƼ������ ���� �ĺ��ڸ� ǥ��
-- ����� �ַ� PK�� �ð������� ��Ÿ��
--�� ��ƼƼ�� Ư�� �Ӽ��� ���ؼ� �����ϰ� �ĺ��� �� �ֵ��� ��.
--empno, deptno : �����ĺ���(UID)
-- PK�� �ε��� ������, UNIQUE, NOT NULL
-- FK�� �ߺ��̵�, �ε��� ����.
-- emp���� empno�� PK��. �׷��� deptno�� FK�̴�.
