-- 관계지향형 DB =>RDB
-- 집합에대한 정의에 따라 여러개로 나눠 관리
-- 테이블의 수가 많아진다.
-- 관계형태의 종류 : 1:1, 1:n, n:n(업무적인 정의가 덜 된 경우)
-- 둘 이상의 집합 사이에서 가능한 관계 형태는 1:1,1:n
-- n:n은 왜 대상이 아닌가? - 쓰레기값이 포함됨. 있을 수 있는 경우의 수(가능성)

SELECT EMPNO, ENAME
 FROM EMP;
 
SELECT DEPTNO, DNAME
 FROM DEPT;
 
SELECT EMPNO, ENAME, DNAME
 FROM EMP;

-- 왜 부서이름을 적었나? 그 사원의 부서이름을 알고 싶다.
-- 조회결과는 14명 사원에 대한 부서이름 출력한다.
--14*4 = 56명의 사원이 있나? - false -카타시안의 곱 - 근무할 수 있는 부서의 종류가 모두 출력.
-- 조인 - 문제해결방법이다.

SELECT EMPNO, ENAME, DNAME
 FROM EMP, DEPT;

-- ERD(Entity Relation Diagram) - ER-WIN

-- 하나의 부서에 근무하는 사원이 몇명 인가요?

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
 
 -- 부서집합에는 40번이 있는데 사원집합에는 40번이 없다.
 --그래도 봉려면 없는쪽에 조건절 컬럼명 뒤에 괄호를 쓰고 +를 적는다.
 
SELECT
       e.ename, d.dname,D.deptno
  FROM emp e, dept d
 WHERE E.DEPTNO(+) = D.DEPTNO;     

-- Natural 조인(=equal조인)

-- 부서이름은 없지만 부서번호 있다.

-- UID바(Unique Identifier Bar)
-- 테이블에 각 엔티티에대한 고유 식별자를 표시
-- 대상은 주로 PK를 시각적으로 나타냄
--각 엔티티가 특정 속성을 통해서 고유하게 식별될 수 있도록 함.
--empno, deptno : 고유식별자(UID)
-- PK는 인덱스 제공됨, UNIQUE, NOT NULL
-- FK는 중복이됨, 인덱스 없다.
-- emp에서 empno는 PK다. 그러나 deptno는 FK이다.
