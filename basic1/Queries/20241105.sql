SELECT * FROM NOTICE1030;

SELECT * FROM BOOK152;

SELECT * FROM BOOK152
 WHERE b_no =:x;

INSERT INTO book152 VALUES(4,'책제목','강감찬','정철사','책내용','4.jpg');

commit;

SELECT SEQ_BOOK152_NO.NEXTVAL FROM DUAL;

SELECT SEQ_BOOK152_NO.CURRVAL FROM DUAL;

SELECT * FROM BOOK152;

SELECT COMM, NVL(COMM, 0) FROM EMP;

SELECT ENAME, COMM FROM EMP
 WHERE COMM IS NULL;
 
 SELECT ENAME, COMM FROM EMP
 WHERE COMM IS NOT NULL;
 
 SELECT ENAME, COMM FROM EMP
  ORDER BY COMM DESC;
  
SELECT * FROM BOOK152
 WHERE B_NO IN(5,6);