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