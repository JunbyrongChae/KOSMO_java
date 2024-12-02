CREATE OR REPLACE procedure SCOTT.proc_login(p_id in varchar2
,p_pw in varchar2, status out number, msg out varchar2)
IS
BEGIN
    SELECT NVL((SELECT 1 FROM dual --���̵� �����ϸ�
                 WHERE EXISTS(SELECT mem_name FROM member
                               WHERE mem_id =p_id)
              ),-1) into status
      FROM dual;
    IF status = 1 THEN --1�̸� ����� �˻��� ����
       SELECT NVL ((SELECT mem_name FROM member
                     WHERE mem_id =p_id
                       AND mem_pw = p_pw),'��й�ȣ�� Ʋ���ϴ�.') into msg
        FROM dual;
    ELSE
        msg:='���̵� �������� �ʽ��ϴ�.';
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

-- dual : ����Ŭ���� �����ϴ� �ο�1�� �÷�1���� ���� ���� ���̺��̸��Դϴ�.

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
values(seq_notice1030.nextval,'��������1','ġŸ','��������1����',to_char(sysdate, 'YYYY-MM-DD'));

insert into notice1030(n_no,n_title, n_writer, n_content, n_date)
values(seq_notice1030.nextval,'��������2','ȣ����','��������2����',to_char(sysdate, 'YYYY-MM-DD'));

insert into notice1030(n_no,n_title, n_writer, n_content, n_date)
values(seq_notice1030.nextval,'��������3','ǥ��','��������3����',to_char(sysdate, 'YYYY-MM-DD'));

commit;