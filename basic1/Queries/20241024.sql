SELECT deptno, dname, loc FROM dept;

INSERT INTO dept(deptno, dname, loc) values(50,'개발부','서울');

rollback;

commit;

UPDATE dept SET loc='제주' WHERE deptno=50;

DELETE FROM dept WHERE deptno = 50;
