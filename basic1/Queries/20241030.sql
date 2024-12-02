CREATE OR REPLACE procedure SCOTT.proc_login(p_id in varchar2
,p_pw in varchar2, status out number, msg out varchar2)
IS
BEGIN
    SELECT NVL((SELECT 1 FROM dual --아이디가 존재하면
                 WHERE EXISTS(SELECT mem_name FROM member
                               WHERE mem_id =p_id)
              ),-1) into status
      FROM dual;
    IF status = 1 THEN --1이면 비번도 검사해 볼까
       SELECT NVL ((SELECT mem_name FROM member
                     WHERE mem_id =p_id
                       AND mem_pw = p_pw),'비밀번호가 틀립니다.') into msg
        FROM dual;
    ELSE
        msg:='아이디가 존재하지 않습니다.';
    END IF;
END;

SELECT * FROM ZIPCODE_T;

SELECT ZIPCODE, ADDRESS FROM ZIPCODE_T;

SELECT ZDO FROM ZIPCODE_T;

SELECT DISTINCT(ZDO) FROM ZIPCODE_T;

SELECT DISTINCT(ZDO) FROM ZIPCODE_T
ORDER BY ZDO ASC;

SELECT DISTINCT(ZDO) FROM ZIPCODE_T
ORDER BY ZDO DESC;

CREATE TABLE notice1030(
    n_no number(5) constraints notice1030_no_pk primary key,
    n_title varchar2(100),
    n_writer varchar2(30),
    n_content varchar2(4000),
    n_date varchar2(30)
); --DDL

-- dual : 오라클에서 제공하는 로우1개 컬럼1개를 갖는 가상 테이블이름입니다.

SELECT sysdate From dual;

SELECT to_char(sysdate,'YYYY-MM-DD')
      ,to_char(sysdate,'YYYY-MM-DD HH:MI:SS AM')
  FROM dual;
  
SELECT 1, 2, 3 FROM dual;

SELECT 1 FROM dual
UNION ALL
SELECT 2 FROM dual
UNION ALL
SELECT 3 FROM dual;

SELECT seq_notice1030.nextval FROM dual;

insert into notice1030(n_no,n_title, n_writer, n_content, n_date)
values(seq_notice1030.nextval,'공지제목1','치타','공지제목1내용',to_char(sysdate, 'YYYY-MM-DD'));

insert into notice1030(n_no,n_title, n_writer, n_content, n_date)
values(seq_notice1030.nextval,'공지제목2','호랑이','공지제목2내용',to_char(sysdate, 'YYYY-MM-DD'));

insert into notice1030(n_no,n_title, n_writer, n_content, n_date)
values(seq_notice1030.nextval,'공지제목3','표범','공지제목3내용',to_char(sysdate, 'YYYY-MM-DD'));

commit;