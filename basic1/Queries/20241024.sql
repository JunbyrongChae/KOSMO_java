SELECT deptno, dname, loc FROM dept;

INSERT INTO dept(deptno, dname, loc) values(50,'���ߺ�','����');

rollback;

commit;

UPDATE dept SET loc='����' WHERE deptno=50;

DELETE FROM dept WHERE deptno = 50;